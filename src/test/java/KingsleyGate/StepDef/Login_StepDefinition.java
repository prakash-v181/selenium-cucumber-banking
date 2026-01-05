package KingsleyGate.StepDef;

import TestComponents.HooksClass;
import KingsleyGate.StepDef.Pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
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
    public void user_logged_in_with_valid_email_and_password() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(
                System.getProperty("user.dir") + "/src/test/resources/Global.properties"
        );
        prop.load(fis);

        String email = prop.getProperty("user_email");
        String password = prop.getProperty("user_password");

        loginPage.Logging_Ignyte_App(email, password);
    }
}




// // src\test\java\KingsleyGate\StepDef\Login_StepDefinition.java
// package KingsleyGate.StepDef;

// import TestComponents.HooksClass;
// import io.cucumber.java.en.Given;
// import io.cucumber.java.en.Then;
// import KingsleyGate.StepDef.Pages.LoginPage;
// import java.io.FileInputStream;
// import java.io.IOException;
// import java.util.Properties;

// public class Login_StepDefinition
// {
//     LoginPage loginPage;
    
//     @Given("User landed on Banking App")
//     public void user_landed_on_ignyte_app() throws IOException
//     {
//     	System.out.println("Inside User landed on Ignyte App - sted definition  ::::::::::::::::::::::");
//     	loginPage = HooksClass.launchApp();         
//     }
//     @Then("^User logged in with valid email and password$")
//     public void user_logged_in_with_valid_email_and_password() throws IOException 
//     {
//         Properties prop = new Properties();
//         FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Resources/Global.properties");
//         prop.load(fis);

//         String email = prop.getProperty("user_email");
//         String password = prop.getProperty("user_password");

//         loginPage.Logging_Ignyte_App(email, password);
//     }
// }
