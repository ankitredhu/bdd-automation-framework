@Smoke
Feature: Checkout Process
  As a user
  I want to proceed to checkout
  So that I can review my address and order summary before placing the order
  
  Background:
  	
  	 When I click on Products link
     And I search for a product with keyword "dress" 
     And I add the first product to the cart 
  @LoggedIn
  Scenario: Proceed to checkout and place order
    When I click on the Cart link
    And I click on Proceed to Checkout
    Then I should see the Address Details and Order Review section
    When I enter comment "Please deliver between 9 AM - 5 PM"
    And I click on Place Order
    And I enter the card details from sheet "cardDetails"
    Then I should see the order confirmation message
	
	
  Scenario: Register during checkout and place order successfully
    Given I am on the home page
    When I click on the Cart link
    And I click on Proceed to Checkout
    And I choose to register during checkout
    And I register a new user with with random data "user" with timestamp
    Then I should see that the user is successfully registered and logged in
    And  I click on the Cart link
    And I click on Proceed to Checkout
    Then I should see the Address Details and Order Review section
    When I enter comment "Please deliver between 9 AM - 5 PM"
    And I click on Place Order
    And I enter the card details from sheet "cardDetails"
    Then I should see the order confirmation message
    
