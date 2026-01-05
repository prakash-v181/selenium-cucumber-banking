package KingsleyGate.StepDef.Pages;

import UtilityFile.AbstractComponents;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractComponents
{
    WebDriver driver;

    public LoginPage(WebDriver driver)
    {
        super(driver);
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath= "//input[@name='username']")
    WebElement userEmail;
    
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    
    @FindBy(xpath="//input[@value='Log In']")
    WebElement LoginBtn;

    public void Logging_Ignyte_App(String email,String pass)
    {
        System.out.println(driver.getTitle());
        
        userEmail.click();
        userEmail.sendKeys(email);
        
        password.click();
        password.sendKeys(pass);
        
        LoginBtn.click();
    }
    }
