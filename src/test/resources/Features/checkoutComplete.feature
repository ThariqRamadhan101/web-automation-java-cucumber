Feature: checkout complete web saucedemo

  Scenario: checkout complete
    Given user already in page saucedemo
    When click add to cart button
    And click cart button
    And click checkout button
    And fill information form with firstname "Myfirstname" lastname "Mylastname" zippostal code "12345"
    And click Continue
    And click Finish
    Then user directed to checkout complete page