Feature: success login web saucedemo

  Scenario: success login
    Given login page saucedemo
    When input username "standard_user"
    And input password "secret_sauce"
    And click login button
    Then user directed to products page

#    TODO: implement logic, failed login, logout, checkout one item