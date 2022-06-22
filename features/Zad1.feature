Feature: Checkout

  Scenario: Add item with empty name
    Given the price of a "" is 25c
    When I checkout "" 1
    Then the total price should be 0c

  Scenario: Add item with empty name
    Given the price of a "banana" is -1c
    When I checkout "banana" 1
    Then the total price should be 0c

  Scenario: Checkout bananas twice
    Given the price of a "banana" is 40c
    When I checkout "banana" 1
    And I checkout "banana" 1
    Then the total price should be 80c

  Scenario: Checkout non existing items
    Given empty product list
    When I checkout "apple" 1
    And I checkout "banana" 2
    Then the total price should be 0c

  Scenario Outline: Checkout apples and bananas
    Given the price of a "banana" is 40c
    And the price of a "apple" is 25c
    When I checkout "apple" <applecount>
    And I checkout "banana" <bananacount>
    Then the total price should be <total>c

    Examples:
      | applecount | bananacount | total |
      |     1      |  1          | 65    |
      |     2      |  2          | 130   |