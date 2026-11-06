package pagepkg;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
	
	WebDriver driver;
	
	
	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul/li[4]/a")
	WebElement signinbtn;
	
	@FindBy(xpath="//*[@id=\"email\"]")
	WebElement emailbox;
	
	@FindBy(id="password")
	WebElement passwordbox;
	
	@FindBy(css = "[data-test='login-submit']")
	WebElement loginbtn;
	
	@FindBy(id="Layer_1")
	WebElement logo;
	
	@FindBy(css=".help-block")
	WebElement errormsg;
	
	@FindBy(xpath = "//p[contains(text(),'you are already logged in')]")
	WebElement alreadyLoggedInMessage;
	
	@FindBy(css = "[data-test='proceed-2']")
	WebElement proceedbtn;
	
	
	
	public Login_page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}

	//Emailbox verification
	public boolean VerifyEmailDisplayed() 
	{
	    return emailbox.isDisplayed();
	}
	
	//passwordbox verification
	public boolean VerifyPasswordDisplayed() 
	{
	    return passwordbox.isDisplayed();
	}
	
	//Title verification
	public String VerifyLoginPageTitle() 
	{
        return driver.getTitle();
	}
	
	//Loginbtn verification
	public boolean Verifyloginbtn()
	{
		return loginbtn.isDisplayed();
	}
	
	//Error message verification
		public boolean Errormsg()
		{
			return errormsg.isDisplayed();
		}
	
	
	//Signup datadriven testing
	public void Signintest(String mailid,String pass) 
	{
		emailbox.clear();
		emailbox.sendKeys(mailid);
		
		passwordbox.clear();
		passwordbox.sendKeys(pass);
		
		loginbtn.click();
		
	}
	
	public boolean VerifyInvalidMessage()
	{
	    return errormsg.isDisplayed();
	}
	
	public void ClickProceed()
	{
	    proceedbtn.click();
	}
}
