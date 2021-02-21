Feature: As a User I want to validate The Problem #1 Scenario 

  @nightly
  Scenario: Perform a Test to validate the various Problem #1 Scenarios
    Given User navigate to url "https://www.exercise1.com/values"
    When User is on problem#1 Page
    Then User verify the right count of values appear on the screen
    Then User verify the values on the screen are greater than 0
    Then User verify the total balance is correct based on the values listed on the screen
    Then User verify the values are formatted as currencies
    Then User verify the total balance matches the sum of the values
