package com.flywithus.flight.search;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TripStore extends JpaRepository<Trip, Long> {
}
