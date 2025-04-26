Feature: User Login

  Scenario: Login with valid credentials
    Given I am on the home page
    When I click on SignupLogin link
    And I enter valid email "ankitredhu12@gmail.com" and password "Igrah@123"
    And I click on login button
    Then I should see the Logged in user on the homepage
