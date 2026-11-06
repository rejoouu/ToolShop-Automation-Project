package testpkg;





import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporter_class;
import pagepkg.Cart_page;
import pagepkg.Checkout_page;
import pagepkg.Details_page;
import pagepkg.Home_page;
import pagepkg.Login_page;

public class Checkout_test extends Base_class {
	
	Login_page log;
	Home_page hom;
	Details_page det;
	Cart_page cart;
	Checkout_page che;

	@Test(priority = 1)
	public void VerifyCheckout() throws IOException, InterruptedException
	{
	    test = extent.createTest("Checkout Page Verification");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Home Page
	    driver.get("https://practicesoftwaretesting.com/");

	    hom = new Home_page(driver);
	    hom.Search("pliers");
	    hom.ClickPliers();

	    // Product Details Page
	    det = new Details_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='add-to-cart']")));

	    det.ClickAddToCart();

	    // Cart Page
	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='nav-cart']")));

	    det.ClickCart();

	    cart = new Cart_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='proceed-1']")));

	    cart.ClickProceedToCheckout();

	    // Login Page
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));

	    log = new Login_page(driver);

	    log.Signintest("customer2@practicesoftwaretesting.com", "welcome01");

	    // Wait for Checkout Address Page
	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='proceed-2']")));

	    // Proceed after login
	    log.ClickProceed();

	    // Checkout Page
	    che = new Checkout_page(driver);

	    che.SelectCountry("India");

	    che.EnterPostcode("695001");
	    che.EnterHouseNumber("42");

//	    Thread.sleep(3000);
//
//	    System.out.println("Country: " + driver.findElement(By.id("country")).getAttribute("value"));
//	    System.out.println("Postal Code: " + driver.findElement(By.id("postal_code")).getAttribute("value"));
//	    System.out.println("House Number: " + driver.findElement(By.id("house_number")).getAttribute("value"));
//	    System.out.println("Street: " + driver.findElement(By.id("street")).getAttribute("value"));
//	    System.out.println("City: " + driver.findElement(By.id("city")).getAttribute("value"));
//	    System.out.println("State: " + driver.findElement(By.id("state")).getAttribute("value"));


	    // Verify Proceed Button
	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='proceed-3']")));

	    boolean status = driver.findElement(
	        By.cssSelector("[data-test='proceed-3']")).isEnabled();

	    Assert.assertTrue(status, "Proceed button is disabled");

	    test.pass("Proceed button is enabled");

	    che.ClickProceed();

	    test.pass("Proceed button clicked successfully");
	}
	

	@Test(priority = 2)
	public void VerifyInvalidPostcode() throws IOException
	{
	    test = extent.createTest("Invalid Postcode Verification");
	    
	    driver.get("https://practicesoftwaretesting.com/");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    hom = new Home_page(driver);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector("[data-test='search-query']")));

	    hom.Search("Pliers");
	    hom.ClickPliers();

	    det = new Details_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='add-to-cart']")));

	    det.ClickAddToCart();

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='nav-cart']")));

	    det.ClickCart();

	    cart = new Cart_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='proceed-1']")));

	    cart.ClickProceedToCheckout();

	    log = new Login_page(driver);

//	    wait.until(ExpectedConditions.visibilityOfElementLocated(
//	        By.cssSelector("[data-test='email']")));

