package TestComponents;

import io.cucumber.java.Before;
import io.cucumber.java.After;

/**
 * Cucumber hooks to start and stop the driver for each scenario.
 */
public class Hooks {

    @Before
    public void beforeScenario() {
        // initialize driver
        DriverFactory.getDriver();
    }

    @After
    public void afterScenario() {
        // cleanup driver
        DriverFactory.quitDriver();
    }
}