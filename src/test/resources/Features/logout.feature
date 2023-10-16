Feature: logout web saucedemo

  Scenario: logout
    Given user already in page saucedemo
    When click burger button
    And click logout button
    Then user directed to login page