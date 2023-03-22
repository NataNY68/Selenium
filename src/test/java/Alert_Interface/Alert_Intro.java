package Alert_Interface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;

import java.time.Duration;

public class    Alert_Intro {
    @Test
    public void alertAcceptAndGetText() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsAlert()')]"));
        alertButton.click();

        Alert alert = driver.switchTo().alert();
        String actualJSAlertText = alert.getText(); // get the text from ALERT POP-UP
        String expectedJSAlertText = "I am a JS Alerts"; // So I cannot use getText from BrowserUtils
//        Assert.assertEquals(actualJSAlertText, expectedJSAlertText);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualJSAlertText, expectedJSAlertText, "There is a comparison problem");
        Thread.sleep(3000);
        alert.accept(); // it clicks OK button
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);// this is WebElement, so I can use getText from BrowserUtils
        String expectedMessage = "You successfully clicked an alert";
        Assert.assertEquals(actualMessage, expectedMessage);

        softAssert.assertAll();
    }

    @Test
    public void AlertDismiss(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement alertButton = driver.findElement(By.xpath("//button[contains(@onclick,'jsConfirm()')]"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        alert.dismiss();
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);// this is WebElement, so I can use getText from BrowserUtils
        String expectedMessage = "You clicked: Cancels";
        //Assert.assertEquals(actualMessage, expectedMessage);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualMessage, expectedMessage);
        softAssert.assertAll();
    }

    @Test
    public void sendKeys(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");

        WebElement jsPrompt = driver.findElement(By.xpath("//button[contains(text(), 'Prompt')]"));
        jsPrompt.click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("I Love UI Automation");
        alert.accept();
        WebElement message = driver.findElement(By.cssSelector("#result"));
        String actualMessage = BrowserUtils.getText(message);// this is WebElement, so I can use getText from BrowserUtils
        String expectedMessage = "You entered: I Love UI Automation";
        Assert.assertEquals(actualMessage, expectedMessage);

    }
}
