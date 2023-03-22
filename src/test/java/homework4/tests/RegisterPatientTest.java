package homework4.tests;

import homework4.pages.LoginPage;
import homework4.pages.RegisterPatientPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class RegisterPatientTest {

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
    public void registerPatient() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality("admin", "Admin123");

        RegisterPatientPage registerPatient = new RegisterPatientPage(driver);
        registerPatient.RegisterPatient("Nataliia", "Yatsyshyn", "09", "1996",
                "2200 E Devon ave", "Des Plains", "IL", "Cook", "60018", "1234567890");

    }

    @Test
    public void validatePatientIsCreated() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality("admin", "Admin123");

        RegisterPatientPage registerPatient = new RegisterPatientPage(driver);
        registerPatient.RegisterPatient("Nataliia", "Yatsyshyn", "09", "1996",
                "2200 E Devon ave", "Des Plains", "IL", "Cook", "60018",
                "1234567890");
        registerPatient.validatePatientIsCreated("Created Patient Record: Nataliia Yatsyshyn");
    }

    @AfterMethod
    public void tearDown(){driver.quit();}
}
