package com.novi.flexrit.service;

import com.novi.flexrit.dto.TripDTO;
import com.novi.flexrit.exception.BadRequestException;
import com.novi.flexrit.model.Trip;
import com.novi.flexrit.model.User;
import com.novi.flexrit.model.Vehicle;
import com.novi.flexrit.repository.TripRepository;
import com.novi.flexrit.repository.UserRepository;
import com.novi.flexrit.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TripService {

    @Autowired
    TripRepository tripRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    VehicleRepository vehicleRepository;

    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }

    public Optional<Trip> getTripsById(long id) {
        return tripRepository.findById(id);
    }

    public void addTrip(TripDTO trip) {
        Optional<User> user = userRepository.findById(trip.getUserId());
        if (user.isEmpty()) {
            throw new BadRequestException("Invalid user ID");
        }
        Optional<Vehicle> vehicle = vehicleRepository.findById(trip.getVehicleId());
        if (vehicle.isEmpty()) {
            throw new BadRequestException("Invalid vehicle ID");
        }
        Trip t1 = new Trip();
        t1.setUser(user.get());
        t1.setFromLocationLatitude(trip.getFromLocationLatitude());
        t1.setFromLocationLongitude(trip.getFromLocationLongitude());
        t1.setToLocationLatitude(trip.getToLocationLatitude());
        t1.setToLocationLongitude(trip.getToLocationLongitude());
        t1.setDistance(distance(trip.getFromLocationLatitude(), trip.getToLocationLatitude(), trip.getFromLocationLongitude(), trip.getToLocationLongitude()));
        t1.setDate(trip.getDate());
        t1.setUser(trip.getUser());
        t1.setVehicle(vehicle.get());
        tripRepository.save(t1);
    }

    public Optional<Trip> getTripById(long id) {
        return tripRepository.findById(id);
    }

    public void deleteTripById(long id) {
        tripRepository.deleteById(id);
    }

    public static double distance(double lat1,
                                  double lat2, double lon1,
                                  double lon2)
    {

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return(c * r);
    }

}