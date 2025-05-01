@Smoke
Feature: User Login
	
	@LoggedIn
  Scenario Outline: Login with valid credentials
    Given I am on the home page
    When I click on SignupLogin link
    And I enter valid email and password from excel <RowIndex>
    And I click on login button
    Then I should see the Logged in user on the homepage
    
     Examples:
      |RowIndex |
      |0        |
 