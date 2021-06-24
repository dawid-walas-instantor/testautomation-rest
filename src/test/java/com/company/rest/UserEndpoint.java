package com.company.rest;

import com.company.rest.dtos.User;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserEndpoint {

    final String baseUrl = "https://petstore.swagger.io/v2";
    final String usersPath = "/user";
    User dummyUser;

    public UserEndpoint() {
        RestAssured.baseURI = this.baseUrl;
    }

    @Before
    public void setup() {
        RestAssured.baseURI = this.baseUrl;
    }

    public void addTestUser() {
        this.dummyUser = new User();
        this.dummyUser.setId(1);
        this.dummyUser.setUsername("jkowalski");
        this.dummyUser.setFirstName("Jan");
        this.dummyUser.setLastName("Kowalski");
        this.dummyUser.setEmail("jkowalski@kowalski.pl");
        this.dummyUser.setPassword("111111");
        this.dummyUser.setPhone("123456789");
        this.dummyUser.setPassword("secret");
        this.dummyUser.setUserStatus(1);
        this.addUser(this.dummyUser);
    }

    public void getTestUser() {
        // sprawdz czy user jest poprawnie dodany
        User testUser = this.getUserByUsername("jkowalski");
        assertEquals(this.dummyUser, testUser);
        //System.out.println(testUser.toString());
    }

    public void addUser(User user) {
        RequestSpecification httpRequest = RestAssured.given().
                contentType("application/json").accept("application/json").
                body(user);

        Response response = httpRequest.post(this.usersPath);

        assertEquals(response.statusCode(), 200);
    }

    public User getUserByUsername(String username) {
        Response getResponse = RestAssured.given().get(this.usersPath + "/" + username);
        User returnedUser = getResponse.as(User.class);

        assertEquals(getResponse.statusCode(), 200);
        getResponse.getBody().prettyPrint();
        return returnedUser;
    }


    public void deleteUser(User user) {
        RequestSpecification httpRequest = RestAssured.given().
                contentType("application/json").accept("application/json");

        Response response = httpRequest.delete(this.usersPath + "/" + user.getUsername());

        assertEquals(response.statusCode(), 200);
    }

    public boolean userExists(String username) {
        Response getResponse = RestAssured.given().get(this.usersPath + "/" + username);

        int statusCode = getResponse.statusCode();

        return statusCode == 200;
    }

}
