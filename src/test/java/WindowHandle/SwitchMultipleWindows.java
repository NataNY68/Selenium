package WindowHandle;

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

public class SwitchMultipleWindows {

    @Test
    public void multipleWindowsPractice() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('http://www.techtorialacademy.com/')");
        js.executeScript("window.open('https://www.techtorialacademy.com/contact-us-techtorial')");
        js.executeScript("window.open('https://www.techtorialacademy.com/courses')");

        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver, "Contact us");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver, "Home");
        Thread.sleep(3000);
        BrowserUtils.switchByTitle(driver, "Courses");
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void task2(){
          /*
1-Navigate to https://www.hyrtutorials.com/p/window-handles-practice.html
2-Click open multiple tabs under Button 4
3-the Basic Control and fill all the blanks
4-Click Register button and validate the message "Registration is Successful"
5-GO to the Window handle practice page and validate Header  which is Window Handles Practice
6- go to the alertsDemo page and click  the "Click Me" button under prompt box
7-quit all the pages.
8-Proud of yourself
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement button4 = driver.findElement(By.cssSelector("#newTabsBtn"));
        button4.click();

        BrowserUtils.switchByTitle(driver, "Basic Controls");
        WebElement firstName = driver.findElement(By.xpath("//input[@id='firstName']"));
        firstName.sendKeys("Nataliia");

        WebElement lastName = driver.findElement(By.xpath("//input[@id='lastName']"));
        lastName.sendKeys("Yatsyshyn");

        WebElement gender = driver.findElement(By.xpath("//input[@id='femalerb']"));
        gender.click();

        WebElement language = driver.findElement(By.cssSelector("#englishchbx"));
        language.click();

        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("nata@gmail.com");

        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("123abc");

        WebElement registrationBtn = driver.findElement(By.cssSelector("#registerbtn"));
        registrationBtn.click();

        WebElement message = driver.findElement(By.cssSelector("#msg"));
        String actualMessage = BrowserUtils.getText(message);
        String expectedMessage = "Registration is Successful";
        Assert.assertEquals(actualMessage, expectedMessage);

        BrowserUtils.switchByTitle(driver, "Window Handles Practice");
        WebElement header = driver.findElement(By.xpath("//h1[contains(text(), 'Window Handles Practice')]"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Window Handles Practice";
        Assert.assertEquals(actualHeader, expectedHeader);

        BrowserUtils.switchByTitle(driver, "AlertsDemo");
        WebElement clickMe = driver.findElement(By.cssSelector("#promptBox"));
        clickMe.click();
        driver.quit();



    }
}
