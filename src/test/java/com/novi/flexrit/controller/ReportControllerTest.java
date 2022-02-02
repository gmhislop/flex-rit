package com.novi.flexrit.controller;

import com.novi.flexrit.dto.ReportDTO;
import com.novi.flexrit.model.Role;
import com.novi.flexrit.model.Trip;
import com.novi.flexrit.model.User;
import com.novi.flexrit.repository.TripRepository;
import com.novi.flexrit.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;

import java.util.*;

import static org.mockito.ArgumentMatchers.any;

@SpringBootTest
public class ReportControllerTest {

    @MockBean
    TripRepository tripRepository;

    @MockBean
    UserRepository userRepository;

    @Autowired
    ReportController reportController;

    @Test
    public void testgetReport() {
        Role role = new Role();
        role.setName("USER");
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User user = new User();
        user.setUsername("abc");
        user.setPassword("password");
        user.setRoles(roleSet);

        Trip trip = new Trip();
        trip.setDistance(10);
        List<Trip> tripList = new ArrayList<>();
        tripList.add(trip);
        Mockito.when(userRepository.findById(any())).thenReturn(Optional.of(user));
        Mockito.when(tripRepository.findByUser(any())).thenReturn(tripList);

        ResponseEntity<ReportDTO> result = reportController.getReport(1234, null);

        Assertions.assertEquals(10 , result.getBody().getTotalDistance());


    }
}
