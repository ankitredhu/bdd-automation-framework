package stepdefinitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HeaderPage;
import pages.LoginPage;
import pages.RegisterPage;
import utils.ExcelReader;

public class RegisterSteps extends BaseTest {

    private RegisterPage registerPage;
    private HeaderPage headerPage;

    @When("I click on the SignupLogin link")
    public void i_click_on_the_signup_login_link() {
    	headerPage = new HeaderPage(getDriver());
        headerPage.clickSignupLoginLink();
    }

    @When("I register a new user with data from sheet {string} and {int}")
    public void i_register_a_new_user_with_data_from_sheet_and(String sheetName, Integer rowIndex) {
        registerPage = new RegisterPage(getDriver());

        String[][] data = ExcelReader.readExcelData(sheetName);

       
            String name = data[rowIndex][0];
            String email = data[rowIndex][1];
            String password = data[rowIndex][2];

            registerPage.enterNameAndEmail(name, email);
            
            //This will skip the rest of the steps if user is already created for the row in excel file
            assumeTrue("User already exists, skipping scenario.", !registerPage.isUserAlreadyExistsErrorVisible());
            
            registerPage.fillAccountDetails(password,"24","May","2000");
            registerPage.fillAddressDetails("Aanu", "Amor", "Sample1", "Sample2", "Sample3","126102", "9824516780");
            registerPage.clickCreateAccount();
    }

    @Then("I should see that the user is successfully registered and logged in")
    public void i_should_see_that_the_user_is_successfully_registered_and_logged_in() {
        assertTrue(registerPage.isAccountCreated());
    }
}
