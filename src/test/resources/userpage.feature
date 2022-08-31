Feature: UserPage

  Scenario: Valid user login
    Given that I login as a user
    Then I should be redirected to the user-page.html
#
#  Scenario: I view current month income on the user page
#    Given that I login as a user
#    Then I should see the current month income on the user page
#
#  Scenario: I view all time income on the user page
#    Given that I login as a user
#    Then I should see the all time income on the user page

  Scenario: I click on the first account on the user page
    Given that I login as a user
    When I click on the first account displayed
    Then I should be redirected to the account.html

  Scenario: I click on the edit user info button on the user-page
    Given that I login as a user
    When I click on the edit user info button
    Then I should be redirected to the edit-user-info.html

  Scenario: I click on the all income button on the user-page
    Given that I login as a user
    When I click on the all income button
    Then I should be redirected to the income.html

  Scenario: I click on the pending transaction button on the user-page
    Given that I login as a user
    When I click on the pending transactions button
    Then I should be redirected to the pending-transactions.html

  Scenario: Send valid amount of money to valid email
    Given that I login as a user
    When I scroll down to see send money
    And I select the first account in send money
    And I type in an email of "jd81@a.ca" into send email
    And I type in a valid amount of "00.01" into send money
    And I click on send money submit button
    And I scroll back up from send money
    Then My first account should have less money

  Scenario: Request money from a valid email
    Given that I login as a user
    When I scroll down to see request money
    And I type in a valid email of "jd81@a.ca" into request email
    And I select the first account in request money
    And I type in a valid amount of "1" into request money
    Then I click on request money submit button
#
  Scenario: I logout of my account from user-page
    Given that I login as a user
    When I click on the logout button on the user-page
    Then I should be redirected to the index.html