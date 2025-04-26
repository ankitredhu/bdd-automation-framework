package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    WebDriver driver;

    // Constructor to initialize the driver
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By signupLoginLink = By.xpath("//a[contains(text(),'Signup / Login')]");
    By loginEmailInput = By.xpath("//input[@data-qa='login-email']");
    By loginPasswordInput = By.xpath("//input[@data-qa='login-password']");
    By loginButton = By.xpath("//button[@data-qa='login-button']");
    By loggedInUser = By.xpath("//a[contains(text(),'Logged in as')]");

    // Actions

    public void clickSignupLoginLink() {
        driver.findElement(signupLoginLink).click();
    }

    public void enterLoginEmail(String email) {
        driver.findElement(loginEmailInput).sendKeys(email);
    }

    public void enterLoginPassword(String password) {
        driver.findElement(loginPasswordInput).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public boolean isUserLoggedIn() {
        return driver.findElement(loggedInUser).isDisplayed();
    }
}
