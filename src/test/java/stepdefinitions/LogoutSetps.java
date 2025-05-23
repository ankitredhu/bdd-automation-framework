package stepdefinitions;

import org.junit.Assert;

import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HeaderPage;
import pages.LoginPage;

public class LogoutSetps extends BaseTest {

	private LoginPage loginPage;
	private HeaderPage headerPage;

	@Before
	public void setUpPages() {
		loginPage = new LoginPage(getDriver()); // initialize LoginPage object
		headerPage = new HeaderPage(getDriver());
	}

	@When("I click on the logout button")
	public void i_click_on_the_logout_button() {
		headerPage.clickLogoutButton();

	}

	@Then("I should be navigated to the login page")
	public void i_should_be_navigated_to_the_login_page() {
		Assert.assertTrue(loginPage.isUserLoggedOut());
	}

}
