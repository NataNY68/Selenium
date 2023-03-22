package com.test.blaze.tests;

import com.test.blaze.pages.LaptopPage;
import com.test.blaze.pages.MacBookProPage;
import com.test.blaze.pages.MainPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;

public class MacBookProTest extends TestBaseBlaze{
//    WebDriver driver;
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

    /*
    1-Navigate to the website "https://www.demoblaze.com/#"
    2-Click the Laptops from homepage(firstPage)
    3-Click MacBook Pro from the list with Loop(LaptopPage)
    4-Validate the header="MacBook Pro"(MacBook Pro Page)
    5-Validate the price=$1100 *includes tax(MacBook Pro Page)
    6-Validate the product Descr="Product description(MacBook Pro Page)
Apple has introduced three new versions of its MacBook Pro line, including a 13-inch and
15-inch model with the Touch Bar, a thin, multi-touchstrip display that sits above the MacBook Pro's keyboard."
    7-Click the Add to card Button and validate the alert text="Product added" then click "OK" button
     */

    @Parameters({"laptopBrand", "laptopPrice","message", "laptopDescription"})
    @Test
    public void validateMacBookProInformation(String laptopBrand, String laptopPrice, String message,
                                               String laptopDescription)throws InterruptedException{
        MainPage mainPage = new MainPage(driver);
        mainPage.clickLaptopButton();

        LaptopPage laptopPage = new LaptopPage(driver);
        laptopPage.validateAllLaptops(laptopBrand);

        MacBookProPage macBookProPage = new MacBookProPage(driver);
        macBookProPage.productInformationValidation(driver, laptopBrand, laptopPrice,
        laptopDescription);

      //  macBookProPage.clickAddToCartButton(driver);
        macBookProPage.clickAddToCartButton(driver,message);
    }

//    @AfterMethod
//    public void tearDown(){
//        driver.quit();
//    }

}
