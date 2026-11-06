package testpkg;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import basepkg.Base_class;
import basepkg.Reporter_class;
import pagepkg.Login_page;
import pagepkg.Myaccount_page;

public class Myaccount_test extends Base_class{
	
	Login_page log;
	Myaccount_page acc;
	
	@Test(priority=1)
	public void myaccountverify() throws IOException {

	    test = extent.createTest("Favourites Navigation Verification");
	    driver.get("https://practicesoftwaretesting.com/auth/login");

	    log = new Login_page(driver);

	    log.Signintest("customer3@practicesoftwaretesting.com", "pass123");
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	    wait.until(ExpectedConditions.urlToBe(
	        "https://practicesoftwaretesting.com/account"
	    ));
	    
	    System.out.println("Current URL: " + driver.getCurrentUrl());
	    System.out.println("Page title: " + driver.getTitle());
	    System.out.println("Page source contains overview: "
	            + driver.getPageSource().contains("app-overview"));

	    
	    System.out.println("Current URL: " + driver.getCurrentUrl());

	    acc = new Myaccount_page(driver);

	    if (acc.verifyfavouritesnav()) {

	        test.pass("Favourites navigation is enabled");

	    } else {

	        String screenshotName = "Favourites Navigation Failed";

	        String screenshotPath =
	                Reporter_class.screenshotMethod(driver, screenshotName);

	        test.addScreenCaptureFromPath(screenshotPath);

	        test.fail("Favourites navigation verification failed");

	        Assert.fail("Favourites navigation verification failed");
	    }
	}
		 
	
	@Test(priority=2)
	public void profileverify() throws IOException {

	    test = extent.createTest("Profile Navigation Verification");

	    acc = new Myaccount_page(driver);

	    if (acc.verifyprofilenav()) {

	        test.pass("Profile navigation is enabled");

	    } else {

	        String screenshotName = "Profile Navigation Failed";
	        String screenshotPath = Reporter_class.screenshotMethod(driver, screenshotName);

	        test.addScreenCaptureFromPath(screenshotPath);
	        test.fail("Profile navigation verification failed");

	        Assert.fail("Profile navigation verification failed");
	    }
	}
	
	
	
	@Test(priority=3)
	public void invoicesverify() throws IOException {

	    test = extent.createTest("Invoices Navigation Verification");

	    acc = new Myaccount_page(driver);

	    if (acc.verifyinvoicesnav()) {

	        test.pass("Invoices navigation is enabled");

	    } else {

	        String screenshotName = "Invoices Navigation Failed";
	        String screenshotPath = Reporter_class.screenshotMethod(driver, screenshotName);

	        test.addScreenCaptureFromPath(screenshotPath);
	        test.fail("Invoices navigation verification failed");

	        Assert.fail("Invoices navigation verification failed");
	    }
	}
	
	
	
	@Test(priority=4)
	public void messagesverify() throws IOException {

	    test = extent.createTest("Messages Navigation Verification");

	    acc = new Myaccount_page(driver);

	    if (acc.verifymessagesnav()) {

	        test.pass("Messages navigation is enabled");

	    } else {

	        String screenshotName = "Messages Navigation Failed";
	        String screenshotPath = Reporter_class.screenshotMethod(driver, screenshotName);

	        test.addScreenCaptureFromPath(screenshotPath);
	        test.fail("Messages navigation verification failed");

	        Assert.fail("Messages navigation verification failed");
	    }
	}
	
		 


	    @Test(priority=5)
	    public void homebuttonverify() throws IOException {

	        test = extent.createTest("Home Button Verification");

	     // Go to login page
	        driver.get("https://practicesoftwaretesting.com/auth/login");

	        // Login
	        Login_page log = new Login_page(driver);
	        log.Signintest("customer3@practicesoftwaretesting.com", "pass123");

	        // Wait until My Account page opens
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.urlToBe(
	            "https://practicesoftwaretesting.com/account"
        ));

	        Myaccount_page acc = new Myaccount_page(driver);

	        acc.clickHome();

	        String expectedURL = "https://practicesoftwaretesting.com/";

	        if (driver.getCurrentUrl().equals(expectedURL)) {

	            test.pass("Home button is working correctly");

	        } else {

	            String screenshotName = "Home Button Failed";

	            String screenshotPath =
	                    Reporter_class.screenshotMethod(driver, screenshotName);

	            test.addScreenCaptureFromPath(screenshotPath);

	            test.fail("Home button verification failed");

	            Assert.fail("Home button verification failed");
	        }
	    }

}
