package com.novi.flexrit.repository;

import com.novi.flexrit.model.Trip;
import com.novi.flexrit.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    List<Trip> findByUser(User user);
}

