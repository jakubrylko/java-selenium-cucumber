Feature: Bank account transfers

  Scenario: Money whitdrawal which don't exceeds the account balance
    Given There is 2000 PLN on the account
    When I withdraw 1000 PLN
    Then The operation should be possible
    And The account balance is 1000 PLN

  Scenario: Money whitdrawal which exceeds the account balance
    Given There is 2000 PLN on the account
    When I withdraw 3000 PLN
    Then The operation should not be possible
    And The account balance is 2000 PLN

  Scenario: Multiple money whitdrawal
    Given There is 2000 PLN on the account
    When I withdraw 500 PLN
    And I withdraw 1000 PLN
    Then The operation should be possible
    And The account balance is 500 PLN

  Scenario: Money transfer to the account
    Given There is 2000 PLN on the account
    When I transfer 500 PLN
    Then The account balance is 2500 PLN