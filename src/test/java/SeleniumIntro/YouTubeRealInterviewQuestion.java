package SeleniumIntro;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;
import java.util.List;

public class YouTubeRealInterviewQuestion {
    public static void main(String[] args) throws InterruptedException {
/* 1-Navigate to the website youtube
 2-Search for justin bieber
 3-Find the all song names and store in the list Justin Bieber - Hold On (Live from Paris)
 4-Use for and if conditions to find the song
 5-Click the song
 6-Enjoy your music
 7-Ready to be level 2
 */

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://www.youtube.com/");

        WebElement searchBox = driver.findElement(By.xpath("//input[@id='search']"));
        searchBox.sendKeys("justin bieber songs");

        WebElement searchButton = driver.findElement(By.xpath("//button[@id='search-icon-legacy']"));
        searchButton.click();
        Thread.sleep(1000);
        List<WebElement> allSongs = driver.findElements(By.xpath("//a[@id='video-title']"));

        for (WebElement song :allSongs ){
            song.sendKeys(Keys.ARROW_DOWN);
            if (song.getAttribute("title").trim().equals("Justin Bieber - Sorry (Lyrics)")){
                song.click();
                break;
            }
      }

        Thread.sleep(1000);
        driver.navigate().to("https://www.youtube.com/results?search_query=justin+bieber+songs");
      //  Thread.sleep(1000);
        List<WebElement> list = driver.findElements(By.xpath("//yt-formatted-string[@class='style-scope ytd-video-renderer']"));
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (WebElement link : list) {
           // Thread.sleep(1000);
            //link.sendKeys(Keys.ARROW_DOWN);
           ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", link);
           //System.out.println(link.getText());
           if (link.getText().equals("Justin Bieber - Boyfriend")) {
               js.executeScript("arguments[0].click()", link);
               link.click();
               break;
            }
        }


    }
}

