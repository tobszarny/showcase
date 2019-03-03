package com.flywithus.flight.search;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsNot.not;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {TestsConfiguration.class})
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