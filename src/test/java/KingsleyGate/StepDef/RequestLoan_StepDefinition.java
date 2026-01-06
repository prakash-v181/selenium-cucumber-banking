// src\test\java\KingsleyGate\StepDef\RequestLoan_StepDefinition.java
package KingsleyGate.StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import KingsleyGate.StepDef.Pages.RequestLoanPage;
import KingsleyGate.StepDef.Pages.UpdateInformationPage;
import TestComponents.DriverFactory;
import TestComponents.HooksClass;
import UtilityFile.ExcelReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class RequestLoan_StepDefinition 
{
	RequestLoanPage requestLoanPage;
	HooksClass hooksClass = new HooksClass();

	static final String excelPath = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
    static final String sheetName = "UpdateInfo";

    private List<Map<String, String>> currentScenarioData;

    @Before("@RequestLoan")
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

    @Then("^User navigates to Request Loan page$")
    public void user_navigates_to_Loanpage() throws InterruptedException
    {
    	requestLoanPage = new RequestLoanPage(DriverFactory.getDriver());
    	requestLoanPage.Navigating_To_RequestLoanPage();
    }

    @Then("^User provide details (.+) and (.+)$")
    public void user_provides_a_valid_details(String LoanAmount, String DownPayment)
    {
    	for(Map<String, String> row : currentScenarioData) 
    	{
            String loanAmount = row.get("LoanAmount");
            String downPayment = row.get("DownPayment");

            requestLoanPage.updateDetails(loanAmount,downPayment);
    	}
    }
}