//	    log.Signintest("customer2@practicesoftwaretesting.com", "welcome01");
//
//	    wait.until(ExpectedConditions.elementToBeClickable(
//	        By.cssSelector("[data-test='proceed-2']")));

	    log.ClickProceed();

	    che = new Checkout_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='country']")));

	    che.SelectCountry("India");

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='postal_code']")));

	    che.EnterPostcode("ABCDE");

	    String value = driver.findElement(By.id("postal_code"))
	                          .getAttribute("value");

	    if(value.equals("ABCDE"))
	    {
	        String ScreenShotPath = Reporter_class.screenshotMethod(driver, "InvalidPostcode");

	        test.fail("Bug: Postal code accepts alphabetic characters");
	        test.addScreenCaptureFromPath(ScreenShotPath);

	        Assert.fail("Postal code accepts invalid data");
	    }
	    else
	    {
	        test.pass("Postal code validation working");
	    }
	}
	
	
	
	@Test(priority = 3)
	public void VerifyInvalidHouseNumber() throws IOException
	{
	    test = extent.createTest("Invalid House Number Verification");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    driver.get("https://practicesoftwaretesting.com/");

	    hom = new Home_page(driver);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector("[data-test='search-query']")));

	    hom.Search("Pliers");
	    hom.ClickPliers();

	    det = new Details_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='add-to-cart']")));

	    det.ClickAddToCart();

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='nav-cart']")));

	    det.ClickCart();

	    cart = new Cart_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='proceed-1']")));

	    cart.ClickProceedToCheckout();

	    log = new Login_page(driver);

//	    wait.until(ExpectedConditions.visibilityOfElementLocated(
//	        By.cssSelector("[data-test='email']")));

//	    log.Signintest("customer2@practicesoftwaretesting.com", "welcome01");
//
//	    wait.until(ExpectedConditions.elementToBeClickable(
//	        By.cssSelector("[data-test='proceed-2']")));

	    log.ClickProceed();

	    che = new Checkout_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='country']")));

	    che.SelectCountry("India");

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='postal_code']")));

	    che.EnterPostcode("695001");

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='house_number']")));

	    che.EnterHouseNumber("@@@");

	    String value = driver.findElement(By.id("house_number"))
	                          .getAttribute("value");

	    if(value.equals("@@@"))
	    {
	        String ScreenShotPath = Reporter_class.screenshotMethod(
	            driver, "InvalidHouseNumber");

	        test.fail("Bug: House number accepts special characters");
	        test.addScreenCaptureFromPath(ScreenShotPath);

	        Assert.fail("House number accepts invalid data");
	    }
	    else
	    {
	        test.pass("House number validation working");
	    }
	}
	
	@Test(priority = 4)
	public void VerifyInvalidBankDetails() throws IOException
	{
	    test = extent.createTest("Invalid Bank Details Verification");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Open website
	    driver.get("https://practicesoftwaretesting.com/");

	    // Search and select product
	    hom = new Home_page(driver);
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector("[data-test='search-query']")));

	    hom.Search("Pliers");
	    hom.ClickPliers();

	    // Add product to cart
	    det = new Details_page(driver);
	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='add-to-cart']")));

	    det.ClickAddToCart();

	    // Open cart
	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='nav-cart']")));

	    det.ClickCart();

	    // Proceed to checkout
	    cart = new Cart_page(driver);
	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='proceed-1']")));

	    cart.ClickProceedToCheckout();

	    // Login
	    log = new Login_page(driver);

	    // Use the working login-page wait and locator from your Login test
