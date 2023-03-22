package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class DreamCar {

    /*
NOTE: Please use browser utils for the select classes if it is needed.
1-Navigate to the website
2-Choose the "New Cars" from the New/used option
3-Choose "Lexus" for Make part
4-Choose "RX-350"
5-Validate the Price is selected "No max price"-->getFirstSelectedOption
6-Choose the distance 40 mil
7-Put your Zip code-->Before that Clear it.60056
8-Click Search Button
9-Validate the header "New Lexus RX 350 for sale"
10-Click Sort by and choose the Lowest Price
11-Validate the all titles has Lexus RX 350

     */

    @Test
    public void validateHeadersOfTeCar() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.cars.com/");

        WebElement new_used = driver.findElement(By.cssSelector("#make-model-search-stocktype"));
        BrowserUtils.selectBy(new_used, "new", "value");

        WebElement make = driver.findElement(By.cssSelector("#makes"));
        BrowserUtils.selectBy(make,"Lexus", "text");

        WebElement models = driver.findElement(By.cssSelector("#models"));
        BrowserUtils.selectBy(models,"lexus-rx_350", "value");

        WebElement price = driver.findElement(By.cssSelector("#make-model-max-price"));
        Select priceFirstValidate = new Select(price);
        String actualPrice = BrowserUtils.getText(priceFirstValidate.getFirstSelectedOption());
        String expected = "No max price";
        Assert.assertEquals(actualPrice,expected);

        WebElement distance = driver.findElement(By.cssSelector("#make-model-maximum-distance"));
        BrowserUtils.selectBy(distance, "40", "value");

        WebElement zipCode = driver.findElement(By.cssSelector("#make-model-zip"));
        zipCode.clear();
        zipCode.sendKeys("60056");

        WebElement searchButton = driver.findElement(By.xpath("//button[@data-searchtype='make']"));
        searchButton.click();

        WebElement header = driver.findElement(By.xpath("//h1[.='New Lexus RX 350 for sale']"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "New Lexus RX 350 for sale";
        Assert.assertEquals(actualHeader, expectedHeader);
        Thread.sleep(1000);

        WebElement sortBy = driver.findElement(By.cssSelector("#sort-dropdown"));
        BrowserUtils.selectBy(sortBy,"Lowest price", "text");
        Thread.sleep(3000);
        List <WebElement> allPrices = driver.findElements(By.cssSelector(".primary-price"));
        List<Double> actualDoublePrice = new ArrayList<>();
        List<Double> expectedDoublePrice = new ArrayList<>();
        for (WebElement eachPrice:allPrices) {
            String newPrice = BrowserUtils.getText(eachPrice).replace("$", "").replace(",", "");
            System.out.println(newPrice);
            actualDoublePrice.add(Double.parseDouble(newPrice));
            expectedDoublePrice.add(Double.parseDouble(newPrice));
        }

        Collections.sort(expectedDoublePrice);
        Assert.assertEquals(actualDoublePrice, expectedDoublePrice);

        List<WebElement> titles = driver.findElements(By.xpath("//a[@data-linkname='vehicle-listing']"));
        for (WebElement title: titles) {
            Assert.assertTrue(BrowserUtils.getText(title).contains("Lexus RX 350") );
        }

//        List<String> numbers = Arrays.asList("1", "2", "11", "5", "21", "35") ;
//        List<Integer> numbers2 = Arrays.asList(1, 2, 11, 5, 21, 35);
//        Collections.sort(numbers);
//        System.out.println(numbers);
//
//        Collections.sort(numbers2);
//        System.out.println(numbers2);

    }
}
