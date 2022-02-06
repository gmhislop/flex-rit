package com.novi.flexrit.controller;

import com.novi.flexrit.dto.VehicleDTO;
import com.novi.flexrit.model.Vehicle;
import com.novi.flexrit.service.VehicleService;
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
public class VehicleControllerTest {

    @MockBean
    VehicleService vehicleService;

    @Autowired
    VehicleController vehicleController;

    @Test
    public void testGetVehicle() {
        Mockito.when(vehicleService.getVehicle()).thenReturn(List.of(new Vehicle()));
        ResponseEntity<List<Vehicle>> result = vehicleController.getVehicle();
        Assertions.assertEquals(1, result.getBody().size());
    }

    @Test
    public void testAddVehicle() {
        VehicleDTO vehicleDTO = new VehicleDTO();
        Mockito.doNothing().when(vehicleService).addVehicle(vehicleDTO);
        ResponseEntity<String> result = vehicleController.addVehicle(vehicleDTO);
        Assertions.assertEquals("data has been added", result.getBody());
    }

    @Test
    public void testGetVehicleById() {
        Vehicle vehicle = new Vehicle();
        Mockito.when(vehicleService.getVehicleById(1)).thenReturn(Optional.of(vehicle));
        ResponseEntity<Vehicle> result = vehicleController.getVehicle(1);
        Assertions.assertEquals(vehicle, result.getBody());

    }

    @Test
    public void testGetVehicleByIdThrowException() {
        Mockito.when(vehicleService.getVehicleById(1)).thenReturn(Optional.empty());
        ResponseEntity<Vehicle> result = vehicleController.getVehicle(1);
        Assertions.assertEquals(HttpStatus.NOT_FOUND, result.getStatusCode());

    }

    @Test
    public void testDeleteVehicle() {
        Mockito.doNothing().when(vehicleService).deleteVehicleById(1);
        ResponseEntity<String> result = vehicleController.deleteVehicle(1);
        Assertions.assertEquals("successfully deleted", result.getBody());
    }

}
