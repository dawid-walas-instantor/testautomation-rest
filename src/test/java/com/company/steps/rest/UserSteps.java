package com.company.steps.rest;

import com.company.rest.UserEndpoint;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class UserSteps {

    private UserEndpoint userEndpoint;

    public UserSteps() {
        userEndpoint = new UserEndpoint();
    }

    @Given("Create a new user")
    public void create_a_new_user() {
        userEndpoint.addTestUser();
    }

    @Then("Check if created user exists")
    public void check_if_created_user_exists() {
        userEndpoint.getTestUser();
    }


}
