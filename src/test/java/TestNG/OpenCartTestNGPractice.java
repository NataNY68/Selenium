package TestNG;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.security.Key;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class OpenCartTestNGPractice {
    //TASK-1
    //1 login successfully with 'demo' username and password, and validate the title

    @Test
    public void successfulLogin() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(1000);
        String actualTitle = driver.getTitle().trim();
        String expectedTitle = "Dashboard";
        Assert.assertEquals(actualTitle, expectedTitle);

    }

    @Test
    public void negativeLogin() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("dfh");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("tttt");

        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();
        Thread.sleep(1000);

       // WebElement message = driver.findElement(By.cssSelector("#alert"));
        WebElement message = driver.findElement(By.xpath("//div[@id='alert']"));
        String actualMessage = message.getText().trim();
        String expectedMessage = "No match for Username and/or Password.";
        Assert.assertEquals(actualMessage, expectedMessage);

    }

    @Test
    public void validateProduct() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();

        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalogButton.click();

        Thread.sleep(1000);
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        Assert.assertTrue(productButton.isDisplayed());




    }

    @Test
    public void validateBoxesFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();

        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalogButton.click();

        Thread.sleep(1000);
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        productButton.click();

        List<WebElement> allBoxes = driver.findElements(By.cssSelector(".form-check-input"));

        for (int i = 1; i< allBoxes.size(); i++){
            Thread.sleep(1000);
            Assert.assertTrue(allBoxes.get(i).isDisplayed() && allBoxes.get(i).isEnabled());
            //Assert.assertEquals(allBoxes.get(i).isDisplayed(), true);
            Assert.assertFalse(allBoxes.get(i).isSelected()); // box is not selected, so it will return false
            allBoxes.get(i).click();
            Assert.assertTrue(allBoxes.get(i).isSelected()); //will return true
            allBoxes.get(i).sendKeys(Keys.ARROW_DOWN);

        }


    }

    @Test
    public void validateProductName() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();

        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalogButton.click();

        Thread.sleep(1000);
        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        productButton.click();

        Thread.sleep(1000);
        WebElement productNameButton = driver.findElement(By.linkText("Product Name"));
        productNameButton.click();
        Thread.sleep(2000);

        List<WebElement> productNames = driver.findElements(By.xpath("//td[@class='text-start']"));
        List<String> actualNames =new ArrayList<>();
        List<String> expectedNames = new ArrayList<>();

        for (int i = 1; i < productNames.size(); i++) {
            Thread.sleep(1000);
            actualNames.add(productNames.get(i).getText().toLowerCase().trim()); //mostly for comparing like ascending, descending
            expectedNames.add(productNames.get(i).getText().toLowerCase().trim());
        }

        Collections.sort(expectedNames); //sorting for ascending
        Collections.reverse(expectedNames); //making guarantee it is descending
        System.out.println(expectedNames);
        System.out.println(actualNames);
        Assert.assertEquals(actualNames, expectedNames);


    }


    @Test
    public void validateProductNameFunctionality() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.opencart.com/admin/");

        WebElement userName = driver.findElement(By.xpath("//input[@id='input-username']"));
        userName.sendKeys("demo");

        WebElement password = driver.findElement(By.xpath("//input[@id='input-password']"));
        password.sendKeys("demo");

        Thread.sleep(1000);
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        loginButton.click();

        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.cssSelector(".btn-close"));
        closeButton.click();

        Thread.sleep(1000);
        WebElement catalogButton = driver.findElement(By.xpath("//a[contains(text(), 'Catalog')]"));
        catalogButton.click();

        WebElement productButton = driver.findElement(By.xpath("//a[contains(text(), 'Products')]"));
        productButton.click();

        Thread.sleep(1000);

        List<WebElement> productNames = driver.findElements(By.xpath("//td[@class='text-start']"));

        List<String> actual = new ArrayList<>();
        List<String> expected = new ArrayList<>();

        for (int i = 1; i < productNames.size(); i++) {
            actual.add(productNames.get(i).getText().toLowerCase().trim());
            expected.add(productNames.get(i).getText().toLowerCase().trim());
        }
        Collections.sort(expected);
        Assert.assertEquals(actual, expected);
        System.out.println(actual);
        System.out.println(expected);

    }
}
