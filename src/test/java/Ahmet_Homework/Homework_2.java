package Ahmet_Homework;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.security.Key;
import java.time.Duration;

public class Homework_2 {
    public static void main(String[] args) throws InterruptedException {
        //CASE 2

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/radio-button");

        WebElement yesButton = driver.findElement(By.xpath("//input[@id='yesRadio']"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", yesButton);

        if (yesButton.isDisplayed() && !yesButton.isSelected()) {
            yesButton.click();
        }

        WebElement youHaveSelectedYes = driver.findElement(By.xpath("//p[.='You have selected Yes']"));
        //System.out.println(youHaveSelectedYes.getText());
        String actualSelectedYes = youHaveSelectedYes.getText().trim();
        String expectedSelectedTes = "You have selected Yes";
        System.out.println(actualSelectedYes.equals(expectedSelectedTes) ? "Passed" : "Failed");

        Thread.sleep(1000);
        WebElement impessiveButton = driver.findElement(By.xpath("//input[@id='impressiveRadio']"));
        js.executeScript("arguments[0].click()", impessiveButton);

        if (!impessiveButton.isSelected() && impessiveButton.isDisplayed()) {
            impessiveButton.click();
        }

        WebElement youHaveSelectedImpressive = driver.findElement(By.xpath("//p[.='You have selected Impressive']"));
        String actualSelectedImpressive = youHaveSelectedImpressive.getText().trim();
        String expectedSelectedImpressive = "You have selected Impressive";
        System.out.println(actualSelectedImpressive.equals(expectedSelectedImpressive) ? "Passed" : "Failed");

    }


}
