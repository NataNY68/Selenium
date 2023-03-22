package com.test.saucedemo.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.ConfigReader;
import utils.DriverHelper;

public class SauceTestBase {

    public WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= DriverHelper.getDriver();
        driver.get(ConfigReader.readProperty("QA_sauceUrl"));
    }

    @AfterTest
    public void tearDown(){
        BrowserUtils.getScreenShot(driver, "sauce");
        driver.quit();
    }
}
