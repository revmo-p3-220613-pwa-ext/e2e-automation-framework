Feature: Edit User's Info

  Scenario: Click Edit User Info
    Given I am at the  login page
    And I type in a email of "jd80@a.ca"
    And I type in a password of "Password123!"
    And I click the login button
    And I am on my user page
    And I click the edit user info button
    And I should be redirected to the edit user info page
    And I input a new email of "jd69@a.ca"
    And I input a new phone number of "696-969-6969"
    And I click the submit button
    Then I am redirected to my user page with new information