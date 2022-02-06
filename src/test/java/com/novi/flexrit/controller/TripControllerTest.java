package com.novi.flexrit.controller;

import com.novi.flexrit.dto.TripDTO;
import com.novi.flexrit.model.Trip;
import com.novi.flexrit.service.TripService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class TripControllerTest {
    @MockBean
    TripService tripService;

    @Autowired
    TripController tripController;

    @Test
    public void testGettrip() {
        Mockito.when(tripService.getTrips()).thenReturn(List.of(new Trip()));
        ResponseEntity<List<Trip>> result = tripController.getTrips();
        Assertions.assertEquals(1, result.getBody().size());
    }

    @Test
    public void testAddtrip() {
        TripDTO tripDTO = new TripDTO();
        Mockito.doNothing().when(tripService).addTrip(tripDTO);
        ResponseEntity<String> result = tripController.addTrip(tripDTO);
        Assertions.assertEquals("data has been added", result.getBody());
    }

    @Test
    public void testGettripById() {
        Trip trip = new Trip();
        Mockito.when(tripService.getTripsById(1)).thenReturn(Optional.of(trip));
        ResponseEntity<Trip> result = tripController.getTrips(1);
        Assertions.assertEquals(trip, result.getBody());

    }

    @Test
    public void testGettripByIdThrowException() {
        Mockito.when(tripService.getTripById(1)).thenReturn(Optional.empty());
        ResponseEntity<Trip> result = tripController.getTrips(1);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());

    }

    @Test
    public void testDeletetrip() {
        Mockito.doNothing().when(tripService).deleteTripById(1);
        ResponseEntity<String> result = tripController.deleteTrips(1);
        Assertions.assertEquals("successfully deleted", result.getBody());
    }
}
