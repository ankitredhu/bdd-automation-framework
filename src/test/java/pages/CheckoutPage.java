package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.apache.logging.log4j.Logger;
import utils.ActionHelper;
import utils.LoggerUtility;

public class CheckoutPage {

    private WebDriver driver;
    private ActionHelper action;
    private Logger log = LoggerUtility.getLogger(CheckoutPage.class);

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionHelper(driver);
        log.info("CheckoutPage initialized");
    }

    // Locators
    private final By proceedToCheckoutButton = By.xpath("//a[contains(text(),'Proceed To Checkout')]");
    private final By deliveryAddressBox = By.xpath("//ul[@id='address_delivery']");
    private final By reviewOrderMessage = By.xpath("//h2[contains(text(),'Review Your Order')]");
    private final By commentInput = By.name("message");
    private final By placeOrderButton = By.xpath("//a[contains(text(),'Place Order')]");

    public void clickProceedToCheckout() {
        log.info("Clicking 'Proceed To Checkout' button");
        action.click(proceedToCheckoutButton);
    }

    public boolean isDeliveryAddressDisplayed() {
        log.info("Checking if delivery address is displayed");
        return action.isElementVisible(deliveryAddressBox);
    }

    public boolean isReviewOrderSectionVisible() {
        log.info("Checking if 'Review Your Order' section is visible");
        return action.isElementVisible(reviewOrderMessage);
    }

    public void enterComment(String comment) {
        log.info("Entering order comment: " + comment);
        action.type(commentInput, comment);
    }

    public void clickPlaceOrder() {
        log.info("Clicking 'Place Order' button");
        action.click(placeOrderButton);
    }

}
