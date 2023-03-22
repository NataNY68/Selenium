package Ahmet_Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework_3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("Java");

        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        password.sendKeys("Selenium");

        WebElement loginButton = driver.findElement(By.xpath("//input[@id='login-button']"));
        loginButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String actualMessage = errorMessage.getText();
        String expectedMessage = "Epic sadface: Username and password do not match any user in this service";
        System.out.println(actualMessage.equals(expectedMessage) ? "Passed" : "Failed");


    }
}
