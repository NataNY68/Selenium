package FrameAndIframe;

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
import java.util.List;

public class FramePractice2 {

    @Test
    public void practiceFrame() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://skpatro.github.io/demo/iframes/");

        WebElement pavilionButton = driver.findElement(By.linkText("Pavilion"));
        pavilionButton.click();

        BrowserUtils.switchByTitle(driver, "Home");
        WebElement selenium = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(selenium).perform();

        WebElement seleniumJava = driver.findElement(By.xpath("//ul[@id='primary-menu']//span[.='Selenium-Java']"));
        actions.click(seleniumJava).perform();

        WebElement header = driver.findElement(By.tagName("h1"));
        String actualHeader = BrowserUtils.getText(header);
        String expectedHeader = "Selenium-Java Tutorial – Basic to Advance";
        Assert.assertEquals(actualHeader, expectedHeader);

        List<WebElement> list = driver.findElements(By.xpath("//ul[@class='ht_toc_list']//a"));

        for (WebElement eachName : list){
            System.out.println(BrowserUtils.getText(eachName));
        }

        BrowserUtils.switchByTitle(driver, "iframes");
        WebElement iframe = driver.findElement(By.xpath("//iframe[@id='Frame1']"));
       // driver.switchTo().frame(iframe);
        driver.switchTo().frame("Frame1");
        WebElement category1 = driver.findElement(By.xpath("//a[.='Category1']"));
        category1.click();
        Thread.sleep(1000);

        BrowserUtils.switchByTitle(driver, "SeleniumTesting");
        WebElement categoryHeader = driver.findElement(By.tagName("h1"));
        String actualCategoryHeader = BrowserUtils.getText(categoryHeader);
        String expectedCategoryHeader = "Category Archives: SeleniumTesting";
        Assert.assertEquals(actualCategoryHeader, expectedCategoryHeader);

        Thread.sleep(2000);
        List<WebElement> allConsept = driver.findElements(By.xpath("//h3"));
        for (WebElement consept:allConsept){
            System.out.println(BrowserUtils.getText(consept));
        }

        BrowserUtils.switchByTitle(driver, "iframes");
        WebElement iframe2 = driver.findElement(By.xpath("//iframe[@id='Frame2']"));
        driver.switchTo().frame(iframe2);
        WebElement category3 = driver.findElement(By.linkText("Category3"));
        category3.click();

        BrowserUtils.switchByTitle(driver, "SoftwareTesting Archives");
        WebElement headerCategoryArchives = driver.findElement(By.tagName("h1"));
        String actualheaderCategoryArchives = BrowserUtils.getText(headerCategoryArchives);
        String expectedheaderCategoryArchives = "Category Archives: SoftwareTesting";
        Assert.assertEquals(actualheaderCategoryArchives, expectedheaderCategoryArchives);
    }
}
