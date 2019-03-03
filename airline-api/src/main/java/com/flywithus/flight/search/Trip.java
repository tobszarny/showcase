package com.flywithus.flight.search;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

@Builder
@Getter
@ToString
public class Trip {
    private List<Flight> flightsToDestination;
    private List<Flight> returningFlights;
    private BigDecimal price;
    private String currency;
}
