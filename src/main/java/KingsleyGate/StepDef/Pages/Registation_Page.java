package KingsleyGate.StepDef.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UtilityFile.AbstractComponents;

public class Registation_Page extends AbstractComponents
{
	WebDriver driver;
	public Registation_Page(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath = "//div[@id=\"loginPanel\"]/p[2]/a")
	WebElement Registationclck;

	@FindBy(id = "customer.firstName")
	WebElement fname1;

	@FindBy(id = "customer.lastName")
	WebElement lname1;

	@FindBy(id = "customer.address.street")
	WebElement addr1;

	@FindBy(id = "customer.address.city")
	WebElement city1;

	@FindBy(id = "customer.address.state")
	WebElement state1;
	
	@FindBy(id = "customer.address.zipCode")
	WebElement zipcode1;
	
	@FindBy(id = "customer.phoneNumber")
	WebElement phoneNo1;
	
	@FindBy(id = "customer.ssn")
	WebElement snn1;
	
	@FindBy(id = "customer.username")
	WebElement usrname1;
	
	@FindBy(id = "customer.password")
	WebElement cpass1;

	@FindBy(id = "repeatedPassword")
	WebElement rpass1;
	
	@FindBy(xpath = "(//input[@type=\"submit\"])[2]")
	WebElement rgstn;

	
	public void Navigating_To_Registation_Page()
	{
		waitForWebElementToAppear(Registationclck);
		Registationclck.click();
		
	}

	public void Regisataion_Details(String fname,String lname,String addr,String city,String state,String zipcode,String phoneNo,String snn,String usrname,String cpass,String rpass)
	{
		System.out.println("Inside page fileeeeeeeeeeeeeeeeeeeeeee");
		
        waitForWebElementToAppear(fname1);
		fname1.sendKeys(fname);
		
		lname1.sendKeys(lname);
		
		addr1.sendKeys(addr);
		
		city1.sendKeys(city);
		
		state1.sendKeys(state);
		
		zipcode1.sendKeys(zipcode);
		
		phoneNo1.sendKeys(phoneNo);
		
		snn1.sendKeys(snn);
		
		usrname1.sendKeys(usrname);
		
		cpass1.sendKeys(cpass);
		
		rpass1.sendKeys(rpass);
		
		rgstn.click();
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
