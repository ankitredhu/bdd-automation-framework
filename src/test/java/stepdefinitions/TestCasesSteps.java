package stepdefinitions;

import org.junit.Assert;

import base.BaseTest;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HeaderPage;

public class TestCasesSteps extends BaseTest{
	
	private HeaderPage headerPage;
	
	@When("I click on the Test Cases link")
	public void i_click_on_the_test_cases_link() {
	    headerPage = new HeaderPage(getDriver());
	    headerPage.clickTestCasesLink();
	}
	@Then("I should be navigated to the Test Cases page")
	public void i_should_be_navigated_to_the_test_cases_page() {
	   Assert.assertTrue(headerPage.isTestCasesPageOpened());
	}

}
