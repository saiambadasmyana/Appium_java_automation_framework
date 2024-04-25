@Checkout
  Feature: Checkout

    @Smoke
    Scenario: Checkout a product and confirm order
      Given I open the application
      Then I see login screen
      When I enter username "standard_user"
      And I enter password "secret_sauce"
      And I click on login
      Then I can see products screen
      When I click on "Sauce Labs Backpack" text
      Then I can see "Sauce Labs Backpack" product screen
      And I check price of product
      When I click on add to cart
      And I click on cart icon
      And I checkout the product
      And I enter "firstname" as "appium"
      And I enter "lastname" as "java"
      And I enter "postal code" as "cucumber"
      And I click on continue
      Then I can see checkout overview screen
      And I click on finish
      Then I can see order confirmation screen