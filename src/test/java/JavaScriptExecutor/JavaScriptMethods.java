package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class JavaScriptMethods {

    //We use Java Script Methods when Selenium methods are not working as expected, specifically click(), getTitle
    //NOTE: We love using ScrollIntoView Method from JavaScript in professional environment
    @Test
    public void getTitle(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/home");

        System.out.println(driver.getTitle() + " This is regular driver method for title");
        //if this is not working, then we need to use JavaScript method

        JavascriptExecutor js = (JavascriptExecutor) driver; // your driver is acting like JS executor
        String title = js.executeScript("return document.title").toString();
        System.out.println(title + " This is JavaScript method for title");
    }

    @Test
    public void clickJS() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", yesButton);

        WebElement message = driver.findElement(By.cssSelector(".mt-3"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "You have selected Yes";
        Assert.assertEquals(actualMessage, expectedMessage);
        WebElement impressiveButton = driver.findElement(By.cssSelector("#impressiveRadio"));
        js.executeScript("arguments[0].click()", impressiveButton);
        String actualImpressiveMessage = BrowserUtils.getText(message);
        String expectedImpressiveMessage = "You have selected Impressive";
        Assert.assertEquals(actualImpressiveMessage, expectedImpressiveMessage);
    }

    //this one is all about scrolling the page on the location of element -->
    @Test
    public void ScrollIntoView() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/home");

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(), 'Find')]//.."));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", findCourse);//***
        Thread.sleep(3000);
        js.executeScript("arguments[0].click", findCourse);//**
        System.out.println(js.executeScript("return document.title").toString());//*
    }

    @Test
    public void shortCutJSMethods() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/home");

        WebElement findCourse = driver.findElement(By.xpath("//span[contains(text(), 'Find')]//.."));
        Thread.sleep(1000);
        BrowserUtils.scrollWithJS(driver, findCourse);
        Thread.sleep(1000);
        BrowserUtils.clickWithJS(driver, findCourse);
        Thread.sleep(3000);
        System.out.println(BrowserUtils.getTitleWithJS(driver));
    }
}
