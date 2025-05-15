package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import pages.HeaderPage;


public class CommonSteps extends BaseTest {

	private HeaderPage headerPage;

	@Before
	public void setUpPage() {
		headerPage = new HeaderPage(getDriver());
	}

	@Given("User is logged in with email and password from excel {int}")
	public void user_is_logged_in_with_email_and_password_from_excel(Integer rowIndex) {

		// Handing the login logic in Hooks, this is only for better readability in
		// feature file

	}

	@Given("I am on the homepage")
	public void i_am_on_the_homepage() {
		headerPage.goToHome();
	}

}
