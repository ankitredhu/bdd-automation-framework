package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.ActionHelper;
import utils.LoggerUtility;

import org.apache.logging.log4j.Logger;

public class LoginPage {

    private WebDriver driver;
    private ActionHelper action;
    private final Logger log = LoggerUtility.getLogger(LoginPage.class);

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.action = new ActionHelper(driver);
        log.info("LoginPage initialized");
    }

    // Locators
    private final By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    private final By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    private final By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    private final By loginButton = By.xpath("//button[@data-qa='login-button']");
    private final By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");

    // Actions
    public void clickSignupLoginLink() {
        log.info("Clicking Signup/Login link");
        action.click(signupLoginLink);
    }

    public void enterLoginEmail(String email) {
        log.info("Entering login email: {}", email);
        action.type(loginEmailInput, email);
    }

    public void enterLoginPassword(String password) {
        log.info("Entering login password");
        action.type(loginPasswordInput, password);
    }

    public void clickLoginButton() {
        log.info("Clicking login button");
        action.click(loginButton);
    }

    public boolean isUserLoggedIn() {
        log.info("Checking if user is logged in...");
        return action.isElementVisible(loggedInUser);
    }
}
