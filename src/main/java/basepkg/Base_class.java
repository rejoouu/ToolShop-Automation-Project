package basepkg;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class Base_class {
	
	public static WebDriver driver;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	String url="https://practicesoftwaretesting.com/";
	
	@BeforeSuite
	public void setup()
	{
		 ChromeOptions options = new ChromeOptions();

		    Map<String, Object> prefs = new HashMap<String, Object>();

		    prefs.put("credentials_enable_service", false);
		    prefs.put("profile.password_manager_enabled", false);
		    prefs.put("profile.password_manager_leak_detection", false);

		    options.setExperimentalOption("prefs", prefs);

		driver = new ChromeDriver(options);
		driver.get(url);
		driver.manage().window().maximize();
		extent = Reporter_class.generatereport();
	}
	
	
	@AfterSuite
	public void teardown()
	{
		driver.quit();
		extent.flush();
	}
	
	

}
