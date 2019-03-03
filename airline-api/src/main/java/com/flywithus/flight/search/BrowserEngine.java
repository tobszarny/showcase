package com.flywithus.flight.search;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BrowserEngine {
    private List<Browser> registeredBrowsers;

    @Autowired
    public BrowserEngine(List<Browser> browsers) {
        this.registeredBrowsers = browsers;
    }

    public List<Trip> findTrips(AirportLocation from, AirportLocation to, LocalDate departureDate, LocalDate returnDate) {
        if (registeredBrowsers == null) {
            return Collections.emptyList();
        }

        return registeredBrowsers.stream()
                .map(b -> b.findTrips(from, to, departureDate, returnDate))
                .flatMap(List::stream)
                .sorted(Comparator.comparing(Trip::getPrice))
                .collect(Collectors.toList());
    }

    List<Browser> getRegisteredBrowsers() {
        return registeredBrowsers;
    }
}
