package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;

import pages.HeaderPage;
import pages.LoginPage;
import utils.ExcelReader;

public class LoginSteps extends BaseTest {

	private LoginPage loginPage;
	private HeaderPage headerpage;

	@Before
	public void setUpPages() {
		loginPage = new LoginPage(getDriver()); // initialize LoginPage object
		headerpage = new HeaderPage(getDriver());
	}

	@Given("I am on the home page")
	public void i_am_on_the_home_page() {
		// Home page is already loaded by initializeBrowser() from Hooks
	}

	@When("I click on SignupLogin link")
	public void i_click_on_signup_login_link() {
		headerpage.clickSignupLoginLink();
	}

	@When("I enter valid email and password from excel {int}")
	public void i_enter_valid_email_and_password_from_excel(Integer rowIndex) {
		String[][] data = ExcelReader.readExcelData("Sheet1");
		loginPage.enterLoginEmail(data[rowIndex][0]);
		loginPage.enterLoginPassword(data[rowIndex][1]);
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
