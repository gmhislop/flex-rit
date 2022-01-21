package com.novi.flexrit.controller;

import com.novi.flexrit.model.Vehicle;
import com.novi.flexrit.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController

public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/vehicle")
    public ResponseEntity<List<Vehicle>> getVehicle() {
        List<Vehicle> vehicle = vehicleService.getVehicle();
        return ResponseEntity.ok(vehicle);
    }

    @PostMapping("/vehicle")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle) {
        vehicleService.addVehicle(vehicle);
        return ResponseEntity.ok("data has been added");
    }

    @GetMapping("/vehicle/{id}")
    public ResponseEntity<Vehicle> getVehicle(@PathVariable long id) {
        Optional<Vehicle> vehicle = vehicleService.getVehicleById(id);
        if (vehicle.isPresent()) {
            return ResponseEntity.ok(vehicle.get());
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/vehicle/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable long id) {
        vehicleService.deleteVehicleById(id);
        return ResponseEntity.ok("successfully deleted");
    }
}
