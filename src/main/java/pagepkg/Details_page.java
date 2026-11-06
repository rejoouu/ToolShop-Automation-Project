package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Details_page {
	
	  WebDriver driver;
	  
	  @FindBy(css="[data-test='product-name']")
	  WebElement productname;
	  
	  @FindBy(css="img[alt='Combination Pliers']")
	  WebElement productimage;
	  
	  @FindBy(css="[data-test='unit-price']")
	  WebElement productprice;
	  
	  @FindBy(css="[data-test='product-description']")
	  WebElement productdescription;
	  
	  @FindBy(css="[data-test='quantity']")
	  WebElement quantity;
	  
	  @FindBy(css="[data-test='add-to-cart']")
	  WebElement addtocart;
	  
	  @FindBy(css="div.toast-success")
	  WebElement successpopup;
	  
	  @FindBy(css = "[data-test='nav-cart']")
	  WebElement cart;

	    public Details_page(WebDriver driver) {

	        this.driver = driver;

	        PageFactory.initElements(driver, this);
	    }

	    public String VerifyProductDetailsPageTitle() {

	        return driver.getTitle();
	    }
	    
	    public boolean VerifyProductName() {

	        return productname.isDisplayed();
	    }
	    
	    public boolean VerifyProductImage() {
	        return productimage.isDisplayed();
	    }
	    
	    public boolean VerifyProductPrice() {
	        return productprice.isDisplayed();
	    }
	    
	    public boolean VerifyProductDescription() {
	        return productdescription.isDisplayed();
	    }
	    
	    public boolean VerifyQuantityField() {
	        return quantity.isDisplayed();
	    }
	    
	    public boolean VerifyAddToCartButton() {
	        return addtocart.isDisplayed() && addtocart.isEnabled();
	    }
	    
	    public void ClickAddToCart() {
	        addtocart.click();
	    }
	    
	    public boolean VerifySuccessPopup() {

	        return successpopup.isDisplayed();
	    }
	    
	    public void ClickCart()
	    {
	        cart.click();
	    }

}
