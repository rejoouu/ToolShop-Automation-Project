 package pagepkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Cart_page {
	
	WebDriver driver;
	
	
	@FindBy(css="[data-test='product-title']")
	WebElement producttitle;
	
	@FindBy(css="[data-test='product-price']")
	WebElement productprice;
	
	 @FindBy(css="[data-test='cart-total']")
	    WebElement carttotal;
	 
	 @FindBy(css="[data-test='proceed-1']")
	 WebElement proceedcheckout;
	 
	 @FindBy(css = "a.btn.btn-danger")
	 WebElement removeproduct;
	
	
	 public Cart_page(WebDriver driver) {

	        this.driver = driver;
	        PageFactory.initElements(driver, this);
	    }


	    
	    
	    public boolean VerifyProduct() {
	        return producttitle.isDisplayed();
	    }
	    
	    
	    public boolean VerifyProductPrice() {
	        return productprice.isDisplayed();
	    }
	    
	    
	    
	    public String GetCartTotal() {
	        return carttotal.getText();
	    }
	    
	    
	    
	    public void ClickProceedToCheckout() {
	        proceedcheckout.click();
	    }
	  
	    public void ClearCart()
	    {
	        removeproduct.click();
	    }

}
