package homework4.tests;

import homework4.pages.HomePage;
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

public class HomeTest {

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
    public void LocationFunctionality() throws InterruptedException {
        LoginPage openMRSLoginPage = new LoginPage(driver);
        openMRSLoginPage.loginFunctionality("admin", "Admin123");

        HomePage homePage = new HomePage(driver);
        homePage.locationValidation("Laboratory",
                "Logged in as Super User (admin) at Laboratory.",
                "Logged in as Super User (admin) at Pharmacy.");
        //homePage.findPatientRecord("John johns");

    }



    @Test
    public void validateIdIsUnique() throws InterruptedException {
        LoginPage openMRSLoginPage = new LoginPage(driver);
        openMRSLoginPage.loginFunctionality("admin", "Admin123");

        HomePage homePage = new HomePage(driver);
        homePage.findPatientRecord("John Johns");
        homePage.validateIDIsUnique("John Johns");
    }

    @Test
    public void validatePatientIsCreated() throws InterruptedException {
        LoginPage loginPage=new LoginPage(driver);
        loginPage.loginFunctionality("admin", "Admin123");
        HomePage homePage = new HomePage(driver);
        homePage.validatePatientIsCreated("Nataliia Yatsyshyn");
       // homePage.findPatientRecord();
        homePage.validateIDIsUnique("Nataliia Yatsyshyn");
    }

    @Test
    public void deletePatientFunctionality() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality("admin", "Admin123");
        HomePage homePage = new HomePage(driver);
        homePage.findPatientRecord("Nataliia Yatsyshyn");
        homePage.deletePatient("Nataliia Yatsyshyn", "Reason cannot be empty",
                "Moved", "Patient has been deleted successfully");
    }

    @AfterMethod
    public void tearDown(){driver.quit();}
}
