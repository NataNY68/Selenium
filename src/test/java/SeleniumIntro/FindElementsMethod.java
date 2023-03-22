package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.nio.file.WatchEvent;
import java.time.Duration;
import java.util.List;

public class FindElementsMethod {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("file:///Users/nataliayatsishin/Desktop/Techtorialhtml.html");

        List<WebElement> allBoxes = driver.findElements(By.xpath("//input[@type='checkbox']")); // 4 elements

        Thread.sleep(1000);
        for ( WebElement box : allBoxes) {
            if (box.isDisplayed() && !box.isSelected() && box.isEnabled()){
                box.click();
            }
        }




    }
}
