package ActionClass;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class DragAndDrop {

    @Test
    public void DragAndDrop() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Thread.sleep(1000);
        cookies.click();
        WebElement orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessage = BrowserUtils.getText(orangeBox);
        String expectedMessage = "... Or here.";
        Assert.assertEquals(actualMessage, expectedMessage);

        String actualColorOfBox= orangeBox.getCssValue("background-color");
        String expectedColorOfBox = "rgba(238, 111, 11, 1)";
        Assert.assertEquals(actualColorOfBox, expectedColorOfBox);

        WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200, 200).perform();
        actions.dragAndDrop(dragger, orangeBox).perform();
        Thread.sleep(2000);
        orangeBox = driver.findElement(By.xpath("//div[@class='test2']"));
        String actualMessageAfterDropAndDrop = BrowserUtils.getText(orangeBox);
        String expectedMessageAfterDropAndDrop = "You did great!";
        Assert.assertEquals(actualMessageAfterDropAndDrop, expectedMessageAfterDropAndDrop);

    }
    @Test
    public void CkickAndHoldAndRelease() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/area");

        WebElement cookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Thread.sleep(1000);
        cookies.click();
        WebElement blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessage = BrowserUtils.getText(blueBox);
        String expectedMessage = "Drag the small circle here ...";
        Assert.assertEquals(actualMessage, expectedMessage);
        String actualColor = blueBox.getCssValue("background-color");
        String expectedColor = "rgba(63, 81, 181, 1)";
        Assert.assertEquals(actualColor, expectedColor);

        WebElement dragger = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.scrollByAmount(200, 200).perform();
        actions.clickAndHold(dragger).moveToElement(blueBox).release().perform();
        blueBox = driver.findElement(By.xpath("//div[@class='test1']"));
        String actualMessageAfterClickAndHold = BrowserUtils.getText(blueBox);
        String expectedMessageAfterClickAndHold = "You did great!";
        Assert.assertEquals(actualMessageAfterClickAndHold, expectedMessageAfterClickAndHold);



    }
}
