@regression
Feature: Shop functionality

  @preConditionCreateTask
  Scenario Outline: User can do checkout
    When [UI] User logs in with username <username> and <password>
    When [UI] User chose item <itemName>
    When [UI] User add product to cart
    When [UI] User opens cart
    When [UI] User go to checkout
    When [UI] User fills his personal data firstName <firstName>, lastName <lastName> and postCode <postalCode>
    When [UI] User go to place order page
    Then [UI] User should see Thank you message

    Examples: Examples:
      | username      | password     | itemName              | firstName | lastName | postalCode |
      | standard_user | secret_sauce | Sauce Labs Bike Light | Alex      | Po       | 387412     |