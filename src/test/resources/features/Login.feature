@Smoke
Feature: User Login
	
	@Regression
  Scenario Outline: Login with valid credentials
    Given I am on the home page
    When I click on SignupLogin link
    And I enter valid email "<email>" and password "<password>"
    And I click on login button
    Then I should see the Logged in user on the homepage
    
     Examples:
      | email                    | password  |
      | ankitredhu16@gmail.com   | Igrah123  |
      | ankitredhu12@gmail.com   | Igrah@123 |
      | rohitredhu               | rohit     |
 