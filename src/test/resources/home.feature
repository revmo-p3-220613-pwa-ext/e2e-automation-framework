Feature: Home
  Scenario Outline: Valid user login from home page
    Given I am at the home page
    When I type in a username "<username>" on the home page
    And I type in a password "<password>" on the home page
    And I click on the login button on home page
    Then I should be redirected to the <page>
    Examples:
      |username |password|page        |
      |jd80@a.ca|Password123!|user-page.html |
      |jd81@a.ca|Password123!|user-page.html  |
      |jd800@a.ca|Password123!|employee.html  |

  Scenario Outline: Invalid user login
    Given I am at the home page
    When I type in a username "<username>" on the home page
    And I type in a password "<password>" on the home page
    And I click on the login button on home page
#    Then I should receive the error on the login page "<error>"
    Examples:
      |username |password    |error                          |
      |j80@a.ca |Password123!| Invalid email and/or password |
      |jd81@a.ca|password123!| Invalid email and/or password |
      |jd80@a.ca|            |Invalid email and/or password  |
      |         |Password123!|Invalid email and/or password  |