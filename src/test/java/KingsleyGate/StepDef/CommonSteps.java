package KingsleyGate.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import TestComponents.DriverFactory;

/**
 * Basic stubs for the undefined steps reported by Cucumber.
 * Replace placeholders with real page-object calls.
 */
public class CommonSteps {

    private final WebDriver driver = DriverFactory.getDriver();

    @Given("User landed on Banking App")
    public void user_landed_on_banking_app() {
        // Replace with the real application URL for your tests
        driver.get("https://your-banking-app-url.example");
    }

    @Given("User logged in with valid email and password")
    public void user_logged_in_with_valid_email_and_password() {
        // Implement login flow using your page object or element locators.
        // Example:
        // LoginPage lp = new LoginPage(driver);
        // lp.login("user@example.com","password");
    }

    @When("User navigates to Registation information page")
    public void user_navigates_to_page() {
        // Implement navigation to registration page
    }

    // This long parameterized step was shown in test logs; keep exact signature
    @When("User provide detailsss {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} and {string}")
    public void user_provides_a_valid_registation_details(String Fname, String Lname, String Addr, String City,
                                                          String State, String Zipcode, String PhoneNo, String Snn,
                                                          String Usrname, String Cpass, String Rpass) {
        // Use these parameters to fill in registration form.
        // Example placeholders:
        // RegistrationPage rp = new RegistrationPage(driver);
        // rp.enterFirstName(Fname);
        // rp.enterLastName(Lname);
        // ...
    }

    @Then("User updated code in the properties file")
    public void updatePropertiesFile() {
        // Implement verification or properties update if required by your test
    }

    // Generic fallback if you want to quickly match similar steps (optional)
    // @Given("(?i)user landed on banking app")
    // public void user_landed_on_banking_app_case_insensitive() { user_landed_on_banking_app(); }
}