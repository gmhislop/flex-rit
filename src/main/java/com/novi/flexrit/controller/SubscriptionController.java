package com.novi.flexrit.controller;

import com.novi.flexrit.model.Subscription;
import com.novi.flexrit.model.Trip;
import com.novi.flexrit.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

@RestController
public class SubscriptionController {

    @Autowired
    SubscriptionService subscriptionService;

    @GetMapping("subscription/")
    public ResponseEntity<List<Subscription>> getSubscription() {
        List<Subscription> subscription = subscriptionService.getSubscription();
        return ResponseEntity.ok(subscription);
    }
    @PostMapping("/subscription")
    public ResponseEntity<String> addSubscription(@RequestBody Subscription subscription) {
        subscriptionService.addSubscription(subscription);
        return ResponseEntity.ok("data has been added");
    }
    @GetMapping("/subscription/{id}")
    public ResponseEntity<Subscription> getSubscription(@PathVariable long id) {
        Optional<Subscription> subscription = subscriptionService.getSubscriptionById(id);
        if(subscription.isPresent()) {
            return ResponseEntity.ok(subscription.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/subscription/{id}")
    public ResponseEntity<String> deleteTrips(@PathVariable long id) {
        subscriptionService.deleteSubscriptionById(id);
        return ResponseEntity.ok("successfully deleted");
    }

}
