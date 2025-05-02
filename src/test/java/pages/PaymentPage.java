package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ActionHelper;
import utils.ExcelReader;
import utils.LoggerUtility;

public class PaymentPage {
	
	 private WebDriver driver;
	    private ActionHelper action;
	    private Logger log = LoggerUtility.getLogger(PaymentPage.class);

	    public PaymentPage(WebDriver driver) {
	        this.driver = driver;
	        this.action = new ActionHelper(driver);
	        log.info("CheckoutPage initialized");
	    }
	    
	    //Locators
	    private final By nameOnCardField = By.xpath("//input[@name='name_on_card']");
	    private final By cardNumberField = By.xpath("//input[@name='card_number']");
	    private final By cvcField = By.xpath("//input[@placeholder='ex. 311']");
	    private final By expirateionField = By.xpath("//input[@placeholder='MM']");
	    private final By yearField = By.xpath("//input[@placeholder='YYYY']");
	    private final By conformationButton = By.xpath("//button[@id='submit']");
	    private final By conformatonMessage = By.xpath("//b[normalize-space()='Order Placed!']");
	    
	    public void enterCardDetails(String sheetName) {
	    	String[][] data = ExcelReader.readExcelData(sheetName);
	    	action.type(nameOnCardField, data[0][0]);
	    	action.type(cardNumberField, data[0][1]);
	    	action.type(cvcField, data[0][2]);
	    	action.type(expirateionField, data[0][3]);
	    	action.type(yearField, data[0][4]);
	    	log.info("Entering card details");
	    }
	    
	    public void placeOrder() {
	    	action.click(conformationButton);
	    	log.info("Clicked on place order button");
	    }
	    
	    public boolean isOrderConfirmationDisplayed() {
	    	log.info("Checking order conformation message is displayed");
	    	return action.isElementVisible(conformatonMessage);
		}
	    

}
