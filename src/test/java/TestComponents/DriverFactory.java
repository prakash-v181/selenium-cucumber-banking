package TestComponents;

import org.openqa.selenium.WebDriver;

public class DriverFactory {

    private static WebDriver driver;

    // Used by Step Definitions
    public static WebDriver getDriver() {
        return driver;
    }

    // Used by Hooks
    public static void setDriver(WebDriver driverRef) {
        driver = driverRef;
    }

    public static void removeDriver() {
        driver = null;
    }
}
