Feature: User Page

    Scenario: Click Edit User Info
        Given I am logged in
        And I am on my user page
        When I click the edit user info button
        Then I should be redirected to the edit user info page

    Scenario: Click View Account
        Given I am logged in
        And I am on my user page
        And I have an active account
        When I click on the view account button
        Then I should be redirected to the page for that account.