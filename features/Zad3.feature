Feature: Wikipedia search

  Background:
    Given I am on the wikipedia homepage

  @zad3
  Scenario: Searching BDD
    When I type "BDD" in the search bar
    And I click on the magnifier
    Then I can see "BDD" heading

  @zad3
  Scenario: Empty search
    When I type "" in the search bar
    And I click on the magnifier
    Then I can see "Szukaj" heading

  @zad3
  Scenario: Searching whitespaces
    When I type "   " in the search bar
    And I click on the magnifier
    Then I can see "Wyniki wyszukiwania" heading