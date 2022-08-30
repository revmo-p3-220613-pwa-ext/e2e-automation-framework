Feature: View Account Feature

  Scenario: Click View Account
    Given I am at the user page
    And I have an active account
    And I click on the view account button
    Then I should be redirected to the page for that account.