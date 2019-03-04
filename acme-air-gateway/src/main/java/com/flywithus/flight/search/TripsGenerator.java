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
    public static final String OPERATOR = "ACME";

    Random random = new Random(System.currentTimeMillis());

    List<Trip> generate(AirportLocation from, AirportLocation to, LocalDate departureDate, LocalDate returnDate, int passengersCount) {
        return generate(from, to, departureDate, returnDate, passengersCount, 1 + random.nextInt(9));
    }

    private List<Trip> generate(AirportLocation from, AirportLocation to, LocalDate departureDate, LocalDate returnDate, int passengersCount, int count) {
        List<Trip> trips = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            trips.add(generateTrip(from, to, departureDate, returnDate, passengersCount));
        }

        return trips;
    }

    Trip generateTrip(AirportLocation from, AirportLocation to, LocalDate departureDate, LocalDate returnDate, int passengersCount) {
        List<Flight> flightsToDestination = generateFlights(from, to, 2, departureDate, passengersCount);
        List<Flight> returningFlights = new ArrayList<>();
        if (returnDate != null) {
            returningFlights = generateFlights(to, from, 2, returnDate, passengersCount);
        }
        int priceOffset = generatePrice(flightsToDestination.size(), returningFlights.size());
        BigDecimal price = BigDecimal.valueOf(passengersCount * (priceOffset + random.nextInt(1200)));
        Trip build = Trip.builder()
                .currency(CURRENCY)
                .flightsToDestination(flightsToDestination)
                .returningFlights(returningFlights)
                .price(price)
                .passengersCount(passengersCount)
                .build();
        return build;
    }

    private int generatePrice(int toDestinationSegmentsCount, int fromDestinationSegmentsCount) {
        // Imaginary algorithm the more connecting flights the cheaper
        return (400 - toDestinationSegmentsCount * 100) + (400 - fromDestinationSegmentsCount * 100);
    }

    private List<Flight> generateFlights(AirportLocation from, AirportLocation to, int maxConnectingFlights, LocalDate date, int passengersCount) {
        int connectionsNum = random.nextInt(maxConnectingFlights);

        return generateFlights(from, to, date, passengersCount, connectionsNum);
    }

    List<Flight> generateFlights(AirportLocation from, AirportLocation to, LocalDate date, int passengersCount, int connectionsNum) {
        List<AirportLocation> connections = new ArrayList<>();

        for (int i = 0; i < connectionsNum; i++) {
            connections.add(generateNextConnection(connections));
        }

        List<Flight> flights = new ArrayList<>();

        if (connections.isEmpty()) {
            LocalDateTime departureTime = generateRandomTimeForDate(date);
            flights.add(Flight.builder()
                    .operator(OPERATOR)
                    .departureLocation(from)
                    .departureTime(departureTime)
                    .destinationLocation(to)
                    .arrivalTime(departureTime.plus(40 + random.nextInt(60), ChronoUnit.MINUTES))
                    .passengersCount(passengersCount)
                    .build());
        } else {
            LocalDateTime departureTime = generateRandomTimeForDate(date);
            AirportLocation segmentFrom = from;
            AirportLocation segmentTo = to;
            LocalDateTime segmentDepartureTime = departureTime;
            LocalDateTime segmentArrivalTime;
            for (AirportLocation connection : connections) {
                segmentArrivalTime = segmentDepartureTime.plus(40 + random.nextInt(60), ChronoUnit.MINUTES);
                segmentTo = connection;
                flights.add(Flight.builder()
                        .operator(OPERATOR)
                        .departureLocation(segmentFrom)
                        .departureTime(segmentDepartureTime)
                        .destinationLocation(segmentTo)
                        .arrivalTime(segmentArrivalTime)
                        .passengersCount(passengersCount)
                        .build());
                segmentFrom = segmentTo;
                segmentDepartureTime = segmentArrivalTime.plus(40 + random.nextInt(100), ChronoUnit.MINUTES);
            }

            segmentArrivalTime = segmentDepartureTime.plus(40 + random.nextInt(60), ChronoUnit.MINUTES);
            segmentTo = to;
            flights.add(Flight.builder()
                    .operator(OPERATOR)
                    .departureLocation(segmentFrom)
                    .departureTime(segmentDepartureTime)
                    .destinationLocation(segmentTo)
                    .arrivalTime(segmentArrivalTime)
                    .passengersCount(passengersCount)
                    .build());
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
