package com.company.pages;

import com.company.utils.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class InventoryPage {
    public static String inventoryPageUrl = "https://www.saucedemo.com/inventory.html";

    public WebDriver driver;

    public InventoryPage() {
        driver = DriverSingleton.getInstance();
        PageFactory.initElements(driver, this);
    }

    public InventoryPage goToPage() {
        driver.get(inventoryPageUrl);
        return this;
    }

    public boolean browserIsOnThePage() {
        return this.driver.getCurrentUrl().equals(this.inventoryPageUrl);
    }

}
