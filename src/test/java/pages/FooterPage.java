package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ActionHelper;
import utils.LoggerUtility;
import org.apache.logging.log4j.Logger;

public class FooterPage {
	
	private WebDriver driver;
    private ActionHelper action;
    private Logger log = LoggerUtility.getLogger(FooterPage.class);

    public FooterPage(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionHelper(driver);
        log.info("HomePage initialized");
    }
    
    // Locators for subscription
    private final By subscriptionSection = By.xpath("//h2[normalize-space()='Subscription']");
    private final By emailInput = By.id("susbscribe_email");
    private final By submitButton = By.id("subscribe");
    private final By successMessage = By.xpath("//div[@class='alert-success alert' and contains(text(),'successfully subscribed')]");

    // Actions
    
    public void scrollToSubcripton() {
    	log.info("Scrolling to subscription section");
    	action.scrollToElement(subscriptionSection);
    }
    
    public boolean isSubscriptionSectionVisible() {
        log.info("Checking if subscription section is visible");
        return action.isElementVisible(subscriptionSection);
    }

    public void subscribeWithEmail(String email) {
        log.info("Subscribing with email: " + email);
        action.type(emailInput, email);
        
    }
    
    public void clickArrowButton() {
    	log.info("Clicking submit button...");
    	action.click(submitButton);
    }

    public boolean isSubscriptionSuccessMessageVisible() {
        log.info("Checking subscription success message");
        return action.isElementVisible(successMessage);
    }

}
