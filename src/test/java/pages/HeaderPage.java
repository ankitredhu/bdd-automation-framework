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

}
