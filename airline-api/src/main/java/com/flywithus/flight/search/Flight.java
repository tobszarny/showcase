package com.flywithus.flight.search;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Flight {
    private String flightNumber;
    private String operator;
    private AirportLocation departureLocation;
    private LocalDateTime departureTime;
    private AirportLocation destinationLocation;
    private LocalDateTime arrivalTime;
}
