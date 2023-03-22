package JavaScriptExecutor;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaScriptPractice {

    @Test
    public void practice(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.techtorialacademy.com/home");

        WebElement copyright = driver.findElement(By.xpath("//div[contains(text(), 'Copyright © 2023')]"));
        BrowserUtils.scrollWithJS(driver, copyright);
        String actualCopyright = BrowserUtils.getText(copyright);
        String expectedCopyright = "Copyright © 2023";
        Assert.assertEquals(actualCopyright, expectedCopyright);

        WebElement applyNow = driver.findElement(By.xpath("//span[contains(text(), 'Apply Now')]"));
        BrowserUtils.scrollWithJS(driver, applyNow);
        BrowserUtils.clickWithJS(driver, applyNow);

        List<WebElement> list = driver.findElements(By.xpath("//h3[@data-element-id='heading3Normal']"));
        List<String> actualInfo = new ArrayList<>();
        List<String> expectedInfo = Arrays.asList("info@techtorialacademy.com", "+ 1 (224) 570 91 91", "Chicago & Houston");


        for (int i=0; i<list.size(); i++) {
          //actualInfo.add(BrowserUtils.getText(list.get(i)));
           Assert.assertEquals(BrowserUtils.getText(list.get(i)), expectedInfo.get(i));
        }
        //Assert.assertEquals(actualInfo, expectedInfo);

    }
}
