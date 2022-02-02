package com.novi.flexrit.dto;

import com.novi.flexrit.model.Trip;

import java.util.List;

public class ReportDTO {
    private long userId;
    private double totalDistance;
    private List<Trip> trips;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public double getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(double totalDistance) {
        this.totalDistance = totalDistance;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void setTrips(List<Trip> trips) {
        this.trips = trips;
    }
}
