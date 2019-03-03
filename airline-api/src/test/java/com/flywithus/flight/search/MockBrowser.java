package com.flywithus.flight.search;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

@Component
public class MockBrowser implements Browser {

    @Override
    public List<Trip> findTrips(String fromCity, String toCity, LocalDate departureDate, LocalDate returnDate) {
        return null;
    }
}
