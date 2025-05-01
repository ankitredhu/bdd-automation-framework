@Smoke
Feature: Product Search and Add to Cart Functionality As a logged-in user I want to search for a product and add it to the cart So that I can purchase it later

@LoggedIn 
Scenario Outline: Search for a product and add it to the cart 
 Given User is logged in with email and password from excel <RowIndex> 
 When I click on Products link
 And I search for a product with keyword "dress" 
 And I add the first product to the cart 
 Then I should see the product in the cart
 
 Examples:
      |RowIndex |
      |0        |
 