//	    log.Signintest("customer2@practicesoftwaretesting.com", "welcome01");
//
//	    wait.until(ExpectedConditions.elementToBeClickable(
//	        By.cssSelector("[data-test='proceed-2']")));

	    log.ClickProceed();

	    // Checkout page
	    che = new Checkout_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='country']")));

	    // Enter address details
	    che.SelectCountry("India");
	    che.EnterPostcode("695001");
	    che.EnterHouseNumber("42");
	    
	    wait.until(ExpectedConditions.elementToBeClickable(
		        By.cssSelector("[data-test='proceed-3']")));
	
		    boolean status = driver.findElement(
		        By.cssSelector("[data-test='proceed-3']")).isEnabled();
	
		    Assert.assertTrue(status, "Proceed button is disabled");
	
		    test.pass("Proceed button is enabled");
	
		    che.ClickProceed();

	    // Select Bank Transfer
	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='payment-method']")));

	    che.SelectPaymentMethod("Bank Transfer");

	    // Enter invalid bank details
	    che.EnterBankDetails("@@@123", "123@@@", "ABCDE");

	    // Check entered values
	    String bank = driver.findElement(By.id("bank_name")).getAttribute("value");
	    String account = driver.findElement(By.id("account_name")).getAttribute("value");
	    String number = driver.findElement(By.id("account_number")).getAttribute("value");

	    if(bank.equals("@@@123") && account.equals("123@@@") && number.equals("ABCDE"))
	    {
	        String ScreenShotPath = Reporter_class.screenshotMethod(driver, "InvalidBankDetails");

	        test.fail("Bank Transfer fields accept invalid characters");
	        test.addScreenCaptureFromPath(ScreenShotPath);

	        Assert.fail("Invalid bank details were accepted in the input fields");
	    }
	    else
	    {
	        test.pass("Bank details fields rejected the entered values");
	    }
	}
	
	@Test(priority = 5)
	public void VerifyInvalidCreditCardDetails() throws IOException
	{
	    test = extent.createTest("Invalid Credit Card Details Verification");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Open website
	    driver.get("https://practicesoftwaretesting.com/");

	    // Search product
	    hom = new Home_page(driver);

	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector("[data-test='search-query']")));

	    hom.Search("Pliers");
	    hom.ClickPliers();

	    // Add to cart
	    det = new Details_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='add-to-cart']")));

	    det.ClickAddToCart();

	    // Open cart
	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='nav-cart']")));

	    det.ClickCart();

	    // Proceed to checkout
	    cart = new Cart_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='proceed-1']")));

	    cart.ClickProceedToCheckout();

	    // Login
	    log = new Login_page(driver);

	    // Use your existing working login method
//	    log.Signintest("customer2@practicesoftwaretesting.com", "welcome01");
//
//	    wait.until(ExpectedConditions.elementToBeClickable(
//	        By.cssSelector("[data-test='proceed-2']")));

	    log.ClickProceed();

	    // Checkout page
	    che = new Checkout_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='country']")));

	    // Enter address
	    che.SelectCountry("India");
	    che.EnterPostcode("695001");
	    che.EnterHouseNumber("42");
	    
	    wait.until(ExpectedConditions.elementToBeClickable(
		        By.cssSelector("[data-test='proceed-3']")));
	
		    boolean status = driver.findElement(
		        By.cssSelector("[data-test='proceed-3']")).isEnabled();
	
		    Assert.assertTrue(status, "Proceed button is disabled");
	
		    test.pass("Proceed button is enabled");

	    che.ClickProceed();

	    // Select Credit Card
	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='payment-method']")));

	    che.SelectPaymentMethod("Credit Card");

	    // Enter invalid credit card details
	    che.EnterCreditCardDetails(
	        "4111-1111-1111-1111",
	        "12/2028",
	        "123",
	        "Rejo Robin"
	    );

	    // Verify credit card number validation
	    
	    wait.until(ExpectedConditions.elementToBeClickable(
	    	    By.cssSelector("[data-test='finish']")));

	    	che.ClickCheckPayment();

	    	// Second step: Wait until button text changes to Confirm
	    	wait.until(ExpectedConditions.textToBe(
	    	    By.cssSelector("[data-test='finish']"), "Confirm"));

	    	// Second click: Confirm
	    	che.ClickCheckPayment();
	    	
	    	wait.until(ExpectedConditions.visibilityOfElementLocated(
	    		    By.id("order-confirmation")));

	    		if(che.VerifyOrderConfirmation())
	    		{
	    		    String message = driver.findElement(By.id("order-confirmation")).getText();
	    		    
	    		    System.out.println("Order Confirmation: " + message);

	    		    test.pass("Payment successful: " + message);
	    		}
	    		else
	    		{
	    		    test.fail("Order confirmation message not displayed");
	    		    Assert.fail("Payment confirmation failed");
	    		}
	}
	
	
		
    	

    }