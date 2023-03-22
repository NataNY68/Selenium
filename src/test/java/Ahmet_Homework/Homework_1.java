package Ahmet_Homework;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework_1 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demoqa.com/text-box");

        WebElement name = driver.findElement(By.xpath("//input[@placeholder='Full Name']"));
        name.sendKeys("Nataliia");

        WebElement email = driver.findElement(By.xpath("//input[@placeholder='name@example.com']"));
        email.sendKeys("nata.yatsishin@gmail.com");

        WebElement currentAddress = driver.findElement(By.xpath("//textarea[@id='currentAddress']"));
        currentAddress.sendKeys("8564 W Lawrence Ave, Norridge");

        WebElement permanentAddress = driver.findElement(By.xpath("//textarea[@id='permanentAddress']"));
        permanentAddress.sendKeys("193 Vovchynetska St., Ivano-Frankivsk");

        WebElement submitButton = driver.findElement(By.xpath("//button[@id='submit']"));
        submitButton.sendKeys(Keys.ARROW_DOWN);
        Thread.sleep(1000);
        submitButton.click();

        List<WebElement> allInfo = driver.findElements(By.className("mb-1"));
        List<String> actualInfo = new ArrayList<>();

        for (WebElement info : allInfo) {
            actualInfo.add(info.getText());
        }

        List<String> expectedInfo = Arrays.asList("Name:Nataliia",
                "Email:nata.yatsishin@gmail.com",
                "Current Address :8564 W Lawrence Ave, Norridge",
                "Permananet Address :193 Vovchynetska St., Ivano-Frankivsk");

        System.out.println(actualInfo.equals(expectedInfo) ? "passed" : "failed");



    }
}
