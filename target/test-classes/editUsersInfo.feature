Feature: Edit User's Info

  Scenario: Click Edit User Info
    Given I am at the edit user info page
    When I input a new phone number of "696-969-6969"
    And I click the submit button
    Then I am redirected to my user page with new information