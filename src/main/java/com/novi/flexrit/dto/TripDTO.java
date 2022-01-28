package com.novi.flexrit.dto;

import com.novi.flexrit.model.User;

import java.time.LocalDateTime;

public class TripDTO {
    private long userId;
    private double fromLocationLatitude;
    private double fromLocationLongitude;
    private double toLocationLatitude;
    private double toLocationLongitude;
    private LocalDateTime date;
    private double distance;
    private User user;
    private long vehicleId;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }


    public double getFromLocationLatitude() {
        return fromLocationLatitude;
    }

    public void setFromLocationLatitude(double fromLocationLatitude) {
        this.fromLocationLatitude = fromLocationLatitude;
    }

    public double getFromLocationLongitude() {
        return fromLocationLongitude;
    }

    public void setFromLocationLongitude(double fromLocationLongitude) {
        this.fromLocationLongitude = fromLocationLongitude;
    }

    public double getToLocationLatitude() {
        return toLocationLatitude;
    }

    public void setToLocationLatitude(double toLocationLatitude) {
        this.toLocationLatitude = toLocationLatitude;
    }

    public double getToLocationLongitude() {
        return toLocationLongitude;
    }

    public void setToLocationLongitude(double toLocationLongitude) {
        this.toLocationLongitude = toLocationLongitude;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public long getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(long vehicleId) {
        this.vehicleId = vehicleId;
    }
}
