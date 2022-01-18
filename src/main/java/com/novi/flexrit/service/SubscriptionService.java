package com.novi.flexrit.service;

import com.novi.flexrit.model.Subscription;
import com.novi.flexrit.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubscriptionService {

    @Autowired
    SubscriptionRepository subscriptionRepository;

    public List<Subscription> getSubscription(){ return subscriptionRepository.findAll();}

    public void addSubscription(Subscription subscription) {
        subscriptionRepository.save(subscription);
    }

    public Optional<Subscription> getSubscriptionById(long id) {
        return subscriptionRepository.findById(id);
    }

    public void deleteSubscriptionById(long id) {
        subscriptionRepository.deleteById(id);
    }

    }
