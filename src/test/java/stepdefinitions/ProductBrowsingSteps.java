package stepdefinitions;

import org.junit.Assert;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FooterPage;
import pages.HeaderPage;
import pages.ProductBrowsingPage;

public class ProductBrowsingSteps extends BaseTest{
	
	 private ProductBrowsingPage productBrowsingPage;
	 private HeaderPage headerPage;
	 private FooterPage footerPage;
	
	@Then("I should be navigated to the All Products page")
	public void i_should_be_navigated_to_the_all_products_page() {
		productBrowsingPage = new ProductBrowsingPage(getDriver());
		productBrowsingPage.isOnAllProductsPage();
	    
	}
	@Then("I should see the list of products")
	public void i_should_see_the_list_of_products() {
		Assert.assertTrue(productBrowsingPage.isProductListVisible());
	}
	@When("I click on View Product of the first product")
	public void i_click_on_view_product_of_the_first_product() {
		productBrowsingPage.clickFirstProductView();
	}
	@Then("I should be navigated to the product detail page")
	public void i_should_be_navigated_to_the_product_detail_page() {
		Assert.assertTrue(productBrowsingPage.isProductDetailsPageVisible());
	    
	}
	@Then("I should see product name, category, price, availability, condition, and brand")
	public void i_should_see_product_name_category_price_availability_condition_and_brand() {
		Assert.assertTrue(productBrowsingPage.areProductDetailsVisible());
	}
	
	// Subscription scenario 
	
	@Given("I am on the products page")
	public void i_am_on_the_products_page() {
		headerPage = new HeaderPage(getDriver());
		headerPage.clickProductsLink();
	}
	@When("I scroll to the subscription section")
	public void i_scroll_to_the_subscription_section() {
		footerPage = new FooterPage(getDriver());
		footerPage.scrollToSubcripton();
	}
	@Then("I should see the subscription section")
	public void i_should_see_the_subscription_section() {
	    Assert.assertTrue(footerPage.isSubscriptionSectionVisible());
	}
	@When("I enter email {string} for subscription")
	public void i_enter_email_for_subscription(String email) {
	    footerPage.subscribeWithEmail(email);
	}
	@When("I click on the subscription arrow button")
	public void i_click_on_the_subscription_arrow_button() {
	    footerPage.clickArrowButton();
	}
	@Then("I should see the success message for subscription")
	public void i_should_see_the_success_message_for_subscription() {
	    Assert.assertTrue(footerPage.isSubscriptionSuccessMessageVisible());
	}


}
