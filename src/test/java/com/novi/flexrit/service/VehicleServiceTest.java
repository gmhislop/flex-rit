package com.novi.flexrit.service;

import com.novi.flexrit.dto.VehicleDTO;
import com.novi.flexrit.model.User;
import com.novi.flexrit.model.Vehicle;
import com.novi.flexrit.repository.UserRepository;
import com.novi.flexrit.repository.VehicleRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class VehicleServiceTest {
    @MockBean
    VehicleRepository vehicleRepository;
    @MockBean
    UserRepository userRepository;

    @Autowired
    VehicleService vehicleService;

    @Test
    public void getVehicleTest() {
        Vehicle vehicle = new Vehicle();
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(vehicle);
        Mockito.when(vehicleRepository.findAll()).thenReturn(vehicleList);

        List<Vehicle> result = vehicleService.getVehicle();
        Assertions.assertEquals(1, result.size());
    }

    @Test
    public void addVehicleTest() {
        User user = new User();
        Vehicle vehicle = new Vehicle();
        VehicleDTO vehicleDTO = new VehicleDTO();
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(user));
        Mockito.when(vehicleRepository.save(any())).thenReturn(vehicle);

        vehicleService.addVehicle(vehicleDTO);

    }


}
