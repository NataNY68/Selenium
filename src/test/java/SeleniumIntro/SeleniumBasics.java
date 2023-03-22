package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumBasics {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver");

        WebDriver driver = new ChromeDriver(); //create an object
        driver.manage().window().maximize(); //maximize the screen
        driver.get("https://www.amazon.com/"); //navigate to the website
        System.out.println(driver.getTitle()); //get the title
        String actualTitle= driver.getTitle(); //get the title
        String expectedTitle="Amazon.com. Spend less. Smile more.";

        if(actualTitle.equals(expectedTitle)){
            System.out.println("Your test is passed");
        }else{
            System.out.println("Your test is failed");
        }

        //driver.getCurrentUrl();

        driver.get("https://www.techtorialacademy.com/");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.techtorialacademy.com/";
        String actualTitleTechtorial = driver.getTitle();
        String expectedTitleTechtorial = "Home";

        if (actualUrl.equals(expectedUrl)){
            System.out.println("URL is passed");
        }else {
            System.out.println("URL is failed");
        }

        if (actualTitleTechtorial.equals(expectedTitleTechtorial)){
            System.out.println("Title is passed");

        }else {
            System.out.println("Title is failed");
        }

        driver.close();

    }
}
