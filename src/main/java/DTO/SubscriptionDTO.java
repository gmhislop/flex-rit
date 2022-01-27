package DTO;

import Model.Subscription;
import Model.User;

import java.time.LocalDateTime;

public class SubscriptionDTO {
    private User userId;
    private long subscriptionPlanId;
    private String status;
    private LocalDateTime date;


    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
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
