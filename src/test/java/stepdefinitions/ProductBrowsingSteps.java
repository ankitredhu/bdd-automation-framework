package stepdefinitions;

import org.junit.Assert;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductBrowsingPage;

public class ProductBrowsingSteps extends BaseTest{
	
	 private ProductBrowsingPage productBrowsingPage;
	
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


}
