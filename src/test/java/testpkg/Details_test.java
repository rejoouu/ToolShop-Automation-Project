package testpkg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporter_class;
import pagepkg.Details_page;
import pagepkg.Home_page;


public class Details_test extends Base_class{
	
	
	Home_page hom;
	Details_page det;
	
	@Test(priority=1)
	public void detailspagetitleverify() throws IOException
	{
	    test = extent.createTest("Product Details Page Title Verification");

	    driver.get("https://practicesoftwaretesting.com/");

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    hom = new Home_page(driver);

	    // Wait for Search Box
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector("[data-test='search-query']")));

	    
	    hom.Search("pliers");

	    // Wait for Search Results
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	        By.cssSelector(".card")));

	    // Wait for Product and Click
	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector(".card")));

	    hom.ClickPliers();

	    // Wait for Product Details Page Title
	    wait.until(ExpectedConditions.titleContains("Combination Pliers"));

	    det = new Details_page(driver);

	    String actualTitle = det.VerifyProductDetailsPageTitle();

	    String expectedTitle = "Combination Pliers - Practice Software Testing - Toolshop - v5.0";

	    if (actualTitle.equals(expectedTitle))
	    {
	        test.pass("Product Details Page title is correct");
	    }
	    else
	    {
	        String ScreenShotName = "Details Page Title Failed";

	        String ScreenShotPath =
	                Reporter_class.screenshotMethod(driver, ScreenShotName);

	        test.addScreenCaptureFromPath(ScreenShotPath);

	        test.fail("Product Details Page title verification failed");

	        Assert.fail("Product Details Page title verification failed");
	    }
	}
	
	
	
	@Test(priority=2)
	public void productnameverify() throws IOException {

	    test = extent.createTest("Product Name Verification");

	    hom = new Home_page(driver);
	    
	    driver.get("https://practicesoftwaretesting.com/");
	    
	    hom.Search("pliers");
	    hom.ClickPliers();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("[data-test='product-name']")));

	    det = new Details_page(driver);

	    if (det.VerifyProductName()) {

	        test.pass("Product name is displayed");

	    } else {

	        String ScreenShotName = "Product Name Verification Failed";
	        String ScreenShotPath =
	                Reporter_class.screenshotMethod(driver, ScreenShotName);

	        test.addScreenCaptureFromPath(ScreenShotPath);
	        test.fail("Product name is not displayed");

	        Assert.fail("Product name is not displayed");
	    }
	}
	
	
	
	@Test(priority=3)
	public void productimageverify() throws IOException {

	    test = extent.createTest("Product Image Verification");

	    hom = new Home_page(driver);
	    
	    driver.get("https://practicesoftwaretesting.com/");
	    
	    hom.Search("pliers");
	    hom.ClickPliers();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("img[alt='Combination Pliers']")));

	    det = new Details_page(driver);

	    if (det.VerifyProductImage()) {

	        test.pass("Product image is displayed");

	    } else {

	        String ScreenShotName = "Product Image Verification Failed";
	        String ScreenShotPath =
	                Reporter_class.screenshotMethod(driver, ScreenShotName);

	        test.addScreenCaptureFromPath(ScreenShotPath);
	        test.fail("Product image is not displayed");

	        Assert.fail("Product image is not displayed");
	    }
	}
	
	
	
	@Test(priority=4)
	public void productpriceverify() throws IOException {

	    test = extent.createTest("Product Price Verification");

	    hom = new Home_page(driver);
	    driver.get("https://practicesoftwaretesting.com/");
	    
	    hom.Search("pliers");
	    hom.ClickPliers();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("[data-test='unit-price']")));

	    det = new Details_page(driver);

	    if (det.VerifyProductPrice()) {

	        test.pass("Product price is displayed");

	    } else {

	        String ScreenShotName = "Product Price Verification Failed";
	        String ScreenShotPath =
	                Reporter_class.screenshotMethod(driver, ScreenShotName);

	        test.addScreenCaptureFromPath(ScreenShotPath);
	        test.fail("Product price is not displayed");

	        Assert.fail("Product price is not displayed");
	    }
	}
	
	
	
	@Test(priority=5)
	public void productdescriptionverify() throws IOException {

	    test = extent.createTest("Product Description Verification");

	    hom = new Home_page(driver);
	    driver.get("https://practicesoftwaretesting.com/");
	    hom.Search("pliers");
	    hom.ClickPliers();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("[data-test='product-description']")));

	    det = new Details_page(driver);

	    if (det.VerifyProductDescription()) {

	        test.pass("Product description is displayed");

	    } else {

	        String ScreenShotName = "Product Description Verification Failed";
	        String ScreenShotPath =
	                Reporter_class.screenshotMethod(driver, ScreenShotName);

	        test.addScreenCaptureFromPath(ScreenShotPath);
	        test.fail("Product description is not displayed");

	        Assert.fail("Product description is not displayed");
	    }
	}
	
	
	
	@Test(priority=6)
	public void quantityfieldverify() throws IOException {

	    test = extent.createTest("Quantity Field Verification");

	    hom = new Home_page(driver);
	    driver.get("https://practicesoftwaretesting.com/");
	    hom.Search("pliers");
	    hom.ClickPliers();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("[data-test='quantity']")));

	    det = new Details_page(driver);

	    if (det.VerifyQuantityField()) {

	        test.pass("Quantity field is displayed");

	    } else {

	        String ScreenShotName = "Quantity Field Verification Failed";
	        String ScreenShotPath =
	                Reporter_class.screenshotMethod(driver, ScreenShotName);

	        test.addScreenCaptureFromPath(ScreenShotPath);
	        test.fail("Quantity field is not displayed");

	        Assert.fail("Quantity field is not displayed");
	    }
	}
	
	
	
	@Test(priority=7)
	public void addtocartbuttonverify() throws IOException {

	    test = extent.createTest("Add to Cart Button Verification");
	    hom = new Home_page(driver);
	    driver.get("https://practicesoftwaretesting.com/");
	    hom.Search("pliers");
	    hom.ClickPliers();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(
	            By.cssSelector("[data-test='add-to-cart']")));

	    det = new Details_page(driver);

	    if (det.VerifyAddToCartButton()) {

	        test.pass("Add to Cart button is displayed and enabled");

	    } else {

	        String ScreenShotName = "Add to Cart Button Verification Failed";
	        String ScreenShotPath =
	                Reporter_class.screenshotMethod(driver, ScreenShotName);

	        test.addScreenCaptureFromPath(ScreenShotPath);
	        test.fail("Add to Cart button is not displayed or enabled");

	        Assert.fail("Add to Cart button is not displayed or enabled");
	    }
	    
	    det.ClickAddToCart();

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div.toast-success")));

        if (det.VerifySuccessPopup()) {

            test.pass("Product was added to cart successfully");

        } else {

            String ScreenShotName = "Add to Cart Functionality Failed";
            String ScreenShotPath =
                    Reporter_class.screenshotMethod(driver, ScreenShotName);

            test.addScreenCaptureFromPath(ScreenShotPath);
            test.fail("Product was not added to cart");

            Assert.fail("Product was not added to cart");
        }
	    
	    
	}
	
	@Test(priority = 8)
	public void verifycartclickable() throws IOException
	{
	    test = extent.createTest("Cart Icon Clickable Verification");

	    driver.get("https://practicesoftwaretesting.com/");

	    det = new Details_page(driver);

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("[data-test='nav-cart']")));

	    det.ClickCart();

	    wait.until(ExpectedConditions.urlContains("/checkout"));

	    if(driver.getCurrentUrl().contains("/checkout"))
	    {
	        test.pass("Cart icon is clickable and navigates to checkout page");
	    }
	    else
	    {
	        String ScreenShotName = "Cart Click Failed";
	        String ScreenShotPath = Reporter_class.screenshotMethod(driver, ScreenShotName);

	        test.addScreenCaptureFromPath(ScreenShotPath);
	        test.fail("Cart icon is not clickable");
	        Assert.fail("Cart icon verification failed");
	    }
	}
	

	

}
