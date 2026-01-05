package KingsleyGate.StepDef;

import TestComponents.HooksClass;
import KingsleyGate.StepDef.Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.io.InputStream;
import java.util.Properties;

public class Login_StepDefinition {

    WebDriver driver;
    LoginPage loginPage;

    @Given("User landed on Banking App")
    public void user_landed_on_banking_app() {
        driver = HooksClass.getDriver();
        loginPage = new LoginPage(driver);
    }

    @Then("User logged in with valid email and password")
    public void user_logged_in_with_valid_email_and_password() throws Exception {

        Properties prop = new Properties();
        InputStream is = getClass()
                .getClassLoader()
                .getResourceAsStream("Global.properties");

        if (is == null) {
            throw new RuntimeException("Global.properties not found");
        }

        prop.load(is);

        String email = prop.getProperty("user_email");
        String password = prop.getProperty("user_password");

        loginPage.Logging_Ignyte_App(email, password);
    }
}
