package WindowHandle;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Set;

public class SwitchWindow {
    @Test
    public void switchPractice() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/windows");

        WebElement clickHereButton = driver.findElement(By.linkText("Click Here"));
        clickHereButton.click();

        String mainPageId = driver.getWindowHandle(); // returns pageID of the class
        System.out.println(mainPageId); //CDwindow-4AA36C47BB1424142CCC8FB3C438E1E6

        Set<String> allPagesId = driver.getWindowHandles();
        System.out.println(allPagesId);

        //this is used for only 2 tabs/windows

        for (String id : allPagesId) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                break;
            }
        }

        WebElement header = driver.findElement(By.tagName("h3"));
        System.out.println(BrowserUtils.getText(header));
    }

    @Test
    public void homework() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/home");

        WebElement courseButton = driver.findElement(By.xpath("//span[contains(text(), 'Find out which course is for you')]"));
        courseButton.click();

        String mainPageId = driver.getWindowHandle();
        Set<String> allPageId = driver.getWindowHandles();

        for (String id : allPageId) {
            if (!id.equals(mainPageId)) {
                driver.switchTo().window(id);
                System.out.println(driver.getTitle());
                break;
            }

        }
    }

    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.hyrtutorials.com/p/window-handles-practice.html");

        WebElement openNewTabButton = driver.findElement(By.cssSelector("#newTabBtn"));
        openNewTabButton.click();

        String mainPageId = driver.getWindowHandle();
        Set<String> allPagesId = driver.getWindowHandles();
        for( String  id : allPagesId){
            if(!id.equals(mainPageId)){
                driver.switchTo().window(id);
                break;
            }
        }

        Assert.assertEquals(driver.getTitle(), "AlertsDemo - H Y R Tutorials");
        WebElement alertDemo = driver.findElement(By.xpath("//h1[@itemprop='name']"));
        Assert.assertEquals(BrowserUtils.getText(alertDemo), "AlertsDemo");
        WebElement clickMe = driver.findElement(By.cssSelector("#alertBox"));
        clickMe.click();
        driver.quit();

    }
}
