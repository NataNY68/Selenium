package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class SpruceInterviewQuestion {
    @Test
    public void validateFishProduct() throws InterruptedException {

        /*
1-Navigate to the website "https://www.thespruceeats.com/"
2-Under Ingredients option --> choose Fish&SeaFood option
3-ScrollDown to the search bar
4-Send the data: "Fish for dinner"
5-On the left side choose 4 star up option
6-From popular: Choose the Editor's choice option
7-Validate the name of product is "6-Ingredient Roasted Salmon Fillets"
8-Quit or close your driver
 */
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.thespruceeats.com/");

        Actions actions = new Actions(driver);
        WebElement ingridients = driver.findElement(By.xpath("//span[.='Ingredients']"));
        actions.moveToElement(ingridients).perform();
        //Thread.sleep(1000);
        WebElement fishAndSeafood = driver.findElement(By.xpath("//a[.='Fish & Seafood']"));
        actions.click(fishAndSeafood).perform();

        Thread.sleep(2000);
        WebElement searchBar = driver.findElement(By.cssSelector("#search-form-input"));
        BrowserUtils.scrollWithJS(driver,searchBar);
        searchBar.sendKeys("Fish for dinner", Keys.ENTER);
//        WebElement searchButton = driver.findElement(By.cssSelector("#button_1-0"));
//        BrowserUtils.clickWithJS(driver,searchButton);

        WebElement fourStar = driver.findElement(By.xpath("//label[@for='starRating_score_4Star']"));
        fourStar.click();
        Thread.sleep(1000);

        WebElement editorsChoise = driver.findElement(By.xpath("//label[@for='pop_search_editor']"));
        editorsChoise.click();
        Thread.sleep(1000);

        Thread.sleep(1000);
        WebElement text = driver.findElement(By.cssSelector(".card__underline"));
        String expected = "6-Ingredient Roasted Salmon Fillets";
        Thread.sleep(3000);
        Assert.assertEquals(BrowserUtils.getText(text), expected);


    }
}
