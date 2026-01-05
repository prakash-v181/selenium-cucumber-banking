// src\main\java\KingsleyGate\StepDef\Pages\BillPayPage.java
package KingsleyGate.StepDef.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UtilityFile.AbstractComponents;

public class BillPayPage extends AbstractComponents
{
	WebDriver driver;
	public BillPayPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//div[@id=\"leftPanel\"]/ul/li[4]")
	WebElement BillPayInfo;

	@FindBy(xpath = "//input[@name=\"payee.name\"]")
	WebElement payee_name;

	@FindBy(xpath = "//input[@name=\"payee.address.street\"]")
	WebElement addr;

	@FindBy(xpath = "//input[@name=\"payee.address.city\"]")
	WebElement city;

	@FindBy(xpath = "//input[@name=\"payee.address.state\"]")
	WebElement state;
	
	@FindBy(xpath = "//input[@name=\"payee.address.zipCode\"]")
	WebElement zipcode;
	
	@FindBy(xpath = "//input[@name=\"payee.phoneNumber\"]")
	WebElement phoneNo;
	
	@FindBy(xpath = "//input[@name=\"payee.accountNumber\"]")
	WebElement accnt;
	
	@FindBy(xpath = "//input[@name=\"verifyAccount\"]")
	WebElement vaccnt;
	
	@FindBy(xpath = "//input[@name=\"amount\"]")
	WebElement amnt;

	@FindBy(xpath = "//input[@value=\"Send Payment\"]")
	WebElement sndpymnt;

	
	public void Navigating_To_BillPayPage()
	{
		waitForWebElementToAppear(BillPayInfo);
		BillPayInfo.click();
		
	}

	public void billpayDetails(String Payee_Name, String Address, String City, String State, String ZipCode, String Phone_No, String Account, String Verify_Account, String Amount)
	{
		System.out.println("Inside page fileeeeeeeeeeeeeeeeeeeeeee");
		
		waitForWebElementToAppear(payee_name);
		payee_name.sendKeys(Payee_Name);
		
		addr.sendKeys(Address);
		
		city.sendKeys(City);
		
		state.sendKeys(State);
		
		zipcode.sendKeys(ZipCode);
		
		phoneNo.sendKeys(Phone_No);
		
		accnt.sendKeys(Account);
		
		vaccnt.sendKeys(Verify_Account);
		
		amnt.sendKeys(Amount);
		
		sndpymnt.click();
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
