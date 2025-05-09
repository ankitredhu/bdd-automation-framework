package stepdefinitions;

import static org.junit.Assert.assertTrue;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ProductBrowsingPage;

public class CartOperationsSteps extends BaseTest {

    private ProductBrowsingPage productPage = new ProductBrowsingPage(getDriver());

    @When("I navigate to the cart")
    public void i_navigate_to_the_cart() {
        productPage.goToCart();
    }

    @Then("I should see the product listed in the cart")
    public void i_should_see_the_product_listed_in_the_cart() {
        String productName = productPage.getCartProductName();
        System.out.println("Product in cart: " + productName);
        assertTrue("Product name is empty", productName != null && !productName.isEmpty());
    }

    @When("I remove the product from the cart")
    public void i_remove_the_product_from_the_cart() {
        productPage.removeProductFromCart();
    }

    @Then("the cart should be empty")
    public void the_cart_should_be_empty() {
        assertTrue("Cart is not empty", productPage.isCartEmpty());
    }
}
