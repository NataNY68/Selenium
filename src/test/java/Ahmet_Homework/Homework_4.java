package Ahmet_Homework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Homework_4 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.saucedemo.com/");

        WebElement userName = driver.findElement(By.cssSelector("#user-name"));
        userName.sendKeys("standard_user");

        WebElement password = driver.findElement(By.cssSelector("#password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.cssSelector("#login-button"));
        loginButton.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.saucedemo.com/inventory.html";
        System.out.println(actualUrl.equals(expectedUrl) ? "passed" : "failed");
    }
}
