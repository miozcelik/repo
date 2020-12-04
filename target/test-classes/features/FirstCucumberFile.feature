Feature: Techtorial Academy page tests


  @neverFails1
  Scenario: Happy path(succcessful) sign in
    When user navigates to Techtorial academy home page
    And user uses "admin" as username abd "admin123" as password
    Then user logged in