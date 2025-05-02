
Feature: User Registration
	
  Scenario Outline: Register a new user with data from Excel
    Given I am on the homepage
    When I click on the SignupLogin link
    And I register a new user with data from sheet "RegisterData" and <RowIndex>
    Then I should see that the user is successfully registered and logged in
		
		Examples:
      |RowIndex |
      |1        |
      |2				|