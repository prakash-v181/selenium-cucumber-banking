// src\test\java\KingsleyGate\StepDef\Registation_StepDefinition.java
package KingsleyGate.StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import KingsleyGate.StepDef.Pages.BillPayPage;
import KingsleyGate.StepDef.Pages.Registation_Page;
import TestComponents.DriverFactory;
import TestComponents.HooksClass;
import UtilityFile.ExcelReader;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;

public class Registation_StepDefinition 
{
	Registation_Page registation_Page;
	HooksClass hooksClass = new HooksClass();

	static final String excelPath = System.getProperty("user.dir") + "/TestData/TestData.xlsx";
    static final String sheetName = "UpdateInfo";

    private List<Map<String, String>> currentScenarioData;

    @Before("@RegistationpageInfo")
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

    @Then("User navigates to Registation information page")
    public void user_navigates_to_page() throws InterruptedException
    {
    	registation_Page = new Registation_Page(DriverFactory.getDriver());
    	registation_Page.Navigating_To_Registation_Page();
    }

    @Then("^User provide detailsss (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) (.+) and (.+)$")
    public void user_provides_a_valid_registation_details(String Fname, String Lname, String Addr, String City, String State,String Zipcode, String PhoneNo, String Snn,String Usrname, String Cpass,String Rpass)
    {
    	System.out.println("Inside bill payyyyyyyyyyyyyyyyyyyyy ");
    	for(Map<String, String> row : currentScenarioData) 
    	{
    		System.out.println("Inside for loop");
            String fname = row.get("Fname");
            String lname = row.get("Lname");
            String addr = row.get("Addr");
            String city = row.get("City");
            String state = row.get("State");
            String zipcode = row.get("Zipcode");
            String phoneNo = row.get("PhoneNo");
            String snn = row.get("Snn");
            String usrname = row.get("Usrname");
            String cpass = row.get("Cpass");
            String rpass = row.get("Rpass");          

            registation_Page.Regisataion_Details(fname,lname,addr,city,state,zipcode,phoneNo,snn,usrname,cpass,rpass);
    	}
    }
    @Then("^User updated code in the properties file$")
    public void updatePropertiesFile()
    {
    	for(Map<String, String> row : currentScenarioData) 
    	{
    		String usrname = row.get("Usrname");
            String cpass = row.get("Cpass");
            
            UtilityFile.PropertiesUpdater.updateUserCredentials(usrname, cpass);

            System.out.println("global.properties updated with username: " + usrname + " and password: " + cpass);
    	}
    }
}
