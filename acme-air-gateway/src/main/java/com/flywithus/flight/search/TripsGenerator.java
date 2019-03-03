package com.flywithus.flight.search;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.flywithus.core.Profile.SANDBOX;

@Profile(SANDBOX)
@Component
public class TripsGenerator {

    private static final String CURRENCY = "PLN";

    Random random = new Random(System.currentTimeMillis());

    List<Trip> generate(AirportLocation from, AirportLocation to, LocalDate departureDate, LocalDate returnDate, int count) {
        List<Trip> trips = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            trips.add(generateTrip(from, to, departureDate, returnDate));
        }

        return trips;
    }

    private Trip generateTrip(AirportLocation from, AirportLocation to, LocalDate departureDate, LocalDate returnDate) {
        Trip build = Trip.builder()
                .currency(CURRENCY)
                .flightsToDestination(generateFlights(from, to, 2, departureDate))
                .returningFlights(generateFlights(to, from, 2, departureDate))
                .price(BigDecimal.TEN)
                .build();
        return build;
    }

    private List<Flight> generateFlights(AirportLocation from, AirportLocation to, int maxConnectingFlights, LocalDate date) {
        int connectionsNum = random.nextInt(maxConnectingFlights);

        return generateFlights(from, to, date, connectionsNum);
    }

    List<Flight> generateFlights(AirportLocation from, AirportLocation to, LocalDate date, int connectionsNum) {
        List<AirportLocation> connections = new ArrayList<>();

        for (int i = 0; i < connectionsNum; i++) {
            connections.add(generateNextConnection(connections));
        }

        List<Flight> flights = new ArrayList<>();

        if (connections.isEmpty()) {
            LocalDateTime departureTime = generateRandomTimeForDate(date);
            flights.add(Flight.builder()
                    .departureLocation(from)
                    .departureTime(departureTime)
                    .destinationLocation(to)
                    .arrivalTime(departureTime.plus(40 + random.nextInt(60), ChronoUnit.MINUTES))
                    .build());
        } else {

        }

        return flights;
    }

    private LocalDateTime generateRandomTimeForDate(LocalDate date) {
        return LocalDateTime.of(date, LocalTime.of(random.nextInt(24), random.nextInt(60),
                random.nextInt(60), random.nextInt(999999999 + 1)));
    }

    private AirportLocation generateNextConnection(List<AirportLocation> connections) {
        AirportLocation connection;
        do {
            int index = Math.abs(random.nextInt()) % (AirportLocationDefinition.INTERNATIONAL_TRANSIT_AIRPORTS.size());
            connection = AirportLocationDefinition.INTERNATIONAL_TRANSIT_AIRPORTS.get(index);
        } while (connections.contains(connection));
        return connection;
    }

}
