Feature: Register

  Scenario: Register a Valid user
    Given I am on the registration page
    When I type in a valid and unique email of "newestuser3@a.am"
    And I type in a valid password of "Password123!"
    And I type in a valid first name of "Guy" in registration
    And I type in a valid last name of "Gardner" in registration
    And  I type in a valid phone number of "000-000-0000"
  And I click on the register submit button
    Then I should be redirected to the login.html

  Scenario: Login as new user
    Given I am at the home page
    When I type in a username "newestuser3@a.am" on the home page
    And I type in a password "Password123!" on the home page
    And I click on the login button on home page
    Then I should be redirected to the user-page.html

