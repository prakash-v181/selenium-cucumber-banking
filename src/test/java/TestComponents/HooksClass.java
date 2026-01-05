package TestComponents;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;

public class HooksClass {

    private static WebDriver driver;

    @Before
    public void setUp() {
        // Ensure the appropriate Edge driver binary is downloaded and available on CI
        WebDriverManager.edgedriver().setup();

        EdgeOptions options = new EdgeOptions();

        // Keep using the same headless behavior via system property
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            options.addArguments("--headless=new");
            options.addArguments("--disable-gpu");
            options.addArguments("--window-size=1920,1080");
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
        }

        driver = new EdgeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Keep your own URL (the existing code uses System.getProperty("url", "<default>"))
        driver.get(System.getProperty(
                "url",
                "https://parabank.parasoft.com/parabank/register.htm"
        ));
    }

    @After
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {}
        }
    }

    // used by Login_StepDefinition
    public static WebDriver getDriver() {
        return driver;
    }
}