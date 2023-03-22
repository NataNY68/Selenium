package homework4.tests;

import homework4.pages.HomePage;
import homework4.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://codefish.ninja/openmrs/login.htm");
    }

    @Test
    public void loginCase3() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality("admin", "Admin123");
    }

    @AfterMethod
    public void tearDown(){driver.quit();}



}
