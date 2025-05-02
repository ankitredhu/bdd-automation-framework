package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ActionHelper;
import utils.LoggerUtility;
import org.apache.logging.log4j.Logger;

public class ProductPage {

    private WebDriver driver;
    private ActionHelper action;
    private Logger log = LoggerUtility.getLogger(ProductPage.class);

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionHelper(driver);
        log.info("ProductPage initialized");
    }

    // Locators
    private final By productsLink = By.xpath("//a[@href='/products']");
    private final By searchInput = By.cssSelector("input#search_product");
    private final By searchButton = By.cssSelector("#submit_search");
    private final By firstProductViewButton = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private final By nextPageAddToCartButton = By.xpath("//button[normalize-space()='Add to cart']");
    private final By productAddedToCartMessage = By.cssSelector("div[id='cartModal'] p:nth-child(1)");
    private final By continueShoppingButton = By.cssSelector(".modal-content .btn-success");
    private final By cartLink = By.cssSelector("a[href='/view_cart']");
    private final By cartProductName = By.cssSelector(".cart_description h4 a");
    private final By deleteProductButton = By.cssSelector(".cart_quantity_delete");

    // Actions
    public void clickProductsLink() {
        log.info("Clicking on 'Products' link");
        action.click(productsLink);
    }

    public void searchProduct(String keyword) {
        log.info("Searching product: " + keyword);
        action.type(searchInput, keyword);
        action.click(searchButton);
    }

    public void addFirstProductToCart() {
        log.info("Adding first product to cart");
        action.click(firstProductViewButton);
        action.click(nextPageAddToCartButton);
    }

    public String getProductAddedMessage() {
        log.info("Getting product added message");
        action.waitForElementToBeVisible(productAddedToCartMessage);
        return action.getText(productAddedToCartMessage);
    }

    public void clickContinueShoppingButton() {
        log.info("Clicking 'Continue Shopping' button");
        action.click(continueShoppingButton);
    }

    public void goToCart() {
        log.info("Navigating to cart");
        action.click(cartLink);
    }

    public String getCartProductName() {
        log.info("Getting product name from cart");
        return action.getText(cartProductName);
    }
    
    public void removeProductFromCart() {
        log.info("Removing product from cart");
        action.click(deleteProductButton);
    }

    public boolean isCartEmpty() {
        log.info("Checking if cart is empty");
        By emptyMessage = By.xpath("//*[contains(text(),'Cart is empty') or contains(text(),'Your cart is empty')]");
        return action.isElementVisible(emptyMessage);
    }
}
