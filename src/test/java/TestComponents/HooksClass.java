package TestComponents;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class HooksClass {

    private static WebDriver driver;
    private Properties prop;

    @Before
    public void setUp() {
        try {
            prop = new Properties();
            FileInputStream fis = new FileInputStream(
                    System.getProperty("user.dir") + "/src/test/resources/Global.properties"
            );
            prop.load(fis);

            String headless = prop.getProperty("headless");
            String url = prop.getProperty("url");

            EdgeOptions options = new EdgeOptions();

            if (headless.equalsIgnoreCase("true")) {
                options.addArguments("--headless=new");
                options.addArguments("--disable-gpu");
                options.addArguments("--window-size=1920,1080");
            }

            driver = new EdgeDriver(options);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.get(url);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static WebDriver getDriver() {
        return driver;
    }
}
