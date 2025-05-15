package pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.Given;
import utils.ActionHelper;
import utils.LoggerUtility;

public class CartPage {
	
	private WebDriver driver;
    private ActionHelper action;
    private Logger log = LoggerUtility.getLogger(CartPage.class);
    
    public CartPage(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionHelper(driver);
        log.info("CartPage initialized");
    }
    
    
    //Locators
    private final By cartQuantity = By.cssSelector("button.disabled");
    private final By removeProductButton  = By.xpath("//a[@class='cart_quantity_delete']");
    
    public String getCartProductQuantity() {
        log.info("Getting product quantity from cart");
        return action.getText(cartQuantity);
    }
    
    
    public void cleanCart() {
    	log.info("Empting cart...");
        List<WebElement> removeButtons = action.findElements(removeProductButton);
        if(removeButtons.isEmpty()) {
        	return;
        }else {
        	for(WebElement element: removeButtons) {
            	element.click();
            }
        }
    }

}
