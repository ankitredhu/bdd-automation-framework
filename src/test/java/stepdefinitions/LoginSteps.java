package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.LoginPage;

public class LoginSteps extends BaseTest {

    LoginPage loginPage;

    @Given("I am on the home page")
    public void i_am_on_the_home_page() {
        // Home page is already loaded by initializeBrowser() from Hooks
        loginPage = new LoginPage(getDriver()); // initialize LoginPage object
    }

    @When("I click on SignupLogin link")
    public void i_click_on_signup_login_link() {
        loginPage.clickSignupLoginLink();
    }

    @When("I enter valid email {string} and password {string}")
    public void i_enter_valid_email_and_password(String email, String password) {
        loginPage.enterLoginEmail(email);
        loginPage.enterLoginPassword(password);
    }

    @When("I click on login button")
    public void i_click_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("I should see the Logged in user on the homepage")
    public void i_should_see_the_logged_in_user_on_the_homepage() {
        Assert.assertTrue(loginPage.isUserLoggedIn());
    }
}
