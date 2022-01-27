package Service;

import DTO.SubscriptionDTO;
import Exceptions.BadRequestException;
import Model.Subscription;
import Model.SubscriptionPlan;
import Repository.SubscriptionPlanRepository;
import Repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public List<Subscription> getSubscription() {
        return subscription.findAll();
    }

    public void addSubscription(SubscriptionDTO subscription) {
        Optional<SubscriptionPlan> userId = subscriptionRepository.findById(subscription.getUserId());
        if(userId.isEmpty()) {
            throw new BadRequestException("Invalid user ID");
        }
        Subscription s1 = new Subscription();
        s1.setUser(userId.get());
        s1.setSubscriptionPlanId(subscription.getSubscriptionPlanId());
        s1.setStatus(subscription.getStatus());
        s1.setDate(subscription.getDate());
        Subscription.save(s1);
    }

    public Optional<Subscription> getSubscriptionById(long id) {
        return subscriptionRepository.findById(id);
    }

    public void deleteVehicleById(long id) {
        subscriptionPlanRepository.deleteById(id);
    }

}
    public List<Subscription> getSubscriptionPlan() {
        return subscriptionRepository.findAll();
    }

    public void addSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        if (subscriptionPlan.getType() == null) {
            throw new BadRequestException("Type should be present for subscription");
        }
        subscriptionPlanRepository.save(subscriptionPlan);
    }

    public Optional<SubscriptionPlan> getSubscriptionPlanById(long id) {
        return subscriptionPlanRepository.findById(id);
    }

    public void deleteSubscriptionPlanById(long id) {
        subscriptionRepository.deleteById(id);
    }

    public boolean buySubscription(Subscription subscription) {
        boolean haveActivePlan = false;
        List<Subscription> subscriptions = subscriptionRepository.findByUser(subscription.getUser());
        for (Subscription sub : subscriptions) {
            if (sub.getStatus().equals("ACTIVE")) {
                haveActivePlan = true;
                break;
            }
        }
        if (haveActivePlan) {
            return false;
        } else {
            subscription.setStatus("ACTIVE");
            subscription.setDate(LocalDateTime.now());
            subscriptionRepository.save(subscription);
            return true;
        }

    }

    public boolean cancelSubscription(Subscription subscription) {
        boolean canceled = false;
        Optional<Subscription> sub = subscriptionRepository.findByUserAndSubscriptionPlanId(subscription.getUser(), subscription.getSubscriptionPlanId());
        if (sub.isPresent() && sub.get().getStatus().equals("ACTIVE")) {
            sub.get().setStatus("CANCELED");
            subscriptionRepository.save(sub.get());
            canceled = true;

        }
        return canceled;
    }

    public List<Subscription> getSubscription() {
        return subscriptionRepository.findAll();

    }
}
