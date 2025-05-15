package stepdefinitions;

import static org.junit.Assert.assertTrue;

import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CheckoutPage;
import pages.HeaderPage;
import pages.PaymentPage;

public class CheckoutSteps extends BaseTest {

    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;
    private HeaderPage headerPage;
    
    @Before
    public void setUpPages() {
    	checkoutPage = new CheckoutPage(getDriver());
    	paymentPage = new PaymentPage(getDriver());
        headerPage = new HeaderPage(getDriver());
    }

    @When("I click on the Cart link")
    public void i_click_on_the_cart_link() {
        headerPage.clickCartLink();
    }

    @When("I click on Proceed to Checkout")
    public void i_click_on_proceed_to_checkout() {
        checkoutPage.clickProceedToCheckout();
    }

    @Then("I should see the Address Details and Order Review section")
    public void i_should_see_address_and_order_review() {
        assertTrue("Address Details not displayed", checkoutPage.isDeliveryAddressDisplayed());
        assertTrue("Order Review not displayed", checkoutPage.isReviewOrderSectionVisible());
    }

    @When("I enter comment {string}")
    public void i_enter_comment(String comment) {
        checkoutPage.enterComment(comment);
    }

    @When("I click on Place Order")
    public void i_click_on_place_order() {
        checkoutPage.clickPlaceOrder();
    }
    
    @When("I enter the card details from sheet {string}")
    public void i_enter_the_card_details_from_sheet(String sheetName) {
    	paymentPage.enterCardDetails(sheetName);
    	paymentPage.placeOrder();
    	paymentPage.isOrderConfirmationDisplayed();
    }

    @Then("I should see the order confirmation message")
    public void i_should_see_order_confirmation_message() {
        assertTrue("Order confirmation message not visible", paymentPage.isOrderConfirmationDisplayed());
    }
} 
