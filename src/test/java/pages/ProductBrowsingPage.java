package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import utils.ActionHelper;
import utils.LoggerUtility;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Logger;

public class ProductBrowsingPage {

    private WebDriver driver;
    private ActionHelper action;
    private Logger log = LoggerUtility.getLogger(ProductBrowsingPage.class);

    public ProductBrowsingPage(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionHelper(driver);
        log.info("ProductPage initialized");
    }

    // Locators
    private final By searchInput = By.cssSelector("input#search_product");
    private final By searchButton = By.cssSelector("#submit_search");
    private final By firstProductViewButton = By.xpath("(//a[contains(text(),'View Product')])[1]");
    private final By nextPageAddToCartButton = By.xpath("//button[normalize-space()='Add to cart']");
    private final By productAddedToCartMessage = By.cssSelector("div[id='cartModal'] p:nth-child(1)");
    private final By continueShoppingButton = By.cssSelector(".modal-content .btn-success");
    private final By cartLink = By.cssSelector("a[href='/view_cart']");
    private final By cartProductName = By.cssSelector(".cart_description h4 a");
    private final By deleteProductButton = By.cssSelector(".cart_quantity_delete");
    private final By allProductsHeading = By.xpath("//h2[text()='All Products']");
    private final By productsList = By.cssSelector(".features_items");
    private final By productDetailsPage = By.xpath("//div[@class='product-details']");
    
    // Product detail elements
    private final By productName = By.xpath("//div[@class='product-information']/h2");
    private final By productCategory = By.xpath("//div[@class='product-information']//p[contains(text(),'Category')]");
    private final By productPrice = By.xpath("//span[contains(text(),'Rs.')]");
    private final By productAvailability = By.xpath("//b[normalize-space()='Availability:']/parent::p");
    private final By productCondition = By.xpath("//b[normalize-space()='Condition:']/parent::p");
    private final By productBrand = By.xpath("//b[normalize-space()='Brand:']/parent::p");

    // Actions

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
    
    public boolean isOnAllProductsPage() {
        log.info("Verifying All Products page");
        return action.isElementVisible(allProductsHeading);
    }
    
    
    
    public void clickFirstProductView() {
        log.info("Clicking 'View Product' on first product");
        action.click(firstProductViewButton);
    }
    
    public boolean areProductDetailsVisible() {
        log.info("Verifying product details on detail page");
        return action.isElementVisible(productName)
                && action.isElementVisible(productCategory)
                && action.isElementVisible(productPrice)
                && action.isElementVisible(productAvailability)
                && action.isElementVisible(productCondition)
                && action.isElementVisible(productBrand);
    }
    
    public boolean isProductListVisible() {
        log.info("Checking if product list is visible");
        return action.isElementVisible(productsList);
    }
    
    public boolean isProductDetailsPageVisible() {
    	log.info("Checking id product details page visible");
    	return action.isElementVisible(productDetailsPage);
    }
    
    
}
