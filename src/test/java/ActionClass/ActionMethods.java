package ActionClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ActionMethods {

    @Test //ContextClick means right click
    public void ContextClick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");

        WebElement contextMenu = driver.findElement(By.linkText("Context Menu"));
        contextMenu.click();

        WebElement box = driver.findElement(By.cssSelector("#hot-spot"));
        Actions actions = new Actions(driver);
        actions.contextClick(box).perform();

    }

    @Test
    public void ContextClickPractice() {
        WebDriverManager.chromedriver().setup();
//        System.setProperty("webdrive.chrome.driver", "chromedriver"); //windows .exe

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/simple_context_menu.html");
//        driver.get("https://google.com");
//        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement rightClickMe = driver.findElement(By.xpath("//span[.='right click me']"));
        Actions actions = new Actions(driver);
        actions.contextClick(rightClickMe).perform();
    }

    @Test
    public void doubleClick() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/simple_context_menu.html");

        WebElement doubleClick = driver.findElement(By.xpath("//button[contains(text(), 'Double')]"));
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClick).perform();


    }


}
