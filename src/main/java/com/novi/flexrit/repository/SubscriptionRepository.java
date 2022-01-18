package com.novi.flexrit.repository;


import com.novi.flexrit.model.Subscription;
import com.novi.flexrit.model.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository<Subscription, Long> {
}
