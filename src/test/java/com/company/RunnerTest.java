package com.company;

import com.company.utils.DriverSingleton;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.AfterClass;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "json:target/cucumber-reports/Cucumber.json",
        "junit:target/cucumber-reports/Cucumber.xml",
        "html:target/cucumber-report.html"}, features = "src/test/resources")
public class RunnerTest {
    @AfterClass
    public static void tearDown() {
        DriverSingleton.getInstance().quit();
    }
}
