@Smoke
Feature: Contact Us Page Functionality
As a logged-in user
I want to submit a contact form
So that I can reach out to the support team

Scenario Outline: Submit Contact Us form with valid details
Given User is logged in with email and password from excel <RowIndex>
When I click on Contact Us link
And I fill in the contact form with valid details
And I upload a file
And I click the Submit button
Then I should see a success message

	Examples:
      |RowIndex |
      |0        |