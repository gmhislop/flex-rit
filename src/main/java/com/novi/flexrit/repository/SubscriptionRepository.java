package com.novi.flexrit.repository;

import com.novi.flexrit.model.Subscription;
import com.novi.flexrit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
    List<Subscription> findByUser(User user);

    Optional<Subscription> findByUserAndSubscriptionPlanId(User user, long subscriptionId);
}
