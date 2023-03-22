package com.test.bank.tests;

import com.test.bank.pages.LoginPage;
import com.test.bank.pages.ManagerPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.ConfigReader;

import java.time.Duration;

public class ManagerTest {

    WebDriver driver;
    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(ConfigReader.readProperty("url"));
    }

    @Test
    public void validateManagerPage() {

//        WebDriverManager.chromedriver().setup();
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginValidation();
    }

    @Test
    public void addCustomer(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginValidation();

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.addCustomer(driver, ConfigReader.readProperty("name"), ConfigReader.readProperty("lastName"), ConfigReader.readProperty("postCode"), "Customer added successfully");
    }

    @Test
    public void openAccount(){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginValidation();

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.addCustomer(driver, "Nataliia", "Yatsyshyn", "12345", "Customer added successfully");
        managerPage.openAccount(driver, "Nataliia Yatsyshyn", "Dollar", "Account created successfully");
    }

    @Test
    public void customerInfoValidation()throws InterruptedException{

        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginValidation();

        ManagerPage managerPage = new ManagerPage(driver);
        managerPage.addCustomer(driver, "Nataliia", "Yatsyshyn", "12345", "Customer added successfully");
        managerPage.customerValidation("Nataliia", "Yatsyshyn", "12345");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
