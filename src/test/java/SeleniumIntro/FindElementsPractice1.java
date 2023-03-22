package SeleniumIntro;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class FindElementsPractice1 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/");

        List<WebElement> list = driver.findElements(By.xpath("//li"));
        int counter = 0;
        for (WebElement each :list){
            counter++;
            System.out.println(counter + " - " + each.getText() + "");}
        System.out.println(list.size());

        int counter12 = 1;
        for (WebElement each:list){
            if (each.getText().trim().length()>=12){
                System.out.println( counter12+ " - " +each.getText());
                counter12++;
            }
        }




    }

}
