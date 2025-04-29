package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.LoggerUtility;

import org.apache.logging.log4j.Logger;

public class LoginPage {

    WebDriver driver;
    Logger log = LoggerUtility.getLogger(LoginPage.class);

    // Constructor to initialize the driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        log.info("LoginPage initialized");
    }

    // Locators
    By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");
    By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");

    // Actions

    public void clickSignupLoginLink() {
    	 log.info("Clicking Signup/Login link");
        driver.findElement(signupLoginLink).click();
    }

    public void enterLoginEmail(String email) {
    	log.info("Entering login email: " + email);
        driver.findElement(loginEmailInput).sendKeys(email);
    }

    public void enterLoginPassword(String password) {
    	log.info("Entering login password");
        driver.findElement(loginPasswordInput).sendKeys(password);
    }

    public void clickLoginButton() {
    	log.info("Clicking login button");
        driver.findElement(loginButton).click();
    }

    public boolean isUserLoggedIn() {
    	log.info("Is user logged in? ");
        return driver.findElement(loggedInUser).isDisplayed();
    }
}
