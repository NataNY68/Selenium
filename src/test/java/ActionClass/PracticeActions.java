package ActionClass;

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

public class PracticeActions {

    @Test
    public void validateMessageAndColor() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement dropBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        WebElement dragBox = driver.findElement(By.xpath("//div[@id='draggable']"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(dragBox, dropBox).perform();
        dropBox = driver.findElement(By.xpath("//div[@id='simpleDropContainer']//div[@id='droppable']"));
        String actualMessage = BrowserUtils.getText(dropBox);
        String expectedMessage = "Dropped!";
        Assert.assertEquals(actualMessage, expectedMessage);
        Thread.sleep(1000);
        String actualColor = dropBox.getCssValue("background-color");
        System.out.println(actualColor);
        String expectedColor = "rgba(70, 130, 180, 1)";
        Assert.assertEquals(actualColor, expectedColor);

    }

    @Test
    public void validateNonAcceptableFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/droppable");

        WebElement acceptButton = driver.findElement(By.cssSelector("#droppableExample-tab-accept"));
        acceptButton.click();
        Thread.sleep(1000);

        WebElement nonAcceptable = driver.findElement(By.xpath("//div[@id='notAcceptable']"));
        String actualNonAcceptable = BrowserUtils.getText(nonAcceptable);
        String expectedNonAcceptable = "Not Acceptable";
        Assert.assertEquals(actualNonAcceptable, expectedNonAcceptable);

        WebElement dropHereBox = driver.findElement(By.xpath("//div[@class='accept-drop-container']//div[@id='droppable']//p"));
        String actualDropHere= BrowserUtils.getText(dropHereBox);
        String expectedDropHere = "Drop here";
        Assert.assertEquals(actualDropHere, expectedDropHere);

        Actions actions = new Actions(driver);
        actions.clickAndHold(nonAcceptable).moveToElement(dropHereBox).release().perform();

        String actualDropHereAfterClickAndHold = BrowserUtils.getText(dropHereBox);
        String expectedDropHereAfterClickAndHold = "Drop here";
        Assert.assertEquals(actualDropHereAfterClickAndHold, expectedDropHereAfterClickAndHold);





    }
}
