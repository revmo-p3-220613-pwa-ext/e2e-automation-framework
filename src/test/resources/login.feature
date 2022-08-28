Feature: Login


  Scenario Outline: Valid user login
    Given I am at the login page
    When I type in a username "<username>"
    And I type in a password "<password>"
    And I click on the login button on login page
    Then I should be redirected to the <page>
    Examples:
      |username |password|page        |
      |jd80@a.ca|Password123!|user-page.html |
      |jd81@a.ca|Password123!|user-page.html  |
      |jd800@a.ca|Password123!|employee.html  |

  Scenario Outline: Invalid user login
    Given I am at the login page
    When I type in a username "<username>"
    And I type in a password "<password>"
    And I click on the login button on login page
    Then I should receive the error on the login page "<error>"
    Examples:
      |username |password|error      |
      |j80@a.ca|Password123!| Invalid email and/or password|
      |jd81@a.ca|password123!| Invalid email and/or password |
      |||Invalid email and/or password |

