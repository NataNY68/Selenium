package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class SelectBasic {

    //Select class is al about drop down
    //Drop box must HAVE SELECT TAG NAME
    @Test
    public void practiceSelect() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");

        WebElement dropDown = driver.findElement(By.linkText("Dropdown"));
        dropDown.click();

        //location of the optionBox
        WebElement optionBox = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select options=new Select(optionBox); // provide the location of the box inside Select Object
        System.out.println(options.getFirstSelectedOption().getText().trim());

        options.selectByValue("1");
        Thread.sleep(2000);
        options.selectByVisibleText("Option 2 "); //visible text
        Thread.sleep(2000);
        options.selectByIndex(1);
        Thread.sleep(2000);
        List<WebElement> allOptions = options.getOptions();
        List<String> expectedOptions = Arrays.asList("Please select an option", "Option 1", "Option 2");

        for (int i=0; i<allOptions.size(); i++){
            Assert.assertEquals(allOptions.get(i).getText().trim(), expectedOptions.get(i));
        }

    }
}
