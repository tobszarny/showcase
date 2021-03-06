package com.flywithus.flight.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static com.flywithus.core.Profile.SANDBOX;

/**
 * Acme Air Endpoint Gateway
 */
@Profile(SANDBOX)
@Component
@Qualifier("AcmeBrowser")
public class AcmeBrowser implements Browser {

    @Autowired
    private TripsGenerator generator;

    @Override
    public List<Trip> findTrips(AirportLocation from, AirportLocation to, LocalDate departureDate, LocalDate returnDate, int passengersCount) {
        return generator.generate(from, to, departureDate, returnDate, passengersCount).stream()
                .sorted(Comparator.comparing(Trip::getPrice))
                .collect(Collectors.toList());
    }
}
