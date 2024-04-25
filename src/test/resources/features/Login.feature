@Simple
Feature: Login

  @Smoke1
  Scenario: Login to application
    Given I open the application
    Then I see login screen
    When I enter username "standard_user"
    And I enter password "secret_sauce"
    And I click on login
    Then I can see products screen