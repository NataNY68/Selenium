package homework4.tests;

import homework4.pages.TestingControlsPages;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class TestingControlsTest {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://uitestpractice.com/Students/Select#");
    }

    @Test
    public void testCase1(){
        TestingControlsPages testingControlsPages = new TestingControlsPages(driver);
        testingControlsPages.case1("India", 4);
    }

    @Test
    public void testCase2()throws InterruptedException{
        TestingControlsPages testingControlsPages = new TestingControlsPages(driver);
        testingControlsPages.case2();
    }

    @AfterMethod
    public void tearDown(){driver.quit();}

}
