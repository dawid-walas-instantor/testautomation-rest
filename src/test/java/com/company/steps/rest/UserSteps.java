package com.company.steps.rest;

import com.company.rest.UserEndpoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserSteps {

    private UserEndpoint userEndpoint;

    public UserSteps() {
        this.userEndpoint = new UserEndpoint();
    }

    @Given("Create a new user")
    public void create_a_new_user() {
        this.userEndpoint.addTestUser();
    }

    @Then("Check if created user exists")
    public void check_if_created_user_exists() {
        this.userEndpoint.getTestUser();
    }


    @Given("Delete an existing user")
    public void deleteAnExistingUser() {
        this.userEndpoint.addTestUser();

        this.userEndpoint.deleteUser(this.userEndpoint.getUserByUsername("jkowalski"));
    }

    @Then("Check if deleted user does not exist")
    public void checkIfDeletedUserDoesNotExist() {
        assertFalse(this.userEndpoint.userExists("jkowalski"));
    }
}
