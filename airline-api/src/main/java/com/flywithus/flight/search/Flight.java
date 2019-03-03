package com.flywithus.flight.search;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Builder
@Getter
@ToString
public class Flight {
    private String flightNumber;
    private String operator;
    private AirportLocation departureLocation;
    private LocalDateTime departureTime;
    private AirportLocation destinationLocation;
    private LocalDateTime arrivalTime;
}
