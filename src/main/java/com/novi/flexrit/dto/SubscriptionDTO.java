package com.novi.flexrit.dto;

import java.time.LocalDateTime;

public class SubscriptionDTO {
    private long userId;
    private long subscriptionPlanId;
    private String status;
    private LocalDateTime date;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
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
