package Ahmet_Homework;

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

public class Homework2 {


    @Test
    public void Case1() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        String actualTitle = driver.getTitle();
        String expectedTitle = "Web Orders Login";
        Assert.assertEquals(actualTitle, expectedTitle);

        WebElement userName = driver.findElement(By.cssSelector("#ctl00_MainContent_username"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "Web Orders";
        Assert.assertEquals(actualTitle1, expectedTitle1);

        WebElement header = driver.findElement(By.tagName("h2"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "List of All Orders";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void Case2() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement viewAllProductsButton = driver.findElement(By.xpath("//a[.='View all products']"));
        //String actual = viewAllProductsButton.getText().trim();
        viewAllProductsButton.click();

        WebElement ViewAllProductIsSelected = driver.findElement(By.xpath("//li[@class='selected']"));
        // Assert.assertEquals(actual, ViewAllProductIsSelected.getText());
        Assert.assertTrue(ViewAllProductIsSelected.isDisplayed());

        WebElement header = driver.findElement(By.xpath("//h2[contains(text(), 'List')]"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "List of Products";
        Assert.assertEquals(actualHeader, expectedHeader);

        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains("Products"));

    }

    @Test
    public void Case3() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement viewAllOrdersLink = driver.findElement(By.linkText("View all orders"));
        String hrefValueViewAllOrders = viewAllOrdersLink.getAttribute("href");
        Assert.assertTrue(hrefValueViewAllOrders.contains("Default.aspx"));

        WebElement viewAllProductsLink = driver.findElement(By.linkText("View all products"));
        String hrefViewAllProduct = viewAllProductsLink.getAttribute("href");
        Assert.assertTrue(hrefViewAllProduct.contains("Products.aspx"));

        WebElement orderLink = driver.findElement(By.linkText("Order"));
        String hrefOrder = orderLink.getAttribute("href");
        Assert.assertTrue(hrefOrder.contains("Process.aspx"));
    }

    @Test
    public void Case4() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?");

        WebElement userName = driver.findElement(By.xpath("//input[@type='text']"));
        userName.sendKeys("Tester");

        WebElement password = driver.findElement(By.cssSelector("#ctl00_MainContent_password"));
        password.sendKeys("test");

        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Login']"));
        loginButton.click();

        WebElement orderButton = driver.findElement(By.linkText("Order"));
        orderButton.click();

        WebElement productBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_ddlProduct"));
        BrowserUtils.selectBy(productBox, "ScreenSaver", "value");

        WebElement quantityBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_txtQuantity"));
        //quantityBox.clear();
        quantityBox.sendKeys("5");

        WebElement customerNameBox = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$txtName']"));
        customerNameBox.sendKeys("CodeFish IT School");

        WebElement streetBox = driver.findElement(By.xpath("//input[@name='ctl00$MainContent$fmwOrder$TextBox2']"));
        streetBox.sendKeys("2200 E devon");

        WebElement cityBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox3"));
        cityBox.sendKeys("Des Plaines");

        WebElement stateBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox4"));
        stateBox.sendKeys("Illinois");

        WebElement zipCodeBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox5"));
        zipCodeBox.sendKeys("60018");

        WebElement masterCard = driver.findElement(By.xpath("//input[@value='MasterCard']"));
        masterCard.click();

        WebElement cardNumberBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox6"));
        cardNumberBox.sendKeys("444993876233");

        WebElement expirationDateBox = driver.findElement(By.cssSelector("#ctl00_MainContent_fmwOrder_TextBox1"));
        expirationDateBox.sendKeys("03/24");

        WebElement processButton = driver.findElement(By.cssSelector(".btn_light"));
        processButton.click();

        WebElement message = driver.findElement(By.tagName("strong"));
        String actualMesage = message.getText().trim();
        String expectedMessage = "New order has been successfully added.";
        Assert.assertEquals(actualMesage, expectedMessage);

        WebElement viewAllOrdersButton = driver.findElement(By.linkText("View all orders"));
        viewAllOrdersButton.click();

        WebElement table = driver.findElement(By.cssSelector(".SampleTable"));
        Assert.assertTrue(table.findElement(By.xpath("//tr[2]")).isDisplayed());

        List <WebElement> list = table.findElements(By.xpath("//tr[2]//td"));
       // Assert.assertTrue(list.);
        List <WebElement> actualList= new ArrayList<>();

        for (int i= 1; i<list.size()-1; i++){
            actualList.add(list.get(i));
        }

        List<String> expectedList = Arrays.asList("CodeFish IT School", "ScreenSaver", "5", "02/25/2023", "2200 E devon",
                "Des Plaines", "Illinois", "60018", "MasterCard", "444993876233", "03/24");

        for (int i=0; i< actualList.size(); i++){
            Assert.assertEquals(actualList.get(i).getText().trim(), expectedList.get(i).trim());
        }
    }

}
