package Homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Feb11_homework2 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///Users/nataliayatsishin/Desktop/nataliia.html");
        System.out.println(driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "Nataliia's First HTML PAGE";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }
    }
}
