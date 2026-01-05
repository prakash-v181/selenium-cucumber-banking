package TestComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Lightweight thread-safe driver factory for tests.
 * This uses WebDriverManager to download and setup the correct driver in CI.
 */
public class DriverFactory {

    private static final ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

    public static WebDriver getDriver() {
        if (tlDriver.get() == null) {
            initDriver();
        }
        return tlDriver.get();
    }

    public static void initDriver() {
        // setup chromedriver automatically
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        // Recommended arguments for CI
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");

        tlDriver.set(new ChromeDriver(options));
    }

    public static void quitDriver() {
        WebDriver driver = tlDriver.get();
        if (driver != null) {
            try {
                driver.quit();
            } catch (Exception ignored) {}
            tlDriver.remove();
        }
    }
}