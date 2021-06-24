Feature: TS002 REST API

  Scenario: TS002-TC001 Create user
    Given Create a new user
    Then Check if created user exists

  Scenario: TS002-TC002 Delete user
    Given Delete an existing user
    Then Check if deleted user does not exist