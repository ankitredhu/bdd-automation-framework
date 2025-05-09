package stepdefinitions;

import static org.junit.Assert.assertEquals;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HeaderPage;
import pages.ProductBrowsingPage;

public class ProductSearchSteps extends BaseTest {

    private ProductBrowsingPage productPage;
    private HeaderPage headerPage;

    @When("I click on Products link")
    public void i_click_on_products_link() {
        productPage = new ProductBrowsingPage(getDriver());
        headerPage = new HeaderPage(getDriver());
        headerPage.clickProductsLink();
    }

    @When("I search for a product with keyword {string}")
    public void i_search_for_a_product_with_keyword(String keyword) {
        productPage.searchProduct(keyword);
    }

    @When("I add the first product to the cart")
    public void i_add_the_first_product_to_the_cart() {
        productPage.addFirstProductToCart();
        assertEquals("Your product has been added to cart.", productPage.getProductAddedMessage());
        productPage.clickContinueShoppingButton();
    }

    @Then("I should see the product in the cart")
    public void i_should_see_the_product_in_the_cart() {
        productPage.goToCart();
        String productName = productPage.getCartProductName();
        System.out.println("Product Name: " + productName);
        // Optional: Add assertion like assertTrue(productName.contains("expected name"));
    }
}
