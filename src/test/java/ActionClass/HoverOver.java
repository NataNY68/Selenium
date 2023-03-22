package ActionClass;

import com.github.dockerjava.api.model.Link;
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
import java.util.*;

public class HoverOver {

    @Test
    public void validateNamesFromPictures() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/hovers");

        List<WebElement> names = driver.findElements(By.tagName("h5"));
        List<WebElement> images = driver.findElements(By.xpath("//div[@class='figure']//img"));
        List<String> actualNames = new ArrayList<>();
        List<String> expectedNames = Arrays.asList("name: user1","name: user2","name: user3");
        Actions actions = new Actions(driver);

        for (int i=0; i< names.size(); i++) {
            Thread.sleep(2000);
            actions.moveToElement(images.get(i)).perform(); //you are hover overing the pictures
            actualNames.add(BrowserUtils.getText(names.get(i))); //you are storing the names inside the list for validation
        }
        System.out.println(actualNames);
        System.out.println(expectedNames);
        Assert.assertEquals(actualNames, expectedNames);

    }

    @Test
    public void practiceMoveToElement() throws InterruptedException {
        /*
1-Navigate to the website
2-If you have cookies pop-up then click
3-Hover over each pictures and get the names and store it in List<String> allNames
4-Hover over each pictures and get the prices and store it in List<String> all prices
5-Put them all of the names as key of map, and all of the prices as value of map
6-Print out map

CLUES:You can use 1 regular(indexing) loop for adding the name and prices into the lists
CLUES:You can use same loop for putting into the map
CLUES:TO ab ele to get names and prices you need to hover over first
CLUES:DO not forget perform
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demos.telerik.com/kendo-ui/fx/expand");

        List<WebElement> pictures = driver.findElements(By.xpath("//div[@class='k-listview-content']//img"));
        List<WebElement> names = driver.findElements(By.xpath("//div[@class='product-description']//h3"));
        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='product-description']//p"));
        List <String> allNames = new ArrayList<>();
        List <String> allPrice = new ArrayList<>();
        Actions actions = new Actions(driver);
        Map<String, String> map = new LinkedHashMap<>();
        WebElement acceptCookies = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
        Thread.sleep(1000);
        acceptCookies.click();
        for (int i=0; i<pictures.size(); i++){
            actions.moveToElement(pictures.get(i)).perform();
//            allNames.add(BrowserUtils.getText(names.get(i)));
//            allPrice.add(BrowserUtils.getText(prices.get(i)));
//            map.put(allNames.get(i), allPrice.get(i));
            map.put(BrowserUtils.getText(names.get(i)), BrowserUtils.getText(prices.get(i)));
        }
        System.out.println(map);



    }
}
