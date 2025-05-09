@Smoke
Feature: Product Search and Add to Cart Functionality As a logged-in user I want to search for a product and add it to the cart So that I can purchase it later

@LoggedIn @NoClose
Scenario Outline: Search for a product and add it to the cart 
 Given User is logged in with email and password from excel <RowIndex> 
 When I click on Products link
 And I search for a product with keyword "dress" 
 And I add the first product to the cart 
 Then I should see the product in the cart
 
 Examples:
      |RowIndex |
      |0        |
      
  
  Scenario: Verify all products and product detail page
    Given I am on the home page
    When I click on Products link
    Then I should be navigated to the All Products page
    And I should see the list of products
    When I click on View Product of the first product
    Then I should be navigated to the product detail page
    And I should see product name, category, price, availability, condition, and brand
 
 