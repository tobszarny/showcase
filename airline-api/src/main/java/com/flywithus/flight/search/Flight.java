package com.flywithus.flight.search;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class Flight {
    private String flightNumber;
    private String departureCity;
    private LocalDateTime departureTime;
    private String destinationCity;
    private LocalDateTime arrivalTime;
}
