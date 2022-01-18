package com.novi.flexrit.service;

import com.novi.flexrit.model.Trip;
import com.novi.flexrit.repository.TripRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;

    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }

    public void addTrip(Trip trip) {
        tripRepository.save(trip);
    }

    public Optional<Trip> getTripsById(long id) {
        return tripRepository.findById(id);
    }


    public void deleteTripsById(long id) {
        tripRepository.deleteById(id);
    }
}
