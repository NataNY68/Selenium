package com.test.sentrifugo.tests;

import com.test.sentrifugo.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    @Test
    public void validateNegativeLogin1(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");

        LoginPage loginPage = new LoginPage(driver); // for PageFactory to initialize your element
        loginPage.login("ahmet", "sentrifugo");
        Assert.assertEquals(loginPage.validateErrorMessage(), "The username or password you entered is incorrect.");
        //Assert.assertEquals(loginPage.validateColorErrorMessage(),"");
    }

    @Test
    public void validateSucessfulLogin() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://demo.sentrifugo.com/index.php/");

        LoginPage loginPage = new LoginPage(driver); // for PageFactory to initialize your element
        loginPage.login("EM01", "sentrifugo");
        Assert.assertTrue(driver.getCurrentUrl().endsWith("welcome"));
        //the reason why I did not validate title because before and after login title is the same
        //it means it is not reliable

    }

}
