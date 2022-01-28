package com.novi.flexrit.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SubscriptionPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long subscriptonPlanId;
    private String type;
    private long price;
    private String description;
    private String duration;

    public long getSubscriptonPlanId() {
        return subscriptonPlanId;
    }

    public void setSubscriptonPlanId(long subscriptonPlanId) {
        this.subscriptonPlanId = subscriptonPlanId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
