package com.novi.flexrit.controller;

import com.novi.flexrit.model.Trip;
import com.novi.flexrit.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitTemplateConfigurer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TripController {

    @Autowired
    TripService tripService;

    @GetMapping("/trip")
    public ResponseEntity<List<Trip>> getTrips() {
         List<Trip> trips = tripService.getTrips();
         return ResponseEntity.ok(trips);
    }

    @PostMapping("/trip")
    public ResponseEntity<String> addTrip(@RequestBody Trip trip) {
        tripService.addTrip(trip);
        return ResponseEntity.ok("data has been added");
    }

    @GetMapping("/trip/{id}")
    public ResponseEntity<Trip> getTrips(@PathVariable long id) {
        Optional<Trip> trips = tripService.getTripsById(id);
        if(trips.isPresent()) {
            return ResponseEntity.ok(trips.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/trip/{id}")
    public ResponseEntity<String> deleteTrips(@PathVariable long id) {
        tripService.deleteTripsById(id);
        return ResponseEntity.ok("successfully deleted");
    }


}
