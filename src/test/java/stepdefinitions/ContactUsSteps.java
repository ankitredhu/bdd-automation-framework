package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import base.BaseTest;
import pages.ContactUsPage;
import pages.HeaderPage;

public class ContactUsSteps extends BaseTest {
    private WebDriver driver;
    private ContactUsPage contactUsPage;
    private HeaderPage headerPage;
    
    @Before
    public void setUpPages() {
    	contactUsPage = new ContactUsPage(getDriver());
    	headerPage = new HeaderPage(getDriver());
    }

    @When("I click on Contact Us link")
    public void i_click_on_contact_us_link() {
        // Write code here that turns the phrase above into concrete actions
    	headerPage.clickContactUs();
    }

    @And("I fill in the contact form with valid details")
    public void i_fill_in_the_contact_form_with_valid_details() {
        contactUsPage.fillContactForm(
            "John Doe",
            "john.doe@example.com",
            "Support Request",
            "This is a test message for the contact us form."
        );
    }

    @And("I upload a file")
    public void i_upload_a_file() {
        // Provide an absolute path to a test file on your system
        String filePath = System.getProperty("user.dir") + "/src/test/resources/testfile.txt";
        contactUsPage.uploadFile(filePath);
    }

    @And("I click the Submit button")
    public void i_click_the_submit_button() {
        contactUsPage.clickSubmitButton();
    }

    @Then("I should see a success message")
    public void i_should_see_a_success_message() {
        String expectedMessage = "Success! Your details have been submitted successfully.";
        String actualMessage = contactUsPage.getSuccessMessage();
        Assert.assertEquals("Success message not displayed as expected", expectedMessage, actualMessage);
    }
}