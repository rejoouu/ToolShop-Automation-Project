package testpkg;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporter_class;
import pagepkg.Home_page;
import pagepkg.Login_page;
import pagepkg.Myaccount_page;

public class Home_test extends Base_class {
	
	
	Home_page hom;
	
	
	 @Test(priority = 1)
	    public void titleverify() throws IOException {

	        test = extent.createTest("Home Page Title Verification");
	        
	        hom = new Home_page(driver);
	        hom.PrintProductDetails();

	        String expectedTitle = "Practice Software Testing - Toolshop - v5.0";

	        if (hom.VerifyHomePageTitle().equals(expectedTitle)) {

	            test.pass("Home page title is correct");

	        } else {

	            String screenshotName = "Home Page Title Failed";
	            String screenshotPath =
	                    Reporter_class.screenshotMethod(driver, screenshotName);

	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Home page title verification failed");

	            Assert.fail("Home page title verification failed");
	        }
	    }
	 
	 @Test(priority = 2)
	    public void logoverify() throws IOException {

	        test = extent.createTest("Home Page Logo Verification");

	        hom = new Home_page(driver);

	        if (hom.VerifyLogoDisplayed()) {

	            test.pass("Home page logo is displayed");

	        } else {

	            String screenshotName = "Home Page Logo Failed";
	            String screenshotPath =
	                    Reporter_class.screenshotMethod(driver, screenshotName);

	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Home page logo verification failed");

	            Assert.fail("Home page logo verification failed");
	        }
	    }
	 
	 @Test(priority = 3)
	    public void searchboxverify() throws IOException {

	        test = extent.createTest("Search Box Verification");

	        hom = new Home_page(driver);

	        if (hom.VerifySearchDisplayed()) {

	            test.pass("Search box is displayed");

	        } else {

	            String screenshotName = "Search Box Failed";
	            String screenshotPath =
	                    Reporter_class.screenshotMethod(driver, screenshotName);

	            test.addScreenCaptureFromPath(screenshotPath);
	            test.fail("Search box verification failed");

	            Assert.fail("Search box verification failed");
	        }
	    }
	 
	 
	 
	 @Test(priority = 7)
	 public void searchverify() throws IOException {

	     test = extent.createTest("Search Functionality Verification");

	     driver.get("https://practicesoftwaretesting.com/");

	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	     wait.until(ExpectedConditions.visibilityOfElementLocated(
	             By.cssSelector("[data-test='search-query']")
	     ));

	     hom = new Home_page(driver);

	     hom.Search("pliers");

	     wait.until(ExpectedConditions.visibilityOfElementLocated(
	             By.cssSelector("img[alt='Combination Pliers']")
	     ));

	     if(hom.VerifyPliersDisplayed()) {

	         test.pass("Search functionality is working correctly");

	     } else {

	         String ScreenShotName = "Search Functionality Failed";

	         String ScreenShotPath =
	                 Reporter_class.screenshotMethod(driver, ScreenShotName);

	         test.addScreenCaptureFromPath(ScreenShotPath);

	         test.fail("Search functionality verification failed");

	         Assert.fail("Search functionality verification failed");
	     }
	 }
	 
	 
	 
	 
	 @Test(priority=8)
	 public void productdetailsnavigation() throws IOException
	 {
	     test = extent.createTest("Product Details Page Navigation");

	     hom = new Home_page(driver);

	     hom.Search("pliers");

	     hom.ClickPliers();

	     String expected = "https://practicesoftwaretesting.com/product/01M4MNAZWTZHNBNXPNYMEHZN7D";

	     WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	     wait.until(ExpectedConditions.urlToBe(expected));

	     if(driver.getCurrentUrl().equals(expected))
	     {
	         test.pass("Product details page opened successfully");
	     }
	     else
	     {
	         String ScreenShotName = "Product Details Navigation Failed";

	         String ScreenShotPath =
	                 Reporter_class.screenshotMethod(driver, ScreenShotName);

	         test.addScreenCaptureFromPath(ScreenShotPath);

	         test.fail("Product details page navigation failed");

	         Assert.fail("Product details page navigation failed");
	     }
	 }

    @Test(priority = 4)
    public void contactverify() throws IOException {

    test = extent.createTest("Contact Link Verification");

    driver.get("https://practicesoftwaretesting.com/");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.elementToBeClickable(
            By.cssSelector("[data-test='nav-contact']")
    ));

    hom = new Home_page(driver);

    hom.ClickContact();

    wait.until(ExpectedConditions.urlContains("/contact"));

    if(driver.getCurrentUrl().contains("/contact")) {

        test.pass("Contact link is working correctly");

    } else {

        String ScreenShotName = "Contact Link Failed";
        String ScreenShotPath =
                Reporter_class.screenshotMethod(driver, ScreenShotName);

        test.addScreenCaptureFromPath(ScreenShotPath);
        test.fail("Contact link verification failed");

        Assert.fail("Contact link verification failed");
    }
}
    

@Test(priority = 5)
public void emailverify() throws IOException
{
    test = extent.createTest("Contact Email Validation");

    driver.get("https://practicesoftwaretesting.com/contact");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.visibilityOfElementLocated(
            By.cssSelector("[data-test='first-name']")));

    hom = new Home_page(driver);

    hom.EnterContactDetails();

    hom.ClickSubmit();

    if(hom.VerifyEmailValue().matches(
            "(?i)^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.com[0-9]+$"))
    {
        String ScreenShotName = "Email Validation Failed";

        String ScreenShotPath =
                Reporter_class.screenshotMethod(driver, ScreenShotName);

        test.fail("Email field accepts digits after .com");

        test.addScreenCaptureFromPath(ScreenShotPath);

        Assert.fail("Email validation failed");
    }
    else
    {
        test.pass("Invalid email rejected");
    }
}


	 
    @Test(priority = 6)
    public void verifyFrenchLanguage() throws IOException
   {
    hom = new Home_page(driver);

    test = extent.createTest("French Language Verification");

    driver.get("https://practicesoftwaretesting.com/");

    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    // Click Language Dropdown
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector("[data-test='language-select']")));

    hom.ClickLanguage();

    // Select French
    wait.until(ExpectedConditions.elementToBeClickable(
        By.cssSelector("[data-test='lang-fr']")));

    hom.SelectFrench();

    // Wait for language selection
    wait.until(ExpectedConditions.textToBePresentInElementLocated(
        By.cssSelector("[data-test='language-select']"), "FR"));

    // Wait for Product Cards
    wait.until(ExpectedConditions.visibilityOfElementLocated(
        By.cssSelector(".card")));

    // Verify Product Labels
    List<WebElement> products = driver.findElements(By.cssSelector(".card"));

    boolean englishFound = false;

    for (WebElement product : products)
    {
        String productText = product.getText();

        System.out.println(productText);

        if (productText.matches("(?s).*[a-zA-Z]+.*"))
        {
            englishFound = true;
            break;
        }
    }

    if (englishFound)
    {
        String screenshot = Reporter_class.screenshotMethod(driver, "FrenchLanguageFailure");

        test.fail("Product labels are not translated into French");
        test.addScreenCaptureFromPath(screenshot);

        Assert.fail("French language verification failed");
    }
    else
    {
        test.pass("Product labels are displayed in French");
    }
}
	 
	 

}
