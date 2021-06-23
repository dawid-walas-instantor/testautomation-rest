package com.company.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverSingleton {
    private static WebDriver driver;

    public static WebDriver getInstance() {
        if (driver == null) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options = new ChromeOptions();

            URL seleniumUrl = null;
            try {
                seleniumUrl = new URL("http://localhost:4444/wd/hub");
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            //WebDriver webDriver = new RemoteWebDriver(seleniumUrl, options);
            driver = new RemoteWebDriver(seleniumUrl, options);
           // driver = new ChromeDriver(options);
        }

        return driver;
    }
}
