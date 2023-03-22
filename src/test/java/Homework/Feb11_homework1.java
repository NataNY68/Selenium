package Homework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Feb11_homework1 {
    public static void main(String[] args) {

            System.setProperty("webdriver.chrome.driver", "chromedriver");

            WebDriver driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get("https://www.techtorialacademy.com/?gclid=CjwKCAiAlp2fBhBPEiwA2Q10D6okPiE9WTTIN5XH0odFe2ucQgv3XljauysG9ut2QcpBHxUaaTJfIhoCJ_MQAvD_BwE");
            System.out.println(driver.getTitle());

            String actualTitle= driver.getTitle();
            String expectedTitle="Home";

            if(actualTitle.equals(expectedTitle)){
                System.out.println("Your test is passed");
            }else{
                System.out.println("Your test is failed");
            }

        }
}
