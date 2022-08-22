Feature: Click Edit User Info

    Scenario: Click Edit User Info
        Given I am at the  login page
        And I type in a email of "jd80@a.ca"
        And I type in a password of "Password123!"
        And I click the login button
        And I am on my user page
        And I click the edit user info button
        Then I should be redirected to the edit user info page

