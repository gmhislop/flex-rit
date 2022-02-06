package com.novi.flexrit.controller;

import com.novi.flexrit.dto.ReportDTO;
import com.novi.flexrit.exception.BadRequestException;
import com.novi.flexrit.model.Trip;
import com.novi.flexrit.model.User;
import com.novi.flexrit.repository.TripRepository;
import com.novi.flexrit.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
public class ReportController {

    @Autowired
    TripRepository tripRepository;

    @Autowired
    UserRepository userRepository;

    @GetMapping("/report")
    public ResponseEntity<ReportDTO> getReport(@RequestParam("userId") long userId, @RequestParam(value = "year", required = false) Integer year) {
        Optional<User> user = userRepository.findById(userId);
        if (user.isEmpty()) {
            throw new BadRequestException("Invalid userId");
        }
        List<Trip> tripList = tripRepository.findByUser(user.get());
        List<Trip> filteredList = new ArrayList<>();
        double totalDistance = 0;
        for (Trip trip : tripList) {
            if (year != null) {
                if (Objects.nonNull(trip.getDate()) && trip.getDate().getYear() == year) {
                    filteredList.add(trip);
                    totalDistance = totalDistance + trip.getDistance();
                }

            } else {
                filteredList.add(trip);
                totalDistance = totalDistance + trip.getDistance();
            }

        }
        ReportDTO reportDTO = new ReportDTO();
        reportDTO.setUserId(userId);
        reportDTO.setTotalDistance(totalDistance);
        reportDTO.setTrips(filteredList);
        return ResponseEntity.ok(reportDTO);

    }
}
