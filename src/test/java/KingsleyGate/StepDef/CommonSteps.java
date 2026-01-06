package KingsleyGate.StepDef;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import TestComponents.DriverFactory;

public class CommonSteps {

    private final WebDriver driver = DriverFactory.getDriver();

    @Given("User landed on Banking App")
    public void user_landed_on_banking_app() {
        driver.get(System.getProperty(
                "banking.url",
                "https://parabank.parasoft.com/parabank/index.htm"
        ));
    }

    @Given("User logged in with valid email and password")
    public void user_logged_in_with_valid_email_and_password() {
        // login steps here
    }
}
