Feature: EditUserInfo

  Scenario Outline: Valid Updates For user information
    Given I am on the edit user info page
    When I type in a first name of "<firstname>"
    And I type in a valid last name of "<lastname>"
    And I type a valid phone number of "<phone-number>"
    And I click on the submit changes button
    Then I should be redirected to the user-page.html
    But the name should now match "<firstname>""<lastname>"
    And the phone number should match "<phone-number>"
    Examples:
    |firstname|lastname|phone-number |
    |Bruce    |Wayne   |999-999-9999|
    |Barry    |Allen   |888-888-8888|
    |Peter    |Parker  |777-777-7777|


  Scenario: Logout from edit user info page
    Given I am on the edit user info page
    When I click on the logout button on the edit user info page
    Then I should be redirected to the index.html

  Scenario: Go back to the user page
    Given I am on the edit user info page
    When I click on the User page button on the edit user info page
    Then I should be redirected to the user-page.html