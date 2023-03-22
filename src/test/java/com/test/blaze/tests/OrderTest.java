package com.test.blaze.tests;

import com.test.blaze.pages.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class OrderTest extends TestBaseBlaze {
    //    WebDriver driver;
//
//    @BeforeMethod
//    public void setup() {
//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.demoblaze.com/#");
//    }
    @DataProvider(name = "customerInfo")
    Object[][] getData(){
        return new Object[][]{
                {"Ahmet", "Turkey", "Ankara", "123455", "12", "2025"},
                {"John", "USA", "Chicago", "876543", "5", "2026"},
                {"Phuong", "Vietnam", "Siylong", "5053987", "3", "2029"}
        };
    }

    @Test(dataProvider = "customerInfo")
    public void validateOrderFunctionality(String name, String country, String city, String card
    , String month, String year) throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptopButton();

        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.validateAllLaptops("MacBook Pro");

        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.clickAddToCartButton(driver, "Product added");

        CartPage cartPage = new CartPage(driver);
        cartPage.clickCartButton("MacBook Pro", "1100");
        cartPage.clickPlaceOrderButton();

        OrderPage orderPage = new OrderPage(driver);
        orderPage.validatePurchaseInformation(name, country, city, card, month, year);
        orderPage.validateMessageAfterPurchase("Thank you for your purchase!");
        orderPage.validateUrl(driver, "https://www.demoblaze.com/index.html");
        // ConfigReader.readProperty("creditCard")
    }

}
