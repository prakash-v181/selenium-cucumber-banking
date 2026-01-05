package KingsleyGate.StepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import KingsleyGate.StepDef.Pages.LoginPage;
import TestComponents.HooksClass;

import java.util.Properties;

public class Login_StepDefinition {

    LoginPage loginPage;
    Properties prop;

    @Given("User landed on Banking App")
    public void user_landed_on_banking_app() {
        loginPage = new LoginPage(HooksClass.getDriver());
    }

    @Then("User logged in with valid email and password")
    public void user_logged_in_with_valid_email_and_password() {

        prop = new Properties();
        try {
            prop.load(getClass().getClassLoader()
                    .getResourceAsStream("Global.properties"));
        } catch (Exception e) {
            throw new RuntimeException("Global.properties not found", e);
        }

        String email = prop.getProperty("user_email");
        String password = prop.getProperty("user_password");

        // ✅ THIS NOW EXISTS
        loginPage.login(email, password);
    }
}
