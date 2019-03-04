package com.flywithus.reservation;

import com.flywithus.flight.search.Flight;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    void cancel(ReservationBasket basket) {
        Optional<Flight> earliestDepartureFlight = basket.getTrips().stream()
                .map(t -> t.getFlightsToDestination())
                .flatMap(List::stream)
                .min(Comparator.comparing(Flight::getDepartureTime));

        if (earliestDepartureFlight.isPresent()) {
            Flight flight = earliestDepartureFlight.get();
            if (flight.getDepartureTime().isAfter(LocalDateTime.now().plus(5, ChronoUnit.DAYS))) {
                preformCancel(basket);
            }
        }
    }

    private void preformCancel(ReservationBasket basket) {

    }
}
