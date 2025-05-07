@Smoke1
Feature: User Login
  As a user, I want to log in and out of the application so that I can access my account securely.
	
  Scenario Outline: Login with valid credentials
    Given I am on the home page
    When I click on SignupLogin link
    And I enter valid email and password from excel <RowIndex>
    And I click on login button
    Then I should see the Logged in user on the homepage
    
     Examples:
      |RowIndex |
      |0        |
 
 Scenario Outline: Logout after successful login
    Given I am on the home page
    When I click on SignupLogin link
    And I enter valid email and password from excel <RowIndex>
    And I click on login button
    Then I should see the Logged in user on the homepage
    When I click on the logout button
    Then I should be navigated to the login page

    Examples:
      | RowIndex |
      | 0        |