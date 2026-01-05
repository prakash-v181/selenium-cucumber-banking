package KingsleyGate.StepDef.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import UtilityFile.AbstractComponents;

public class RequestLoanPage  extends AbstractComponents
{
	WebDriver driver;
	public RequestLoanPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	@FindBy(xpath = "//a[@href='requestloan.htm']")
	WebElement ReqLoan;

	@FindBy(id = "amount")
	WebElement LoanAmt;

	@FindBy(id = "downPayment")
	WebElement DownPay;

	@FindBy(xpath = "//input[@value='Apply Now']")
	WebElement applyNowBtn;

	
	public void Navigating_To_RequestLoanPage()
	{
		waitForWebElementToAppear(ReqLoan);
		ReqLoan.click();
		
	}

	public void updateDetails(String loanAmount, String downPayment)
	{
		waitForWebElementToAppear(LoanAmt);        // ✅ Corrected this
	    LoanAmt.sendKeys(loanAmount);

	    waitForWebElementToAppear(DownPay);        // ✅ Added wait for DownPay (recommended for stability)
	    DownPay.sendKeys(downPayment);

	    waitForWebElementToAppear(applyNowBtn);    // ✅ Added wait for applyNowBtn
	    applyNowBtn.click();
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
