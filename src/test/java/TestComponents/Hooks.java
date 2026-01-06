package TestComponents;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class Hooks {

    @Before
    public void setUp() {

        // ❌ NO WebDriverManager here
        System.setProperty(
                "webdriver.edge.driver",
                "C:\\Drivers\\msedgedriver.exe"
        );

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new EdgeDriver(options);
        DriverFactory.setDriver(driver);
    }

    @After
    public void tearDown() {
        WebDriver driver = DriverFactory.getDriver();
        if (driver != null) {
            driver.quit();
            DriverFactory.removeDriver();
        }
    }
}
