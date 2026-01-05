package KingsleyGate.StepDef.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UtilityFile.AbstractComponents;

public class UpdateInformationPage  extends AbstractComponents
{
	WebDriver driver;
	public UpdateInformationPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//a[@href='updateprofile.htm']")
	WebElement updateInfo;

	@FindBy(id = "customer.firstName")
	WebElement fname;

	@FindBy(id = "customer.lastName")
	WebElement lname;

	@FindBy(id = "customer.address.street")
	WebElement addr;

	@FindBy(id = "customer.address.city")
	WebElement cityyy;

	@FindBy(xpath = "//input[@value='Update Profile']")
	WebElement updateBtn;

	
	public void Navigating_To_UpdateInfoPage()
	{
		waitForWebElementToAppear(updateInfo);
		updateInfo.click();
		
	}

	public void updateDetails(String firstName, String lastName, String address, String seq)
	{
		waitForWebElementToAppear(fname);
		fname.sendKeys(firstName);
		
		lname.sendKeys(lastName);
		
		addr.sendKeys(address);
		
		cityyy.sendKeys(seq);
		
		updateBtn.click();
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
