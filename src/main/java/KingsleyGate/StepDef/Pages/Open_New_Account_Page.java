	package KingsleyGate.StepDef.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import UtilityFile.AbstractComponents;

public class Open_New_Account_Page  extends AbstractComponents
{
	WebDriver driver;
	public Open_New_Account_Page(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "(//div[@id=\"leftPanel\"])/ul/li/a[1]")
	WebElement onenewaccnt;

	@FindBy(xpath = "//select[@id=\"type\"]")
	WebElement type_accnt;

	@FindBy(xpath = "//input[@value=\"Open New Account\"]")
	WebElement openaccnt;

	@FindBy(xpath = "(//div[@id=\"openAccountResult\"])/p[2]/a")
	WebElement clckonaccntno;
	
	
	public void Navigating_To_Open_new_account()
	{
		waitForWebElementToAppear(onenewaccnt);
		onenewaccnt.click();
		
	}

	public void Open_new_account(String account)
	{
//		waitForWebElementToAppear(type_accnt);        // Type 1
//		type_accnt.sendKeys(account);
//		
//	    waitForWebElementToAppear(type_accnt);
//	    Select monthDropdown = new Select(type_accnt);// Type 2
//	    monthDropdown.selectByVisibleText("Debit");
//	    System.out.println("Debit Card");

		List<WebElement> allcardtype = driver.findElements(By.xpath(""));
		String option = account;
		// Iterate the list using for loop
		for (int i = 0; i < allcardtype.size(); i++)
		{
			if(allcardtype.get(i).getText().contains(option))
		  {
				allcardtype.get(i).click();
		    System.out.println("clicked");
		    break;
		  }
		}
	    
	    waitForWebElementToAppear(openaccnt);        
	    openaccnt.click();   	

	    waitForWebElementToAppear(clckonaccntno);    // ✅ Added wait for applyNowBtn
	    clckonaccntno.click();
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
