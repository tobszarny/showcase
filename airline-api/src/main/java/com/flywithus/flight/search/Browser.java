package com.flywithus.flight.search;

import java.time.LocalDate;
import java.util.List;

public interface Browser {
    List<Trip> findTrips(String fromCity, String toCity, LocalDate departureDate, LocalDate returnDate);
}
