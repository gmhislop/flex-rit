package com.novi.flexrit.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Subscription {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long susbscriptionId;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    private long subscriptionPlanId;
    private String status;
    private LocalDateTime date;

    public long getSusbscriptionId() {
        return susbscriptionId;
    }

    public void setSusbscriptionId(long susbscriptionId) {
        this.susbscriptionId = susbscriptionId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getSubscriptionPlanId() {
        return subscriptionPlanId;
    }

    public void setSubscriptionPlanId(long subscriptionPlanId) {
        this.subscriptionPlanId = subscriptionPlanId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
