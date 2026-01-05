// src\main\java\KingsleyGate\StepDef\Pages\Account_OverviewPage.java
package KingsleyGate.StepDef.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilityFile.AbstractComponents;

public class Account_OverviewPage  extends AbstractComponents
{
	WebDriver driver;
	public Account_OverviewPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//div[@id=\"leftPanel\"]/ul/li[2]")
	WebElement accntovrvew;

	@FindBy(xpath = "//div[@id=\"showOverview\"]/table/tbody/tr/td/a")
	WebElement acntinfoclck;

	@FindBy(id = "month")
	WebElement mnth;
	
	@FindBy(id = "transactionType")
	WebElement typ;

	@FindBy(xpath = "//input[@type=\"submit\"]")
	WebElement goBtn;

	
	public void Navigating_To_Acc_Overview_Page()
	{
		waitForWebElementToAppear(accntovrvew);
		accntovrvew.click();
		
	}

	public void account_overview_Details(String month, String type)
	{
		waitForWebElementToAppear(acntinfoclck);        
		acntinfoclck.click();

//	    waitForWebElementToAppear(mnth);
//	    Select monthDropdown = new Select(mnth);
//	    monthDropdown.selectByVisibleText("January");
//	    System.out.println("Month is "+month);

		List<WebElement> allOptions = driver.findElements(By.xpath("//select[@id='month']/option"));
		String option = month;
		// Iterate the list using for loop
		for (int i = 0; i < allOptions.size(); i++)
		{
			if(allOptions.get(i).getText().contains(option))
		  {
		    allOptions.get(i).click();
		    System.out.println("clicked");
		    break;
		  }
		}	
		
	    //waitForWebElementToAppear(type);
//	    Select transactionTypeDropdown = new Select(typ);
//	    transactionTypeDropdown.selectByVisibleText("Debit");
//	    typ.click();
//	    System.out.println("type is "+type);
		
		List<WebElement> allTypes = driver.findElements(By.xpath("//select[@name=\"transactionType\"]"));/// sagle type sathi used find elements
		String optionType = type; 

		for (int i = 0; i < allTypes.size(); i++) {
		 
		    if (allTypes.get(i).getText().contains(optionType))
		    {  
		        allTypes.get(i).click();
		        System.out.println("Type");
		        break;
		    }
		}
	    
	    waitForWebElementToAppear(goBtn);    // ✅ Added wait for applyNowBtn
	    goBtn.click();
	}

	/*
	public void SearchStageAndDisable(String StageCode)
	{
		waitForWebElementToAppear(Menu);
		Menu.click();
		
		waitForWebElementToAppear(SetupModule);
		SetupModule.click();
		Menu.click();
		
		waitForWebElementToAppear(StageSetupIcon);
		StageSetupIcon.click();
		
		waitForWebElementToAppear(StageSearch);
		StageSearch.sendKeys(StageCode);
		
		waitForWebElementToAppear(StageModificationBtn);
		StageModificationBtn.click();
		
		waitForWebElementToAppear(StageDisableBtn);
		StageDisableBtn.click();
	}*/
}
