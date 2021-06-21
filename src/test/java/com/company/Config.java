package com.company;

import com.company.utils.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;

public class Config {
    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            TakesScreenshot scrShot = ((TakesScreenshot) DriverSingleton.getInstance());
            File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
            File DestFile = new File("screen.png");

            try {
                FileUtils.copyFile(SrcFile, DestFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        DriverSingleton.getInstance().quit();
    }
}
