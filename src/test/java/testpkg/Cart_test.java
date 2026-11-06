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
import pagepkg.Cart_page;
import pagepkg.Details_page;
import pagepkg.Home_page;

public class Cart_test extends Base_class{
	
	Home_page hom;
	Details_page det;
	
	
//	@Test
//	public void cartpageverify() throws IOException
//	{
//	    test = extent.createTest("Cart Page Title Verification");
//
//	    driver.get("https://practicesoftwaretesting.com/");
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    hom = new Home_page(driver);
//
//	    hom.Search("pliers");
//	    hom.ClickPliers();
//
//	    det = new Details_page(driver);
//
//	    wait.until(ExpectedConditions.elementToBeClickable(
//	            By.cssSelector("[data-test='add-to-cart']")));
//
//	    det.ClickAddToCart();
//	    
//	    wait.until(ExpectedConditions.elementToBeClickable(
//	            By.cssSelector("[data-test='nav-cart']")));
//
//	    det.ClickCart();
//
//
//	    wait.until(ExpectedConditions.urlContains("/checkout"));
//	    
//	    Cart_page cart = new Cart_page(driver);
//
//	    // Cart Page Title Verification
//	    String title = driver.getTitle();
//
//	    if (title.equals("Checkout - Practice Software Testing - Toolshop - v5.0"))
//	    {
//	        test.pass("Cart page title is correct");
//	    }
//	    else
//	    {
//	        String ScreenShotName = "Cart Page Title Verification Failed";
//	        String ScreenShotPath = Reporter_class.screenshotMethod(driver, ScreenShotName);
//
//	        test.addScreenCaptureFromPath(ScreenShotPath);
//	        test.fail("Cart page title is incorrect");
//
//	        Assert.fail("Expected title: Checkout - Practice Software Testing - Toolshop - v5.0"
//	                + " but found: " + title);
//	    }
//	    
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(
//	    	    By.cssSelector("[data-test='product-title']")));
//
//	    // Product Verification
//	    if (cart.VerifyProduct())
//	    {
//	        test.pass("Combination Pliers is displayed in the cart");
//	    }
//	    else
//	    {
//	        String ScreenShotName = "Cart Product Verification Failed";
//	        String ScreenShotPath = Reporter_class.screenshotMethod(driver, ScreenShotName);
//
//	        test.addScreenCaptureFromPath(ScreenShotPath);
//	        test.fail("Combination Pliers is not displayed in the cart");
//
//	        Assert.fail("Combination Pliers is not displayed in the cart");
//	    }
//
//	    // Product Price Verification
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.cssSelector("[data-test='product-price']")));
//
//	    if (cart.VerifyProductPrice())
//	    {
//	        test.pass("Product price is displayed in the cart");
//	    }
//	    else
//	    {
//	        String ScreenShotName = "Cart Product Price Verification Failed";
//	        String ScreenShotPath = Reporter_class.screenshotMethod(driver, ScreenShotName);
//
//	        test.addScreenCaptureFromPath(ScreenShotPath);
//	        test.fail("Product price is not displayed in the cart");
//
//	        Assert.fail("Product price is not displayed in the cart");
//	    }
//	}
	
	
	
