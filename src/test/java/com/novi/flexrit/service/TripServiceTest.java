package com.novi.flexrit.service;

import com.novi.flexrit.dto.TripDTO;
import com.novi.flexrit.exception.BadRequestException;
import com.novi.flexrit.model.Trip;
import com.novi.flexrit.model.User;
import com.novi.flexrit.model.Vehicle;
import com.novi.flexrit.repository.TripRepository;
import com.novi.flexrit.repository.UserRepository;
import com.novi.flexrit.repository.VehicleRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class TripServiceTest {

    @MockBean
    TripRepository tripRepository;
    @MockBean
    UserRepository userRepository;
    @MockBean
    VehicleRepository vehicleRepository;

    @Autowired
    TripService tripService;

    @Test
    public void testaddTrip() {
        User user = new User();
        Vehicle vehicle = new Vehicle();
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(user));
        Mockito.when(vehicleRepository.findById(any())).thenReturn(Optional.of(vehicle));
        //Mockito.when(tripRepository.save(any())).then()
        tripService.addTrip(new TripDTO());

    }

    @Test
    public void testaddTripThrowException() {
        Vehicle vehicle = new Vehicle();
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.empty());
        Mockito.when(vehicleRepository.findById(any())).thenReturn(Optional.of(vehicle));
        //Mockito.when(tripRepository.save(any())).then()
        try{
            tripService.addTrip(new TripDTO());
        } catch (Exception e) {
            Assertions.assertEquals("Invalid user ID", e.getMessage());
        }


    }

    @Test
    public void testgetTrips() {
        Mockito.when(tripRepository.findAll()).thenReturn(List.of(new Trip()));
        List<Trip> result = tripService.getTrips();
        Assert.assertEquals(1, result.size());

    }


}
