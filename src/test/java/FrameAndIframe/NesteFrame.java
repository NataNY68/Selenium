package FrameAndIframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class NesteFrame {
    @Test

    public void NestedFramePractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/nested_frames");

        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");

        WebElement leftFrame = driver.findElement(By.xpath("//body"));
        String actualLeft = BrowserUtils.getText(leftFrame);
        String expectedLeft = "LEFT";
        Assert.assertEquals(actualLeft, expectedLeft);

        //Thread.sleep(1000);
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-middle");
        WebElement middleFrame = driver.findElement(By.xpath("//body"));
        String actualMiddle = BrowserUtils.getText(middleFrame);
        String expectedMiddle = "MIDDLE";
        Assert.assertEquals(actualMiddle, expectedMiddle);

        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-right");
        WebElement rightFrame = driver.findElement(By.xpath("//body"));
        String actualRight = BrowserUtils.getText(rightFrame);
        String expectedRight = "RIGHT";
        Assert.assertEquals(actualRight, expectedRight);

//        driver.switchTo().parentFrame();//top frame
//        driver.switchTo().parentFrame();//main html
        driver.switchTo().defaultContent(); //directly to the main page
        driver.switchTo().frame("frame-bottom");

        WebElement bottomFrame = driver.findElement(By.xpath("//body[contains(text(), 'BOTTOM')]"));
        String actualBottom = BrowserUtils.getText(bottomFrame);
        String expectedBottom = "BOTTOM";
        Assert.assertEquals(actualBottom, expectedBottom);


    }
}