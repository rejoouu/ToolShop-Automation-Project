package testpkg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporter_class;
import pagepkg.Cart_page;
import pagepkg.Details_page;
import pagepkg.Home_page;
import pagepkg.Login_page;

public class Login_test extends Base_class
{
	Login_page log;
	Home_page hom;
	Details_page det;
	Cart_page cart;
	
	@DataProvider(name="Logindata")
	public Object[][] logindata() throws IOException
	{
		return utilities.Excelutils.getTestData("C:\\Users\\ronir\\OneDrive\\ye concert\\Tooldata.xlsx","Sheet1");
	}
	
		
	
	@Test(priority = 1)
	public void Uitest() throws IOException
	{
	    driver.get("https://practicesoftwaretesting.com/");

	    test = extent.createTest("Login UI Verification");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Search Product
	    hom = new Home_page(driver);

	    hom.Search("pliers");
	    hom.ClickPliers();

	    // Add Product to Cart
	    det = new Details_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("[data-test='add-to-cart']")));

	    det.ClickAddToCart();

	    // Navigate to Cart
	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("[data-test='nav-cart']")));

	    det.ClickCart();

	    // Proceed to Checkout
	    cart = new Cart_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("[data-test='proceed-1']")));

	    cart.ClickProceedToCheckout();

	    // Login UI Verification
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.id("email")));

	    log = new Login_page(driver);

	    Assert.assertEquals(log.VerifyLoginPageTitle(),
	            "Checkout - Practice Software Testing - Toolshop - v5.0");
	    test.pass("Login page title is verified");

	    Assert.assertTrue(log.VerifyEmailDisplayed());
	    test.pass("Email field is displayed");

	    Assert.assertTrue(log.VerifyPasswordDisplayed());
	    test.pass("Password field is displayed");

	    Assert.assertTrue(log.Verifyloginbtn());
	    test.pass("Login button is displayed");
	}
	
	@Test(dataProvider = "Logindata", priority =2)
	public void Login(String mail, String password) throws IOException, InterruptedException
	{
	    test = extent.createTest("Login Test - " + mail);

	    driver.get("https://practicesoftwaretesting.com/");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    // Search Product
	    hom = new Home_page(driver);

	    hom.Search("pliers");
	    hom.ClickPliers();

	    // Add Product to Cart
	    det = new Details_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("[data-test='add-to-cart']")));

	    det.ClickAddToCart();

	    // Navigate to Cart
	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("[data-test='nav-cart']")));

	    det.ClickCart();

	    // Proceed to Checkout
	    cart = new Cart_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("[data-test='proceed-1']")));

	    cart.ClickProceedToCheckout();

	    // Login Page Verification
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.id("email")));
	    log = new Login_page(driver);
	    log.Signintest(mail, password);
	    
	    Thread.sleep(2000);

	    if (driver.findElements(By.cssSelector(".help-block")).size() > 0)
	    {
	        String screenshotName = "Failed for " + mail;

	        String screenshotPath = Reporter_class.screenshotMethod(driver, screenshotName);

	        test.addScreenCaptureFromPath(screenshotPath);
	        test.fail("Login Failed");

	        Assert.fail("Login Failed for " + mail);
	    }
	    else
	    {
	        test.pass("Login Successful for " + mail);
	    }
	    
	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("[data-test='proceed-2']")));
	    
	    log = new Login_page(driver);
	    log.ClickProceed();
	}
	
	
	

}
