Feature: Amazon Search

 @amazon
  Scenario: Validating search results for cucumber on amazon
    When user navigates to "https://www.amazon.com/" home page
    And user is searching for cucumber on amazon result page
    Then user validates the number of amazon search results to be more than 100

