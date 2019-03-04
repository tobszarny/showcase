package com.flywithus.flight.search;

import com.flywithus.flight.search.configuration.ReservationJpaConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsNot.not;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {ReservationJpaConfiguration.class})
@AutoConfigureDataJpa
@Transactional
public class AirportLocationStoreTest {
    @Autowired
    private AirportLocationStore airportLocationStore;

    @Test
    public void sanityCheck() {
        Assert.assertThat(airportLocationStore, is(not(nullValue())));
    }
}