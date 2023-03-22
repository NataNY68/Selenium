package Ahmet_Homework;

import com.beust.ah.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Homework3 {

    @Test
    public void Case1() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://uitestpractice.com/Students/Index");

        Thread.sleep(1000);
        WebElement createNewButton = driver.findElement(By.xpath("//button[@class='btn btn-info']"));
        createNewButton.click();

//        driver.switchTo().frame("aswift_2");
//        driver.switchTo().frame("ad_iframe");
//        Thread.sleep(2000);
//        WebElement closeButton = driver.findElement(By.cssSelector("#dismiss-button"));
//        closeButton.click();

        WebElement firstName = driver.findElement(By.cssSelector("#FirstName"));
        firstName.sendKeys("Nataliia");

        WebElement lastName = driver.findElement(By.cssSelector("#LastName"));
        lastName.sendKeys("Yatsyshyn");

        WebElement enrollmentDate = driver.findElement(By.xpath("//input[@name='EnrollmentDate']"));
        enrollmentDate.sendKeys("03/02/2023");

        WebElement createButton = driver.findElement(By.xpath("//input[@value='Create']"));
        createButton.click();

        WebElement searchBar = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchBar.sendKeys("Nataliia", Keys.ENTER);

        List<WebElement> newInfo = driver.findElements(By.xpath("//tr[2]//td"));
        newInfo.remove(newInfo.size() - 1);
        System.out.println(newInfo.size());
        List<String> expectedInfo = Arrays.asList("Nataliia", "Yatsyshyn", "3/2/2023 12:00:00 AM");

        for (int i = 0; i < newInfo.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(newInfo.get(i)), expectedInfo.get(i));
        }
    }

    @Test
    public void Case2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://uitestpractice.com/Students/Index");

        WebElement searchBar = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchBar.sendKeys("Yatsyshyn", Keys.ENTER);

        WebElement editButton = driver.findElement(By.xpath("//button[.='EDIT']"));
        editButton.click();

        WebElement firstName = driver.findElement(By.cssSelector("#FirstName"));
        firstName.clear();
        firstName.sendKeys("Natali");

        WebElement saveButton = driver.findElement(By.xpath("//input[@value='Save']"));
        saveButton.click();

        searchBar = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchBar.sendKeys("Natali", Keys.ENTER);


        WebElement newFirstName = driver.findElement(By.xpath("//tr[2]//td[1]"));
        String actualFirstName = BrowserUtils.getText(newFirstName);
        String expectedFirstName = "Natali";
        Assert.assertEquals(actualFirstName, expectedFirstName);

    }

    @Test

    public void Case3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://uitestpractice.com/Students/Index");


        WebElement searchBar = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchBar.sendKeys("Yatsyshyn", Keys.ENTER);

        WebElement deleteButton = driver.findElement(By.xpath("//button[.='DELETE']"));
        deleteButton.click();

        WebElement confirmDeleteButton = driver.findElement(By.xpath("//input[@value='Delete']"));
        confirmDeleteButton.click();

        searchBar = driver.findElement(By.xpath("//input[@id='Search_Data']"));
        searchBar.sendKeys("Yatsyshyn", Keys.ENTER);

        WebElement textValidation = driver.findElement(By.xpath("//div[@class='container body-content']"));

        Assert.assertTrue(BrowserUtils.getText(textValidation).contains("There are zero students"));

    }

    @Test
    public void Case4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://uitestpractice.com/");

        Actions actions = new Actions(driver);
        WebElement smallBox = driver.findElement(By.cssSelector("#draggable"));
        WebElement bigBox = driver.findElement(By.cssSelector("#droppable"));
        actions.dragAndDrop(smallBox, bigBox).perform();

        WebElement droppedText = driver.findElement(By.xpath("//p[.='Dropped!']"));
        Assert.assertTrue((droppedText.isDisplayed()));

    }

    @Test
    public void Case5() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://uitestpractice.com/");

        WebElement doubleClickButton = driver.findElement(By.xpath("//button[@name='dblClick']"));
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.doubleClick(doubleClickButton).perform();

        Alert alert = driver.switchTo().alert();
        String expectedText = "Double Clicked !!";
        Assert.assertEquals(alert.getText(), expectedText);
        alert.accept();

    }

    @Test
    public void Case6() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://uitestpractice.com/");

        driver.switchTo().frame("iframe_a");
        WebElement enterYourNameBox = driver.findElement(By.xpath("//body/input[@id='name']"));
        enterYourNameBox.sendKeys("Nataliia");

        driver.switchTo().parentFrame();
        WebElement link = driver.findElement(By.xpath("//a[@target='iframe_a']"));
        link.click();

        driver.switchTo().frame("iframe_a");
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        WebElement greyBox = driver.findElement(By.xpath("//div[@id='sub-frame-error']"));
        actions.moveToElement(greyBox).perform();
        WebElement refusedToConnectText = driver.findElement(By.xpath("//div[@id='sub-frame-error-details']"));
        Assert.assertTrue(refusedToConnectText.isDisplayed());
    }

    @Test
    public void Case7() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://uitestpractice.com/");

        WebElement clickToOpenNewWindow = driver.findElement(By.linkText("Click here to watch videos on C#"));
        clickToOpenNewWindow.click();
        BrowserUtils.switchByTitle(driver, "C# Beginner to advanced - Lesson 29 - Delegates - YouTube");
        Assert.assertTrue(driver.getCurrentUrl().contains("youtube"));

    }

}
