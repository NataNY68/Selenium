package SeleniumIntro;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDriverMethods {
    public static void main(String[] args) throws InterruptedException {
        //driver.get();
        //driver.manage.window.maximize();
        //driver.getTitle();
        //driver.getCurrentUrl();
        //driver.getPageSource();
        //driver.navigateTo();
        //driver.navigate.refresh();
        //driver.navigate.forward();
        //driver.navigate.back();
        //driver.close();

        System.setProperty("webdrive.chrome.driver", "chromedriver"); //windows .exe
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.google.com/");
        System.out.println(driver.getTitle());
        driver.get("https://www.youtube.com/");
        System.out.println(driver.getCurrentUrl());

       // Thread.sleep(3000);
        driver.navigate().back(); //back to previous page --> Google
        //Thread.sleep(3000);
        driver.navigate().forward(); // forward to YouTube
        //Thread.sleep(3000);
        driver.navigate().refresh(); //refresh the page
        //Thread.sleep(3000);
        System.out.println(driver.getPageSource());//it will give the html structure of the page

        driver.close();

    }
}
