package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Checkout_page {
	
	WebDriver driver;
	
	@FindBy(css = "[data-test='country']")
	WebElement country;
	
	@FindBy(css = "[data-test='postal_code']")
	WebElement postcode;
	
	@FindBy(css = "[data-test='house_number']")
	WebElement housenumber;
	
	@FindBy(css = "[data-test='street']")
	WebElement street;
	
	@FindBy(css = "[data-test='city']")
	WebElement city;
	
	@FindBy(css = "[data-test='state']")
	WebElement state;
	
	@FindBy(css = "[data-test='proceed-3']")
	WebElement proceedbtn;
	
	@FindBy(css = "[data-test='payment-method']")
	WebElement paymentmethod;
	
	@FindBy(css = "[data-test='bank_name']")
	WebElement bankname;
	
	@FindBy(css = "[data-test='account_name']")
	WebElement accountname;
	
	@FindBy(css = "[data-test='account_number']")
	WebElement accountnumber;
	
	@FindBy(css = "[data-test='expiration_date']")
	WebElement expirationdate;
	
	@FindBy(css = "[data-test='cvv']")
	WebElement cvv;
	
	@FindBy(css = "[data-test='card_holder_name']")
	WebElement cardholdername;
	
	@FindBy(css = "[data-test='credit_card_number']")
	WebElement creditcardnumber;
	
	@FindBy(css = "[data-test='finish']")
	WebElement checkpayment;
	
	@FindBy(id = "order-confirmation")
	WebElement orderconfirmation;
	
	
	public Checkout_page(WebDriver driver) {
		 this.driver = driver;

	        PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

	public void SelectCountry(String countryname)
	{
	    Select sc = new Select(country);

	    for(WebElement option : sc.getOptions())
	    {
	        System.out.println(option.getText());
	    }

	    sc.selectByVisibleText(countryname);
	}
	
	public void EnterPostcode(String code)
	{
	    postcode.clear();
	    postcode.sendKeys(code);
	}
	
	public void EnterHouseNumber(String number)
	{
	    housenumber.clear();
	    housenumber.sendKeys(number);
	}
	
	
	public void ClickProceed()
	{
	    proceedbtn.click();
	}
	
	public void SelectPaymentMethod(String method)
	{
	    Select sc = new Select(paymentmethod);
	    sc.selectByVisibleText(method);
	}
	
	public void EnterBankDetails(String bank, String name, String number)
	{
	    bankname.clear();
	    bankname.sendKeys(bank);

	    accountname.clear();
	    accountname.sendKeys(name);

	    accountnumber.clear();
	    accountnumber.sendKeys(number);
	}
	
	public void EnterCreditCardDetails(String cardnumber, String date, String cvvnumber, String holder)
	{
		
		creditcardnumber.clear();
	    creditcardnumber.sendKeys(cardnumber);
	    
	    expirationdate.clear();
	    expirationdate.sendKeys(date);

	    cvv.clear();
	    cvv.sendKeys(cvvnumber);

	    cardholdername.clear();
	    cardholdername.sendKeys(holder);    
	}
	
	public void ClickCheckPayment()
	{
	    checkpayment.click();
	}
	
	
	public boolean VerifyOrderConfirmation()
	{
	    return orderconfirmation.isDisplayed();
	}
	
	

}
