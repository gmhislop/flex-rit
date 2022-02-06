package com.novi.flexrit.controller;

import com.novi.flexrit.dto.SubscriptionDTO;
import com.novi.flexrit.model.Subscription;
import com.novi.flexrit.model.SubscriptionPlan;
import com.novi.flexrit.service.SubscriptionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class SubscriptionControllerTest {

    @MockBean
    SubscriptionService subscriptionService;

    @Autowired
    SubscriptionController subscriptionController;

    @Test
    public void testGetSubscriptionPlan() {
        Mockito.when(subscriptionService.getSubscriptionPlan()).thenReturn(List.of(new SubscriptionPlan()));
        ResponseEntity<List<SubscriptionPlan>> result = subscriptionController.getSubscriptionPlan();
        Assertions.assertEquals(1, result.getBody().size());

    }

    @Test
    public void testAddSubscription() {
        Mockito.doNothing().when(subscriptionService).addSubscriptionPlan(any());
        ResponseEntity<String> result = subscriptionController.addSubscription(new SubscriptionPlan());
        Assertions.assertEquals("data has been added", result.getBody());
    }

    @Test
    public void testGetSubscription() {
        SubscriptionPlan subscriptionPlan = new SubscriptionPlan();
        Mockito.when(subscriptionService.getSubscriptionPlanById(1)).thenReturn(Optional.of(subscriptionPlan));
        ResponseEntity<SubscriptionPlan> result = subscriptionController.getSubscription(1);
        Assertions.assertEquals(subscriptionPlan, result.getBody());
    }

    @Test
    public void testDeleteSusbscription() {
        Mockito.doNothing().when(subscriptionService).deleteSubscriptionPlanById(1);
        ResponseEntity<String> result = subscriptionController.deleteSubscription(1);
        Assertions.assertEquals("successfully deleted", result.getBody());
    }

    @Test
    public void testBuySusbscription() {
        Mockito.when(subscriptionService.buySubscription(any())).thenReturn(true);
        ResponseEntity<String> result = subscriptionController.buySubscription(new SubscriptionDTO());
        Assertions.assertEquals("Bought subscription", result.getBody());

    }

    @Test
    public void testBuySusbscriptionNegativeCase() {
        Mockito.when(subscriptionService.buySubscription(any())).thenReturn(false);
        ResponseEntity<String> result = subscriptionController.buySubscription(new SubscriptionDTO());
        Assertions.assertEquals("You Already have a subscription plan", result.getBody());

    }

    @Test
    public void testGetSubscriptionModel() {
        Mockito.when(subscriptionService.getSubscription()).thenReturn(List.of(new Subscription()));
        ResponseEntity<List<Subscription>> result = subscriptionController.getSubscription();
        Assertions.assertEquals(1, result.getBody().size());

    }


}
