// src\test\java\KingsleyGate\StepDef\UpdateInformation_StepDefinition.java
package KingsleyGate.StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import KingsleyGate.StepDef.Pages.UpdateInformationPage;
import TestComponents.DriverFactory;
import TestComponents.HooksClass;
import UtilityFile.ExcelReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class UpdateInformation_StepDefinition 
{
	UpdateInformationPage updateInformationPage;
	HooksClass hooksClass = new HooksClass();

	static final String excelPath = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
    static final String sheetName = "UpdateInfo";

    private List<Map<String, String>> currentScenarioData;

    @Before("@UpdateInfo")
    public void beforeScenario(Scenario scenario) throws FileNotFoundException, IOException 
    {
        String scenarioName = scenario.getName();
        ExcelReader reader = new ExcelReader(excelPath);
        currentScenarioData = reader.readExcelData(sheetName, scenarioName);

        if (currentScenarioData != null && !currentScenarioData.isEmpty()) {
            for (Map<String, String> row : currentScenarioData) {
                System.out.println("Current Scenario data :" + row);
            }
        }
    }

    @Then("User navigates to update contact information page")
    public void user_navigates_to_page() throws InterruptedException
    {
    	updateInformationPage = new UpdateInformationPage(DriverFactory.getDriver());
		updateInformationPage.Navigating_To_UpdateInfoPage();
    }

    @Then("^User provides details (.+) (.+) (.+) and (.+)$")
    public void user_provides_a_valid_details(String FirstName, String LastName, String Address, String City)
    {
    	for(Map<String, String> row : currentScenarioData) 
    	{
            String firstName = row.get("FirstName");
            String lastName = row.get("LastName");
            String address = row.get("Address");
            String seq = row.get("City");

            updateInformationPage.updateDetails(firstName,lastName,address,seq);
    	}
    }
}
