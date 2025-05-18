Feature: Login

  Background: Login to Application
    Given User is on Login Page
    When User entered "<username>" and "<pass>"
      | username      | pass         |
      | standard_user | secret_sauce |
    Then User is on product page

  Scenario: Add to Cart and Verify Items
    Given User add items in cart
    When User click on cart button
    Then User Verify Items

  Scenario: Checkout and Payment
    Given User is on cart
    When  User click on checkout button
    And User enter checkout info
    And User click on continue button
    And User click on Finish
    Then User is on  successfull order Page
