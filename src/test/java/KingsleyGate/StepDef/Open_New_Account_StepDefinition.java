// src\test\java\KingsleyGate\StepDef\Open_New_Account_StepDefinition.java
package KingsleyGate.StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import KingsleyGate.StepDef.Pages.Open_New_Account_Page;
import TestComponents.DriverFactory;
import TestComponents.HooksClass;
import UtilityFile.ExcelReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class Open_New_Account_StepDefinition 
{
	Open_New_Account_Page open_New_Account_Page;  
	HooksClass hooksClass = new HooksClass();

	static final String excelPath = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
    static final String sheetName = "UpdateInfo";

    private List<Map<String, String>> currentScenarioData;

    @Before("@OpenNewAccount")
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

    @Then("^User navigates to Open New Account Page$")
    public void user_navigates_to_Loanpage() throws InterruptedException
    {
    	open_New_Account_Page = new Open_New_Account_Page(DriverFactory.getDriver());
    	open_New_Account_Page.Navigating_To_Open_new_account();
    }

    @Then("^User provide details for Open New Account (.+)$")
    public void user_provides_a_valid_details(String Account)
    {
    	for(Map<String, String> row : currentScenarioData) 
    	{
            String account = row.get("Account");

            open_New_Account_Page.Open_new_account(account);
    	}
    }
}