//	@Test
//	public void cartproductverify() throws IOException {
//
//	    test = extent.createTest("Cart Product Verification");
//
//	    hom = new Home_page(driver);
//	    hom.Search("pliers");
//        hom.ClickPliers();
//        
//        det = new Details_page(driver);
//
//        det.ClickAddToCart();
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    wait.until(ExpectedConditions.elementToBeClickable(
//	            By.cssSelector("[data-test='add-to-cart']")));
//
//	    Cart_page cart = new Cart_page(driver);
//	    cart.ClickCart();
//
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(
//	            By.cssSelector("[data-test='product-title']")));
//
//	    if (cart.VerifyProduct()) {
//
//	        test.pass("Combination Pliers is displayed in the cart");
//
//	    } else {
//
//	        String ScreenShotName = "Cart Product Verification Failed";
//	        String ScreenShotPath =
//	                Reporter_class.screenshotMethod(driver, ScreenShotName);
//
//	        test.addScreenCaptureFromPath(ScreenShotPath);
//	        test.fail("Combination Pliers is not displayed in the cart");
//
//	        Assert.fail("Combination Pliers is not displayed in the cart");
//	    }
//	}
	
//	@Test
//	public void cartproductpriceverify() throws IOException {
//
//	    test = extent.createTest("Cart Product Price Verification");
//
//	    driver.get("https://practicesoftwaretesting.com/");
//
//	    hom = new Home_page(driver);
//	    hom.Search("pliers");
//        hom.ClickPliers();
//        
//        det = new Details_page(driver);
//
//        det.ClickAddToCart();
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    wait.until(ExpectedConditions.elementToBeClickable(
//	            By.cssSelector("[data-test='add-to-cart']")));
//	    
//	    Cart_page cart = new Cart_page(driver);
//	    cart.ClickCart();
//
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(
//	        By.cssSelector("[data-test='product-price']")));
//
//	    if (cart.VerifyProductPrice()) {
//
//	        test.pass("Product price is displayed in the cart");
//
//	    } else {
//
//	        String ScreenShotName = "Cart Product Price Verification Failed";
//
//	        String ScreenShotPath =
//	                Reporter_class.screenshotMethod(driver, ScreenShotName);
//
//	        test.addScreenCaptureFromPath(ScreenShotPath);
//
//	        test.fail("Product price is not displayed in the cart");
//
//	        Assert.fail("Product price is not displayed in the cart");
//	    }
//	}
	
//	@Test
//	public void cartproductpricecorrect() throws IOException {
//
//	    test = extent.createTest("Cart Product Price Correctness");
//
//	    driver.get("https://practicesoftwaretesting.com/");
//
//	    hom = new Home_page(driver);
//	    hom.Search("pliers");
//        hom.ClickPliers();
//        
//        det = new Details_page(driver);
//
//        det.ClickAddToCart();
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    wait.until(ExpectedConditions.elementToBeClickable(
//	            By.cssSelector("[data-test='add-to-cart']")));
//
//	    Cart_page cart = new Cart_page(driver);
//	    cart.ClickCart();
//
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(
//	        By.cssSelector("[data-test='product-price']")));
//
//	    String actualprice = cart.GetProductPrice();
//	    String expectedprice = "$29.99";
//
//	    if (actualprice.equals(expectedprice)) {
//
//	        test.pass("Product price is correct: " + actualprice);
//
//	    } else {
//
//	        String ScreenShotName = "Cart Product Price Incorrect";
//
//	        String ScreenShotPath =
//	                Reporter_class.screenshotMethod(driver, ScreenShotName);
//
//	        test.addScreenCaptureFromPath(ScreenShotPath);
//
//	        test.fail("Expected price: " + expectedprice +
//	                  " but actual price: " + actualprice);
//
//	        Assert.fail("Expected price: " + expectedprice +
//	                    " but actual price: " + actualprice);
//	    }
//	}
	
//	@Test
//	public void carttotalverify() throws IOException {
//
//	    test = extent.createTest("Cart Total Verification");
//
//	    driver.get("https://practicesoftwaretesting.com/");
//
//	    hom = new Home_page(driver);
//	    hom.Search("pliers");
//        hom.ClickPliers();
//        
//        det = new Details_page(driver);
//
//        det.ClickAddToCart();
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    wait.until(ExpectedConditions.elementToBeClickable(
//	            By.cssSelector("[data-test='add-to-cart']")));
//
//	    Cart_page cart = new Cart_page(driver);
//	    cart.ClickCart();
//
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(
//	        By.cssSelector("[data-test='cart-total']")));
//
//	    String actualtotal = cart.GetCartTotal();
//	    String expectedtotal = "$14.15";
//
//	    if (actualtotal.equals(expectedtotal)) {
//
//	        test.pass("Cart total is correct: " + actualtotal);
//
//	    } else {
//
//	        String ScreenShotName = "Cart Total Verification Failed";
//
//	        String ScreenShotPath =
//	                Reporter_class.screenshotMethod(driver, ScreenShotName);
//
//	        test.addScreenCaptureFromPath(ScreenShotPath);
//
//	        test.fail("Expected total: " + expectedtotal +
//	                  " but actual total: " + actualtotal);
//
//	        Assert.fail("Expected total: " + expectedtotal +
//	                    " but actual total: " + actualtotal);
//	    }
//	}
	
//	@Test
//	public void cartquantityverify() throws IOException {
//
//	    test = extent.createTest("Cart Quantity Verification");
//
//	    driver.get("https://practicesoftwaretesting.com/");
//
//	    hom = new Home_page(driver);
//	    hom.Search("pliers");
//        hom.ClickPliers();
//        
//        det = new Details_page(driver);
//
//        det.ClickAddToCart();
//
//	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//	    wait.until(ExpectedConditions.elementToBeClickable(
//	            By.cssSelector("[data-test='add-to-cart']")));
//	    
//	    Cart_page cart = new Cart_page(driver);
//	    cart.ClickCart();
//
//	    wait.until(ExpectedConditions.visibilityOfElementLocated(
//	        By.cssSelector("[data-test='product-quantity']")));
//
//	    String actualquantity = cart.GetProductQuantity();
//	    String expectedquantity = "1";
//
//	    if (actualquantity.equals(expectedquantity)) {
//
//	        test.pass("Product quantity is correct: " + actualquantity);
//
//	    } else {
//
//	        String ScreenShotName = "Cart Quantity Verification Failed";
//
//	        String ScreenShotPath =
//	                Reporter_class.screenshotMethod(driver, ScreenShotName);
//
//	        test.addScreenCaptureFromPath(ScreenShotPath);
//
//	        test.fail("Expected quantity: " + expectedquantity +
//	                  " but actual quantity: " + actualquantity);
//
//	        Assert.fail("Expected quantity: " + expectedquantity +
//	                    " but actual quantity: " + actualquantity);
//	    }
//	}
	
	
	@Test
	public void proceedtocheckout() throws IOException {

	    test = extent.createTest("Proceed to Checkout");

	    driver.get("https://practicesoftwaretesting.com/");

	    hom = new Home_page(driver);
	    hom.Search("pliers");
        hom.ClickPliers();
        
        det = new Details_page(driver);
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("[data-test='add-to-cart']")));

	    det.ClickAddToCart();
	    
	    wait.until(ExpectedConditions.elementToBeClickable(
	            By.cssSelector("[data-test='nav-cart']")));

	    det.ClickCart();


	    wait.until(ExpectedConditions.urlContains("/checkout"));

	    Cart_page cart = new Cart_page(driver);

	    wait.until(ExpectedConditions.elementToBeClickable(
	        By.cssSelector("[data-test='proceed-1']")));

	    cart.ClickProceedToCheckout();

	    wait.until(ExpectedConditions.urlContains("/checkout"));

	    if (driver.getCurrentUrl().contains("/checkout")) {

	        test.pass("Successfully navigated to the checkout page");

	    } else {

	        String ScreenShotName = "Proceed To Checkout Failed";

	        String ScreenShotPath =
	                Reporter_class.screenshotMethod(driver, ScreenShotName);

	        test.addScreenCaptureFromPath(ScreenShotPath);

	        test.fail("Failed to navigate to checkout page");

	        Assert.fail("Failed to navigate to checkout page");
	    }
	}

}
