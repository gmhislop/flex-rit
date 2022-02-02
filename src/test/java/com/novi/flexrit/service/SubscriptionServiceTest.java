package com.novi.flexrit.service;

import com.novi.flexrit.dto.SubscriptionDTO;
import com.novi.flexrit.model.Subscription;
import com.novi.flexrit.model.SubscriptionPlan;
import com.novi.flexrit.model.User;
import com.novi.flexrit.repository.SubscriptionPlanRepository;
import com.novi.flexrit.repository.SubscriptionRepository;
import com.novi.flexrit.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class SubscriptionServiceTest {

    @MockBean
    SubscriptionPlanRepository subscriptionPlanRepository;

    @MockBean
    SubscriptionRepository subscriptionRepository;

    @MockBean
    UserRepository userRepository;

    @Autowired
    SubscriptionService subscriptionService;

    @Test
    void buySubscription() {
        User user = new User();
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan();
        Subscription subscription = new Subscription();
        subscription.setStatus("INACTIVE");
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(user));
        Mockito.when(subscriptionPlanRepository.findById(any())).thenReturn(Optional.of(subscriptionPlan));
        Mockito.when(subscriptionRepository.findByUser(any())).thenReturn(List.of(subscription));
        Mockito.when(subscriptionRepository.save(any())).thenReturn(subscription);

        boolean result = subscriptionService.buySubscription(subscriptionDTO);
        Assertions.assertEquals(true, result);
    }

    @Test
    void buySubscriptionThrowExceptionWhenUsernotfound() {
        User user = new User();
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan();
        Subscription subscription = new Subscription();
        subscription.setStatus("INACTIVE");
        SubscriptionDTO subscriptionDTO = new SubscriptionDTO();
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.empty());
        Mockito.when(subscriptionPlanRepository.findById(any())).thenReturn(Optional.of(subscriptionPlan));
        Mockito.when(subscriptionRepository.findByUser(any())).thenReturn(List.of(subscription));
        Mockito.when(subscriptionRepository.save(any())).thenReturn(subscription);

        try {
            subscriptionService.buySubscription(subscriptionDTO);
        } catch (Exception e ){
            Assertions.assertEquals("Invalid user ID", e.getMessage());
        }

    }
}