@Smoke1
Feature: Navigation to Test Cases Page
	
  Scenario: Verify user can navigate to the Test Cases page
    Given I am on the home page
    When I click on the Test Cases link
    Then I should be navigated to the Test Cases page
  
  @LoggedIn
  Scenario: Verify user can navigate to the Test Cases page when logged in
  	
  	Given I am on the home page
    When I click on the Test Cases link
    Then I should be navigated to the Test Cases page
  
