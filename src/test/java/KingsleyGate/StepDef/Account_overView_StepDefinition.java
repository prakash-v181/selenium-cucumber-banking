package KingsleyGate.StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import KingsleyGate.StepDef.Pages.Account_OverviewPage;
import KingsleyGate.StepDef.Pages.RequestLoanPage;
import KingsleyGate.StepDef.Pages.UpdateInformationPage;
import TestComponents.HooksClass;
import UtilityFile.ExcelReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class Account_overView_StepDefinition 
{
	Account_OverviewPage account_OverviewPage;
	HooksClass hooksClass = new HooksClass();

	static final String excelPath = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
    static final String sheetName = "UpdateInfo";

    private List<Map<String, String>> currentScenarioData;

    @Before("@AccountOverViewInfo")
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

    @Then("^User navigates to Accunt Over View page$")
    public void user_navigates_to_Loanpage() throws InterruptedException
    {
    	account_OverviewPage = new Account_OverviewPage(hooksClass.getDriver());
    	account_OverviewPage.Navigating_To_Acc_Overview_Page();
    }

    @Then("^User enters valid details (.+) and (.+)$")
    public void user_select_valid_details(String Month, String Type)
    {
    	System.out.println("Inside method loop");
    	for(Map<String, String> row : currentScenarioData) 
    	{
    		System.out.println("Inside for loop");
            String month = row.get("Month");
            String type = row.get("Type");

            account_OverviewPage.account_overview_Details(month,type);
    	}
    }
}
