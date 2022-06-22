Feature: Searching products

  Background:
    Given I am on the automation practice homepage

    @zad42
    Scenario: Search without keyword
      When I type "" in the search box
      And I click on the magnifier icon
      Then I can see 'enter keyword' message

    @zad42
    Scenario: Search for non existing elements
      When I type "software" in the search box
      And I click on the magnifier icon
      Then I can see 'no results' message

    @zad42
    Scenario: Search for existing elements
      When I type "dress" in the search box
      And I click on the magnifier icon
      Then I can see dress list page