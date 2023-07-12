@regression
Feature: Shop functionality

  Scenario Outline: User can log in
    When [UI] User logs in with username <username> and <password>
    Then [UI] User should be on main page

    Examples: Examples:
      | username      | password     |
      | standard_user | secret_sauce |