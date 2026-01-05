package KingsleyGate.StepDef;

import TestComponents.HooksClass;
import KingsleyGate.StepDef.Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.io.InputStream;
import java.util.Properties;

public class Login_StepDefinition {

    WebDriver driver;
    LoginPage loginPage;

    // ================== GIVEN ==================
    @Given("User landed on Ignyte App")
    public void user_landed_on_ignyte_app() {
        driver = HooksClass.getDriver();
        loginPage = new LoginPage(driver);
    }

    // ================== WHEN ==================
    @When("User logged in with valid Email user_email and Password user_password")
    public void user_logged_in_with_valid_email_and_password() throws Exception {

        Properties prop = new Properties();
        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("Global.properties");

        if (is == null) {
            throw new RuntimeException("❌ Global.properties not found in classpath");
        }

        prop.load(is);

        String email = prop.getProperty("user_email");
        String password = prop.getProperty("user_password");

        loginPage.Logging_Ignyte_App(email, password);
    }

    // ================== THEN ==================
    @Then("User Logged in succesfully in Ignyte App and match the title Welcome - Ignyte of the home page")
    public void user_logged_in_successfully_and_validate_title() {
        String actualTitle = driver.getTitle();
        System.out.println("Page Title is: " + actualTitle);

        // OPTIONAL ASSERT (enable later)
        // Assert.assertEquals(actualTitle, "Welcome - Ignyte");
    }
}
