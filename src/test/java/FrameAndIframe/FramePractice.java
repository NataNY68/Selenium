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

public class FramePractice {

    @Test
    public void ifarmePractice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/iframe");

        WebElement header = driver.findElement(By.tagName("h3"));
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);

        driver.switchTo().frame("mce_0_ifr");
        WebElement box = driver.findElement(By.cssSelector("#tinymce"));
        box.clear();
        box.sendKeys("I love Selenium");

        driver.switchTo().parentFrame();
        WebElement elementalSelenium = driver.findElement(By.xpath("//a[contains(text(), 'Sel')]"));
        elementalSelenium.click();

        BrowserUtils.switchByTitle(driver, "Using Selenium like a Pro");
        WebElement seleniumHeader = driver.findElement(By.tagName("h1"));
        String actualSeleniumHeader = BrowserUtils.getText(seleniumHeader);
        String expectedSeleniumHeader = "Elemental Selenium";
        Assert.assertEquals(actualSeleniumHeader, expectedSeleniumHeader);
    }


}
