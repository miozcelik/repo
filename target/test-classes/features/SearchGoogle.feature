Feature: Google Search

  Background:
    When user navigates to "https://www.google.com/" search page

  @google
  Scenario: Validating search results for cucumber on google
    When user navigates to "https://www.google.com/" search page
    And user is searching for cucumber on google result page
    Then user validates the number of google search results to be more than 100


    @test
    Scenario: Negative search scenario
      When user navigates to "https://www.google.com/" search page
      And user enters "java basics" in search field
      Then the result page will not have topics about "python"

     @search
      Scenario: Google search link number validation
        When user navigates to "https://www.google.com/" search page
        And user searches for "cucumber cookbook" on google
        Then the number of links on 1st and 2nd result pages more than 20



