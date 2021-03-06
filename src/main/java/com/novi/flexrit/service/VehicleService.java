package com.novi.flexrit.service;

import com.novi.flexrit.dto.VehicleDTO;
import com.novi.flexrit.exception.UserNotFoundException;
import com.novi.flexrit.model.User;
import com.novi.flexrit.model.Vehicle;
import com.novi.flexrit.repository.UserRepository;
import com.novi.flexrit.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {
    @Autowired
    VehicleRepository vehicleRepository;
    @Autowired
    UserRepository userRepository;

    public List<Vehicle> getVehicle() {
        return vehicleRepository.findAll();
    }

    public void addVehicle(VehicleDTO vehicle) {
        Optional<User> user = userRepository.findById(vehicle.getUserId());
        if (user.isEmpty()) {
            throw new UserNotFoundException("Invalid user ID");
        }
        Vehicle v1 = new Vehicle();
        v1.setUser(user.get());
        v1.setType(vehicle.getType());
        v1.setBrand(vehicle.getBrand());
        v1.setMileage(vehicle.getMileage());
        v1.setModel(vehicle.getModel());
        v1.setYearOfMake(vehicle.getYearOfMake());
        v1.setLicensePlate(vehicle.getLicensePlate());
        vehicleRepository.save(v1);
    }

    public Optional<Vehicle> getVehicleById(long id) {
        return vehicleRepository.findById(id);
    }

    public void deleteVehicleById(long id) {
        vehicleRepository.deleteById(id);
    }

}

