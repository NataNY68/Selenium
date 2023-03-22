package WaitTimes;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utils.BrowserUtils;
import utils.DriverHelper;

import java.time.Duration;

public class ExplicitlyWait {
    WebDriver driver;

    @Test
    public void validateTheText(){
        driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dynamicLoading = driver.findElement(By.xpath("//a[.='Dynamic Loading']"));
        dynamicLoading.click();
        WebElement example1 = driver.findElement(By.partialLinkText("Example 1"));
        example1.click();
        WebElement startButton = driver.findElement(By.tagName("button"));
        startButton.click();
        WebElement text = driver.findElement(By.xpath("//div[@id='finish']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        text=wait.until(ExpectedConditions.visibilityOf(text));
        Assert.assertEquals(BrowserUtils.getText(text), "Hello World!");
    }

    @Test
    public void validateText2(){
        driver = DriverHelper.getDriver();
        driver.get("https://the-internet.herokuapp.com/");
        WebElement dynamicControls = driver.findElement(By.linkText("Dynamic Controls"));
        dynamicControls.click();
        WebElement checkbox = driver.findElement(By.cssSelector("#checkbox"));
        checkbox.click();
        WebElement removeButton = driver.findElement(By.xpath("//button[.='Remove']"));
        removeButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement message = driver.findElement(By.cssSelector("#message"));
        message=wait.until(ExpectedConditions.visibilityOf(message));

        Assert.assertEquals(BrowserUtils.getText(message), "It's gone!");
    }
}
