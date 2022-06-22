Feature: Browse the clothes catalog

  Background:
    Given I am on the automationpractice homepage

  @zad41
  Scenario: Browsing women category
    When I click on the "Women" button
    Then I can see the "Women" section

  @zad41
  Scenario: Browsing dresses category
    When I click on the "Dresses" button
    Then I can see the "Dresses" section

  @zad41
  Scenario: Browsing t-shirts category
    When I click on the "T-shirts" button
    Then I can see the "T-shirts" section