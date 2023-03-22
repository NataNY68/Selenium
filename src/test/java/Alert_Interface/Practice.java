package Alert_Interface;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class Practice {
    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/alertsdemo.html");

        WebElement alertBox = driver.findElement(By.xpath("//button[contains(@onclick, 'alertFunction()')]"));
        alertBox.click();
        Alert alert = driver.switchTo().alert();
        String actualAlertMessage = alert.getText();
        String expectedAlertMessage = "I am an alert box!";
        Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
        alert.accept();
        WebElement messageAfterAlert = driver.findElement(By.cssSelector("#output"));
        String expectedMessageAfterAlert = "You selected alert popup";
        Assert.assertEquals(BrowserUtils.getText(messageAfterAlert), expectedMessageAfterAlert);

        WebElement confirmBox = driver.findElement(By.xpath("//button[contains(@onclick, 'confirmFunction()')]"));
        confirmBox.click();
        alert = driver.switchTo().alert();
        String actualConfirmMessage = alert.getText();
        String expectedConfirmMessage = "Press a button!";
        alert.dismiss();
        Assert.assertEquals(actualConfirmMessage, expectedConfirmMessage);
      //  WebElement messageAfterConfirm = driver.findElement(By.cssSelector("#output"));
        String expectedMessageAfterConfirm = "You pressed Cancel in confirmation popup";
        Assert.assertEquals(BrowserUtils.getText(messageAfterAlert), expectedMessageAfterConfirm);

        WebElement promptBox = driver.findElement(By.xpath("//button[contains(@onclick, 'promptFunction()')]"));
        promptBox.click();
        alert = driver.switchTo().alert();
        alert.sendKeys("Nataliia");
        alert.accept();
        WebElement messageAfterPrompt = driver.findElement(By.cssSelector("#output"));
        String expectedMessageAfterAlertPrompt = "You entered text Nataliia in propmt popup";
        Assert.assertEquals(BrowserUtils.getText(messageAfterAlert), expectedMessageAfterAlertPrompt);
       // System.out.println(BrowserUtils.getText(messageAfterAlert));

    }
}
