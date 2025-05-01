package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.ActionHelper;

public class ProductPage extends ActionHelper {
	
	private WebDriver driver;
	
	@FindBy(xpath = "//a[@href='/products']")
	private WebElement productsLink;

    @FindBy(css = "input#search_product")
    private WebElement searchInput;

    @FindBy(css = "#submit_search")
    private WebElement searchButton;

    @FindBy(xpath = "(//a[contains(text(),'View Product')])[1]")
    private WebElement firstProductAddToCartButton;
    
    @FindBy(xpath = "//button[normalize-space()='Add to cart']")
    private WebElement nextPageAddToCartButton;
    
    @FindBy(css = "div[id='cartModal'] p:nth-child(1)")
    private WebElement procuctAddedToCartMessage;

    @FindBy(css = ".modal-content .btn-success")
    private WebElement continueShoppingButton;

    @FindBy(css = "a[href='/view_cart']")
    private WebElement cartLink;

    @FindBy(css = ".cart_description h4 a")
    private WebElement cartProductName;

    public ProductPage(WebDriver driver) {
    	super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    
    public void clickProductsLink() {
    	click(productsLink);
    }

    public void searchProduct(String keyword) {
        type(searchInput, keyword);
        click(searchButton);
    }

    public void addFirstProductToCart() {
        click(firstProductAddToCartButton);
        click(nextPageAddToCartButton);
        
    }
    
    public String productAddedMessage() {
    	isElementVisible(procuctAddedToCartMessage);
    	return procuctAddedToCartMessage.getText();
    }
    
    public void clickContinueButton() {
    	click(continueShoppingButton);
    }
    
    

    public void goToCart() {
        click(cartLink);
    }

    public String getCartProductName() {
        return getText(cartProductName);
    }
}