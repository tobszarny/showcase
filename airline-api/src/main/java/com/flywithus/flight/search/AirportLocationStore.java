package com.flywithus.flight.search;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportLocationStore extends JpaRepository<AirportLocation, String> {
}