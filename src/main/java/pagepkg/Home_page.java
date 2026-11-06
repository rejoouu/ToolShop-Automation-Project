package pagepkg;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Home_page {
	
	 WebDriver driver;

	    @FindBy(id = "Layer_1")
	    WebElement logo;

	    @FindBy(id = "search-query")
	    WebElement searchbox;
	    
	    @FindBy(css = "[data-test='search-submit']")
	    WebElement searchbtn;
	    
	    @FindBy(css = "img[alt='Pliers']")
	    WebElement pliers;
	    
	    @FindBy(css = ".card")
	    List<WebElement> products;
	    
	    @FindBy(css = "[data-test='nav-cart']")
	    WebElement cartIcon;
	    
	    @FindBy(css = "[data-test='nav-contact']")
	    WebElement contact;
	    
	    @FindBy(css = "[data-test='first-name']")
	    WebElement firstname;

	    @FindBy(css = "[data-test='last-name']")
	    WebElement lastname;

	    @FindBy(css = "[data-test='email']")
	    WebElement email;

	    @FindBy(css = "[data-test='subject']")
	    WebElement subject;

	    @FindBy(css = "[data-test='message']")
	    WebElement message;

	    @FindBy(css = "[data-test='contact-submit']")
	    WebElement submitbtn;
	    
	    @FindBy(css = "[data-test='language-select']")
	    WebElement language;
	    
	    @FindBy(css = "[data-test='lang-fr']")
	    WebElement french;



	    
	    

	    public Home_page(WebDriver driver) {
	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }

	    public String VerifyHomePageTitle() {
	        return driver.getTitle();
	    }

	    public boolean VerifyLogoDisplayed() {
	        return logo.isDisplayed();
	    }

	    public boolean VerifySearchDisplayed() {
	        return searchbox.isDisplayed();
	    }

	    public void Search(String product) {
	        searchbox.clear();
	        searchbox.sendKeys(product);
	        searchbtn.click();
	    }
	    
	    public void ClickPliers() {
	    	
	    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.elementToBeClickable(pliers));

	        pliers.click();
	    }
	    
	    public boolean VerifyPliersDisplayed() {
	        return pliers.isDisplayed();
	    }
	    
	    public void PrintProductDetails()
	    {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
	                By.cssSelector(".card")));

	        List<WebElement> products = driver.findElements(By.cssSelector(".card"));

	        for(int i = 0; i < products.size(); i++)
	        {
	            // Locate products again to avoid stale elements
	            List<WebElement> updatedProducts = driver.findElements(By.cssSelector(".card"));

	            System.out.println("Product Details: " + updatedProducts.get(i).getText());
	            System.out.println("----------------------------");
	        }
	    }
	    
	    public void ClickContact()
	    {
	        contact.click();
	    }
	    
	    public void EnterContactDetails()
	    {
	        firstname.sendKeys("Rejo");
	        lastname.sendKeys("Robin");
	        email.sendKeys("rejorobin@gmail.com12414");
	        subject.sendKeys("Customer service");
	        message.sendKeys("Gmail, now powered by Gemini AI. Unlock new ways to write, reply and organise your emails. Experience a more intelligent and secure inbox. Gmail, now powered by Gemini AI.");
	    }
	    
	    public String VerifyEmailValue()
	    {
	        return email.getAttribute("value");
	    }
	    
	    public void ClickSubmit()
	    {
	        submitbtn.click();
	    }
	    
	    public void ClickLanguage()
	    {
	        language.click();
	    }
	    
	    public void SelectFrench()
	    {
	        french.click();
	    }
	    
	    
	 
	}

