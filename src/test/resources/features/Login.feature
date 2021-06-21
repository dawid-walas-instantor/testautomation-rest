Feature: TS001 Login

  Scenario: TS001-TC001 Valid user can sign in
    Given Go to the home page
    And User login with username "standard_user" and password as "secret_sauce"
    Then The user should login successfully and is brought to the inventory page

  Scenario: TS001-TC002 Invalid user cannot sign in
    Given Go to the home page
    And User login with username "asd" and password as "asd"
    Then The user should not login successfully and is still on login page