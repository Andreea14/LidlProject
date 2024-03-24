Feature: Login Functionslity

  Scenario: Login Functionality

    Given I open the website
    And I click on the My account section
    When I entered the emailAddress
    And I press Next button
    And I entered the password
    And I press Login button
    Then I am logged successfully
    And close the browser


  Scenario: Unsuccessful login
    Given I open the website
    And I click on the My account section
    When I insert the invalidEmailAddress
    And I press Next button
    When I insert the invalid password
    Then an error message is displayed
    And close the browser
