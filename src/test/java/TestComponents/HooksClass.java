package TestComponents;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class HooksClass {

    private static WebDriver driver;

    @Before
    public void setUp() {
        driver = new EdgeDriver(); // Selenium Manager auto handles Edge
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
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




// // src\test\java\TestComponents\HooksClass.java
// package TestComponents;

// import KingsleyGate.StepDef.Pages.LoginPage;
// import io.github.bonigarcia.wdm.WebDriverManager;
// import org.openqa.selenium.Dimension;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.openqa.selenium.chrome.ChromeOptions;
// import org.openqa.selenium.edge.EdgeDriver;
// import org.openqa.selenium.edge.EdgeOptions;
// import org.openqa.selenium.firefox.FirefoxDriver;
// import org.openqa.selenium.firefox.FirefoxOptions;
// import java.io.FileInputStream;
// import java.io.IOException;
// import java.time.Duration;
// import java.util.Properties;

// public class HooksClass 
// {
//     private static WebDriver driver;

//     public static WebDriver initializeDriver() throws IOException 
//     {
//         Properties prop = new Properties();
//         FileInputStream fis = new FileInputStream(System.getProperty("user.dir")
//                 + "/src/main/java/Resources/Global.properties");
//         prop.load(fis);

//         String browser = System.getProperty("browser") != null
//                 ? System.getProperty("browser")
//                 : prop.getProperty("browser");

//         String url = prop.getProperty("url");

//         String headlessFlag = System.getProperty("headless") != null
//                 ? System.getProperty("headless")
//                 : prop.getProperty("headless");

//         boolean isHeadless = headlessFlag.equalsIgnoreCase("true");

//         if (browser.equalsIgnoreCase("chrome")) {
//             WebDriverManager.chromedriver().setup();
//             ChromeOptions options = new ChromeOptions();

//             if (isHeadless) {
//                 options.addArguments("--headless=new");
//                 options.addArguments("--window-size=1920,1080");
//                 options.addArguments("--disable-gpu");
//             }

//             options.addArguments("--no-sandbox");
//             options.addArguments("--disable-dev-shm-usage");

//             driver = new ChromeDriver(options);

//         } else if (browser.equalsIgnoreCase("firefox")) {
//             WebDriverManager.firefoxdriver().setup();
//             FirefoxOptions options = new FirefoxOptions();

//             if (isHeadless) {
//                 options.addArguments("--headless");
//                 options.addArguments("--width=1920");
//                 options.addArguments("--height=1080");
//             }

//             driver = new FirefoxDriver(options);

//         } else if (browser.equalsIgnoreCase("edge")) {
//             WebDriverManager.edgedriver().setup();
//             EdgeOptions options = new EdgeOptions();

//             if (isHeadless) {
//                 options.addArguments("headless");
//                 options.addArguments("disable-gpu");
//                 options.addArguments("window-size=1920,1080");
//             }

//             driver = new EdgeDriver(options);

//         } else {
//             throw new RuntimeException("Unsupported browser: " + browser);
//         }

//         driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//         driver.manage().window().setSize(new Dimension(1920, 1080));
//         driver.get(url);
//         return driver;
//     }

//     public static LoginPage launchApp() throws IOException 
//     {
//         driver = initializeDriver();
//         return new LoginPage(driver);
//     }

//     public static void closeWindow() {
//         if (driver != null) {
//             driver.quit();
//         }
//     }

//     public static WebDriver getDriver() {
//         return driver;
//     }
// }
