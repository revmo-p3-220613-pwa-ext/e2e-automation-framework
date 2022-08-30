Feature: Logout

  Scenario: Logout
    Given I am on my user's page
    When I click the logout button
    Then I should be redirected to the login page
