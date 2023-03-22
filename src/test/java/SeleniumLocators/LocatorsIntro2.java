package SeleniumLocators;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsIntro2 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver..chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/nataliayatsishin/Desktop/Techtorialhtml.html");

        //LINKTEXT LOCATOR

        WebElement javaLink = driver.findElement(By.linkText("Java")); // a tag with the text
        javaLink.click();

        WebElement header = driver.findElement(By.tagName("h1"));
        System.out.println(header.getText().trim().equals("Java")  ? "Java passed"  : "Java failed");
       // Thread.sleep(2000);
        driver.navigate().back();

        WebElement seleniumLink = driver.findElement(By.linkText("Selenium"));
        seleniumLink.click();
        WebElement header1 = driver.findElement(By.tagName("h1"));
        System.out.println(header1.getText().trim().equals("Selenium automates browsers. That's it!")  ?
                "Selenium passed"  :  "Selenium failed");
        driver.navigate().back();

        WebElement cucumberLink = driver.findElement(By.linkText("Cucumber"));
        cucumberLink.click();
        WebElement header2 = driver.findElement(By.tagName("h1"));
        System.out.println(header2.getText().trim().equals("Tools & techniques that elevate teams to greatness") ?
        "Cucumber passed" : "Cucumber failed");
        driver.navigate().back();

        WebElement testNgLink = driver.findElement(By.linkText("TestNG"));
        testNgLink.click();
        WebElement header3 = driver.findElement(By.tagName("h2"));
        System.out.println(header3.getText().trim().equals("TestNG") ? "TestNG passed"  :  "TestNG failed");
        driver.navigate().back();

        String actualUrl = driver.getCurrentUrl().trim();
        String expectedUrl = "file:///Users/nataliayatsishin/Desktop/Techtorialhtml.html";

        System.out.println(actualUrl.equals(expectedUrl)  ?  "Url passed"  : "Url failed");

        //PARTIAL LINK TEXT LOCATOR:  must have a text and a name

        WebElement restApi = driver.findElement(By.partialLinkText("Rest"));
        //WebElement restApi = driver.findElement(By.linkedText("Rest Api"));
        restApi.click();

        String actualUrlrestApi = driver.getCurrentUrl();
        String expectedUrlRestApi = "https://rest-assured.io/";
        System.out.println(actualUrlrestApi.equals(expectedUrlRestApi) ? "Api Url passed" : "Api Url failed");


        driver.close();







    }


}
