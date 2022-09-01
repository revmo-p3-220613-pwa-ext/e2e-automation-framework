Feature: PendingTransaction
  Scenario Outline:Set up 2 transactions for Approve/Deny Request
    Given that I login as a different user
    When I scroll down to see request money
    And I type in a valid email of "<email>" into request email
    And I select the first account in request money
    And I type in a valid amount of "<amount>" into request money
    Then I click on request money submit button
  Examples:
  |email|amount|
  |jd80@a.ca|00.01|
  |jd80@a.ca|00.01|

  Scenario: Deny First Request
    Given that I am on the pending transactions page
    And I click on the deny transaction button
    Then the amount in my account should remain the same


  Scenario: Accept First Request
    Given that I am on the pending transactions page
    And I click on the approve transaction button
    Then the amount in my account should not remain the same