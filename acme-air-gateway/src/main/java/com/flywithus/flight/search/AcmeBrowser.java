package com.flywithus.flight.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

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
    public List<Trip> findTrips(AirportLocation from, AirportLocation to, LocalDate departureDate, LocalDate returnDate) {
        return generator.generate(from, to, departureDate, returnDate);
    }
}
