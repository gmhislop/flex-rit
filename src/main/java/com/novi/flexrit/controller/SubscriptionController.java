package com.novi.flexrit.controller;

import com.novi.flexrit.model.Subscription;
import com.novi.flexrit.model.SubscriptionPlan;
import com.novi.flexrit.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping("subscription-plan")
    public ResponseEntity<List<SubscriptionPlan>> getSubscriptionPlan() {
        List<SubscriptionPlan> subscriptionPlan = subscriptionService.getSubscriptionPlan();
        return ResponseEntity.ok(subscriptionPlan);
    }

    @PostMapping("/subscription-plan")
    public ResponseEntity<String> addSubscription(@RequestBody SubscriptionPlan subscriptionPlan) {
        subscriptionService.addSubscriptionPlan(subscriptionPlan);
        return ResponseEntity.ok("data has been added");
    }

    @GetMapping("/subscription-plan/{id}")
    public ResponseEntity<SubscriptionPlan> getSubscription(@PathVariable long id) {
        Optional<SubscriptionPlan> subscription = subscriptionService.getSubscriptionPlanById(id);
        if (subscription.isPresent()) {
            return ResponseEntity.ok(subscription.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/subscription-plan/{id}")
    public ResponseEntity<String> deleteTrips(@PathVariable long id) {
        subscriptionService.deleteSubscriptionPlanById(id);
        return ResponseEntity.ok("successfully deleted");
    }

    @PostMapping("/buy-subscription")
    public ResponseEntity<String> buySubscription(@RequestBody Subscription subscription) {
        boolean output = subscriptionService.buySubscription(subscription);
        if (output) {
            return ResponseEntity.ok("Bought subscription");
        } else {
            return ResponseEntity.ok("You Already have a subscription plan");
        }
    }

    @PostMapping("/cancel-subscription")
    public ResponseEntity<String> cancelSubscription(@RequestBody Subscription subscription) {
        boolean output = subscriptionService.cancelSubscription(subscription);
        if (output) {
            return ResponseEntity.ok("Subscription for the user is cancelled");
        } else {
            return ResponseEntity.ok("Invalid subscription");
        }
    }

    @GetMapping("subscription")
    public ResponseEntity<List<Subscription>> getSubscription() {
        List<Subscription> subscription = subscriptionService.getSubscription();
        return ResponseEntity.ok(subscription);
    }


}
