package com.flywithus.flight.search;

import java.time.LocalDate;
import java.util.List;

public interface Browser {
    List<Trip> findTrips(AirportLocation from, AirportLocation to, LocalDate departureDate, LocalDate returnDate);
}
