package KingsleyGate.StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import KingsleyGate.StepDef.Pages.BillPayPage;
import TestComponents.HooksClass;
import UtilityFile.ExcelReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class BillPay_StepDefinition 
{
	BillPayPage billPayPage;
	HooksClass hooksClass = new HooksClass();

	static final String excelPath = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
    static final String sheetName = "UpdateInfo";

    private List<Map<String, String>> currentScenarioData;

    @Before("@BillPayInfo")
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

    @Then("User navigates to bill pay information page")
    public void user_navigates_to_page() throws InterruptedException
    {
    	billPayPage = new BillPayPage(hooksClass.getDriver());
    	billPayPage.Navigating_To_BillPayPage();
    }

    @Then("^User provide detailss (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) and (.+)$")
    public void user_provides_a_valid_detailss(String PPayee_Name, String AAddress, String CCity, String SState, String ZZipCode,String PPhone_No, String AAccount, String VVerify_Account,String AAmount)
    {
    	System.out.println("Inside bill payyyyyyyyyyyyyyyyyyyyy ");
    	for(Map<String, String> row : currentScenarioData) 
    	{
    		System.out.println("Inside for loop");
            String Payee_Name = row.get("PPayee_Name");
            String Address = row.get("AAddress");
            String City = row.get("CCity");
            String State = row.get("SState");
            String ZipCode = row.get("ZZipCode");
            String Phone_No = row.get("PPhone_No");
            String Account = row.get("AAccount");
            String Verify_Account = row.get("VVerify_Account");
            String Amount = row.get("AAmount");
            
            System.out.println(Payee_Name+"................................. "+Address);

            billPayPage.billpayDetails(Payee_Name,Address,City,State,ZipCode,Phone_No,Account,Verify_Account, Amount);
    	}
    }
}
