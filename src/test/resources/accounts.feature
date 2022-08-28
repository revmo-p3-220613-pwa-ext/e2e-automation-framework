Feature: Accounts
  Scenario: Click on first account
    Given that I login as a user
    When I click on the first account displayed
    Then I should be redirected to the account.html

    Scenario: Transfer Valid amount of money to another account
      Given I am on the first accounts, accounts page
      When I select the 1 account in transfer between accounts
      And I type in a valid amount of "00.01" into the transfer amount
      And I click the submit transfer button
      Then money amount should be taken from my account

      Scenario: I click on the User page button
        Given I am on the first accounts, accounts page
        And I click on the user page button on the accounts page
        Then I should be redirected to the user-page.html

      Scenario: I logout from the accounts page
        Given I am on the first accounts, accounts page
        When I click on the logout button on the accounts page
        Then I should be redirected to the index.html