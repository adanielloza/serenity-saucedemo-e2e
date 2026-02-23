Feature: Purchase flow in SauceDemo

  Scenario: Successful purchase with two products
    Given I login to SauceDemo with standard_user and secret_sauce
    When I add two products to the cart
    And I view the cart
    And I complete the checkout form
    Then I should see the confirmation message "THANK YOU FOR YOUR ORDER"