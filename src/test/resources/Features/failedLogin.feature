Feature: failed login web saucedemo

  Scenario: failed login
    Given login page saucedemo
    When input username "non_standard_user"
    And input password "non_secret_sauce"
    And click login button
    Then user is showed error message