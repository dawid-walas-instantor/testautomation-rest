package com.company.steps;

import com.company.pages.InventoryPage;
import com.company.pages.MainPage;
import com.company.utils.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.AfterAll;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MainPageSteps {
    private MainPage mainPage;
    private InventoryPage inventoryPage;

    public MainPageSteps() {
        mainPage = new MainPage();
        inventoryPage = new InventoryPage();
    }

    @Given("Go to the home page")
    public void goToTheHomePage() {
        mainPage.goToPage();
    }

    @And("User login with username {string} and password as {string}")
    public void theUserProvidesTheUsernameAsAndPasswordAs(String username, String password) {
        mainPage.login(username, password);
    }

    @Then("The user should login successfully and is brought to the inventory page")
    public void theUserShouldLoginSuccessfullyAndIsBroughtToTheInventoryPage() {
        assertTrue(inventoryPage.browserIsOnThePage());
    //    DriverSingleton.getInstance().quit();
    }

    @Then("The user should not login successfully and is still on login page")
    public void theUserShouldNotLoginSuccessfullyAndIsStillOnLoginPage() {
        assertEquals("Epic sadface: Username and password do not match any user in this service", mainPage.getErrorText());
    //    DriverSingleton.getInstance().quit();
    }

    @After
    public void whatever(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot scrShot = ((TakesScreenshot) DriverSingleton.getInstance());
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("screen.png");

            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @AfterAll
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot scrShot = ((TakesScreenshot) DriverSingleton.getInstance());
            File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File destFile = new File("screen.png");

            try {
                FileUtils.copyFile(srcFile, destFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
