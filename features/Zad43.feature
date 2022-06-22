Feature: Newsletter subscription

  Background:
    Given I am on the automationpractice page
    And I scroll down to the bottom of the page

  @zad43
  Scenario: Newsletter subscription with invalid email
    When I enter "test.test.pl" in the newsletter text field
    And I press on the arrow button
    Then I can see "Invalid email address." alert

  @zad43
  Scenario: Newsletter subscription with valid email
    When I enter "test@test8.pl" in the newsletter text field
    And I press on the arrow button
    Then I can see "You have successfully subscribed to this newsletter." alert

  @zad43
  Scenario: Newsletter subscription with existing in database email
    When I enter "test@test.pl" in the newsletter text field
    And I press on the arrow button
    Then I can see "This email address is already registered." alert
