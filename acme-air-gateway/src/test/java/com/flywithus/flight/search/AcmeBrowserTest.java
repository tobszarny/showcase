package com.flywithus.flight.search;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.flywithus.core.Profile.SANDBOX;
import static com.flywithus.flight.search.AirportLocationDefinition.TXL;
import static com.flywithus.flight.search.AirportLocationDefinition.WRO;
import static org.hamcrest.Matchers.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestsConfiguration.class})
@ActiveProfiles(profiles = SANDBOX)
public class AcmeBrowserTest {

    @Autowired
    private Browser browser;

    @Test
    public void sanityCheck() {
        Assert.assertThat(browser, is(not(nullValue())));
    }

    @Test
    public void findTrips() {
        LocalDate departureDate = LocalDate.of(2019, 1, 1);
        LocalDate returnDate = departureDate.plus(3, ChronoUnit.DAYS);

        List<Trip> trips = browser.findTrips(WRO, TXL, departureDate, returnDate);

        Assert.assertThat(trips, is(not(nullValue())));
        Assert.assertThat(trips, is(not(empty())));

        trips.forEach(System.out::println);
    }
}