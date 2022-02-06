package com.novi.flexrit.service;

import com.novi.flexrit.dto.SubscriptionDTO;
import com.novi.flexrit.exception.BadRequestException;
import com.novi.flexrit.model.Subscription;
import com.novi.flexrit.model.SubscriptionPlan;
import com.novi.flexrit.model.User;
import com.novi.flexrit.repository.SubscriptionPlanRepository;
import com.novi.flexrit.repository.SubscriptionRepository;
import com.novi.flexrit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionPlanRepository subscriptionPlanRepository;

    @Autowired
    SubscriptionRepository subscriptionRepository;

    @Autowired
    UserRepository userRepository;

    public List<SubscriptionPlan> getSubscriptionPlan() {
        return subscriptionPlanRepository.findAll();
    }

    public void addSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        if (subscriptionPlan.getType() == null) {
            throw new RuntimeException("Type should be present for subscription");
        }
        subscriptionPlanRepository.save(subscriptionPlan);
    }

    public Optional<SubscriptionPlan> getSubscriptionPlanById(long id) {
        return subscriptionPlanRepository.findById(id);
    }

    public void deleteSubscriptionPlanById(long id) {
        subscriptionPlanRepository.deleteById(id);
    }

    public boolean buySubscription(SubscriptionDTO subscription) {
        boolean haveActivePlan = false;
        Optional<User> user = userRepository.findById(subscription.getUserId());
        if (user.isEmpty()) {
            throw new BadRequestException("Invalid user ID");
        }

        Optional<SubscriptionPlan> subscriptionPlan = subscriptionPlanRepository.findById(subscription.getSubscriptionPlanId());

        if (subscriptionPlan.isEmpty()) {
            throw new BadRequestException("Invalid Subscription PLAN");
        }
        List<Subscription> subscriptions = subscriptionRepository.findByUser(user.get());
        for (Subscription sub : subscriptions) {
            if (sub.getStatus().equals("ACTIVE")) {
                haveActivePlan = true;
                break;
            }
        }
        if (haveActivePlan) {
            return false;
        } else {
            Subscription s1 = new Subscription();
            s1.setUser(user.get());
            s1.setStatus("ACTIVE");
            s1.setDate(LocalDateTime.now());
            s1.setSubscriptionPlanId(subscription.getSubscriptionPlanId());
            subscriptionRepository.save(s1);
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
