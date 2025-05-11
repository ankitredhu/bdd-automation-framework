@Smoke
Feature: As a user I want to browse the homepage
	
	@NoClose
  Scenario: Verify Subscription functionality in home page without login
    Given I am on the home page
    When I scroll to the subscription section
    Then I should see the subscription section
    When I enter email "testuser@example.com" for subscription
    And I click on the subscription arrow button
    Then I should see the success message for subscription

  @LoggedIn 
  Scenario: Verify Subscription functionality in home page with login
    Given I am on the home page
    When I scroll to the subscription section
    Then I should see the subscription section
    When I enter email "testuser@example.com" for subscription
    And I click on the subscription arrow button
    Then I should see the success message for subscription
