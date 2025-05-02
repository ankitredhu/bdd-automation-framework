@Smoke 
Feature: Cart Operations
  As a user
  I want to manage my shopping cart
  So that I can view, add, or remove items
  
  Background:
    Given I am on the home page
    When I click on Products link
    And I search for a product with keyword "Tshirt"
    And I add the first product to the cart
    
  @LoggedIn
  Scenario: View product in cart
    When I navigate to the cart
    Then I should see the product listed in the cart
    
	@LoggedIn
  Scenario: Remove product from cart
    When I navigate to the cart
    And I remove the product from the cart
    Then the cart should be empty
