package com.flywithus.flight.search;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static com.flywithus.core.Profile.SANDBOX;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestsConfiguration.class})
@ActiveProfiles(profiles = SANDBOX)
public class TripsGeneratorTest {

    @Autowired
    private TripsGenerator tripsGenerator;

    @Test
    public void generateFlights_direct() {
        AirportLocation from = AirportLocation.builder().build();
        AirportLocation to = AirportLocation.builder().build();
        LocalDate date = LocalDate.of(2019, 1, 1);
        List<Flight> flights = tripsGenerator.generateFlights(from, to, date, 0);

        Assert.assertThat(flights, is(not(nullValue())));
        Assert.assertThat(flights, is(not(empty())));
        Assert.assertThat(flights.size(), is(1));
    }

    @Test
    public void generateFlights_connecting_flights_1() {
        AirportLocation from = AirportLocation.builder().build();
        AirportLocation to = AirportLocation.builder().build();
        LocalDate date = LocalDate.of(2019, 1, 1);
        List<Flight> flights = tripsGenerator.generateFlights(from, to, date, 1);

        Assert.assertThat(flights, is(not(nullValue())));
        Assert.assertThat(flights, is(not(empty())));
        Assert.assertThat(flights.size(), is(2));
    }
}