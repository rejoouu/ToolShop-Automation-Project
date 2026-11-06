package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Myaccount_page {
	
	WebDriver driver;
	
	@FindBy (xpath="//a[@data-test='nav-favorites']")
	WebElement Favourites_nav;
	
	@FindBy(css="[data-test='nav-profile']")
	WebElement Profile_nav;
	
	@FindBy(css="[data-test='nav-invoices']")
	WebElement Invoices_nav;
	
	@FindBy(css="[data-test='nav-messages']")
	WebElement Messages_nav;
	
	@FindBy(xpath="//*[@id=\"navbarSupportedContent\"]/ul/li[1]/a")
	WebElement Homebtn;
	
	
	public Myaccount_page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}

	public boolean verifyfavouritesnav()
	{
		return Favourites_nav.isEnabled();
	}
	
	public boolean verifyprofilenav()
	{
		return Profile_nav.isEnabled();
	}
	
	public boolean verifyinvoicesnav()
	{
		return Invoices_nav.isEnabled();
	}
	
	public boolean verifymessagesnav()
	{
		return Messages_nav.isEnabled();
	}
	
	public void clickHome()
	{
		Homebtn.click();
	}


}
