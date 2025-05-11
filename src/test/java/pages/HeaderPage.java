package pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.ActionHelper;
import utils.LoggerUtility;

public class HeaderPage {
	
	private WebDriver driver;
    private ActionHelper action;
    private final Logger log = LoggerUtility.getLogger(HeaderPage.class);
    
    //Locators 
     private final By testCasesLink = By.xpath("//a[normalize-space()='Test Cases']");
     private final By testCasesLabel = By.xpath("//b[normalize-space()='Test Cases']");
     private final By cartLinkButton = By.xpath("//a[normalize-space()='Cart']//i[@class='fa fa-shopping-cart']");
     private final By contactUsLink = By.xpath("//a[normalize-space()='Contact us']");
     private final By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
     private final By productsLink = By.xpath("//a[@href='/products']");
     private final By logoutButton = By.xpath("//a[normalize-space()='Logout']");
     private final By apiTestingButton = By.xpath("//a[normalize-space()='API Testing']");
     private final By videoTutorials = By.xpath("//a[normalize-space()='Video Tutorials']");
     private final By homeLink = By.xpath("//a[normalize-space()='Home']");
     
     public HeaderPage(WebDriver driver) {
    	 this.driver = driver;
         this.action = new ActionHelper(driver);
         log.info("LoginPage initialized");
	}

	//methods
     public void clickTestCasesLink() {
    	 log.info("Clicking on the Test Cases link...");
    	 action.click(testCasesLink);
     }
     
     public boolean isTestCasesPageOpened() {
    	 log.info("Checking if test cases page opened sucessfully...");
    	 return action.isElementVisible(testCasesLabel);
     }
     
     public void clickCartLink() {
    	 log.info("Clicking on the Cart link...");
     	action.click(cartLinkButton);
     }
     
     public void clickContactUs() {
    	 log.info("Clicking on the Contact Us link...");
     	action.click(contactUsLink);
     }
     
     public void clickSignupLoginLink() {
         log.info("Clicking Signup/Login link");
         action.click(signupLoginLink);
     }
     
     public void clickProductsLink() {
         log.info("Clicking on 'Products' link");
         action.click(productsLink);
     }
     
     public void clickLogoutButton() {
     	log.info("Clicking on log out button");
     	action.click(logoutButton);
     }
     
     public void clickApiTesting() {
    	 log.info("Clicking on API Testing link");
      	action.click(apiTestingButton);
     }
     
     public void clickVideoTutorials() {
    	 log.info("Clicking on Video Tutorials link");
    	 action.scrollToElement(apiTestingButton);
      	action.click(videoTutorials);
     }

	public void goToHome() {
		 log.info("Clicking on Home link");
	      	action.click(homeLink);
		
	}

}
