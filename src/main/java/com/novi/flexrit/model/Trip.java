package com.novi.flexrit.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity

public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long tripId;
    private double fromLocationLatitude;
    private double fromLocationLongitude;
    private double toLocationLatitude;
    private double toLocationLongitude;
    private LocalDateTime date;
    private double distance;
    @ManyToOne(fetch = FetchType.EAGER)
    private User user;
    @ManyToOne(fetch = FetchType.EAGER)
    private Vehicle vehicle;

    public long getTripId() {
        return tripId;
    }

    public void setTripId(long tripId) {
        this.tripId = tripId;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
