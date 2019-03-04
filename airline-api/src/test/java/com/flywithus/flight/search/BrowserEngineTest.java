package com.flywithus.flight.search;

import com.flywithus.flight.search.configuration.AirlineJpaConfiguration;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {AirlineJpaConfiguration.class, TestsConfiguration.class})
@AutoConfigureDataJpa
@Transactional
public class BrowserEngineTest {

    @Autowired
    private BrowserEngine browserEngine;

    @Test
    public void sanityTest() {
        Assert.assertThat(browserEngine, is(not(nullValue())));
    }

    @Test
    public void getRegisteredBrowser_returns_not_empty() {
        Assert.assertThat(browserEngine.getRegisteredBrowsers(), is(not(empty())));
    }
}