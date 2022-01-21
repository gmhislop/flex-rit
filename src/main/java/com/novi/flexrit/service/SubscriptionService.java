package com.novi.flexrit.service;

import com.novi.flexrit.model.Subscription;
import com.novi.flexrit.model.SubscriptionPlan;
import com.novi.flexrit.repository.SubscriptionPlanRepository;
import com.novi.flexrit.repository.SubscriptionRepository;
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

    public List<SubscriptionPlan> getSubscriptionPlan() {
        return subscriptionPlanRepository.findAll();
    }

    public void addSubscriptionPlan(SubscriptionPlan subscriptionPlan) {
        subscriptionPlanRepository.save(subscriptionPlan);
    }

    public Optional<SubscriptionPlan> getSubscriptionPlanById(long id) {
        return subscriptionPlanRepository.findById(id);
    }

    public void deleteSubscriptionPlanById(long id) {
        subscriptionPlanRepository.deleteById(id);
    }

    public boolean buySubscription(Subscription subscription) {
        boolean haveActivePlan = false;
        List<Subscription> subscriptions = subscriptionRepository.findByUserId(subscription.getUserId());
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
        Optional<Subscription> sub = subscriptionRepository.findByUserIdAndSubscriptionPlanId(subscription.getUserId(), subscription.getSubscriptionPlanId());
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
