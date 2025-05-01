package stepdefinitions;

import base.BaseTest;
import io.cucumber.java.en.*;
import pages.LoginPage;
import utils.ExcelReader;

public class CommonSteps extends BaseTest {

	LoginPage loginPage;

	@Given("User is logged in with email and password from excel {int}")
	public void user_is_logged_in_with_email_and_password_from_excel(Integer rowIndex) {
		
		//Handing the login logic in Hooks, this is only for better readability in feature file

	}

}
