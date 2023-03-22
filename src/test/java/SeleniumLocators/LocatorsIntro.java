package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Map;

public class LocatorsIntro {

    //ID LOCATOR
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("file:///Users/nataliayatsishin/Desktop/Techtorialhtml.html");

        WebElement header= driver.findElement(By.id("techtorial1"));
        String actualHeader = header.getText().trim(); //Techtorial Academy
        String expectedHeader = "Techtorial Academy";
        System.out.println(actualHeader);
        System.out.println(actualHeader.equals(expectedHeader)  ?  "Passed" : "Failed");

        WebElement paragraph = driver.findElement(By.id("details2"));
        System.out.println(paragraph.getText().trim());


        //NAME LOCATOR

        WebElement firstName = driver.findElement(By.name("firstName"));
        firstName.sendKeys("Nataliia");

        WebElement lastName = driver.findElement(By.name("lastName"));
        lastName.sendKeys("Yatsyshyn");

        WebElement phone = driver.findElement(By.name("phone"));
        phone.sendKeys("3129001871");

        WebElement email = driver.findElement(By.id("userName"));
        email.sendKeys("nata.yatsishin@gmail.com");

        WebElement address1 = driver.findElement(By.name("address1"));
        address1.sendKeys("6789 Lawrence Ave, Apt 2");

        WebElement address2 = driver.findElement(By.name("address2"));
        address2.sendKeys("Apt 123");

        WebElement city = driver.findElement(By.name("city"));
        city.sendKeys("Norridge");

        WebElement state = driver.findElement(By.name("state"));
        state.sendKeys("IL");

        WebElement postalCode = driver.findElement(By.name("postalCode"));
        postalCode.sendKeys("12345");

        //Thread.sleep(3000);

        //CLASS LOCATOR
        WebElement checkboxesLabel = driver.findElement(By.className("checkboxes"));
        System.out.println(checkboxesLabel.getText());


        WebElement javaBox= driver.findElement(By.id("cond1"));
        System.out.println(javaBox.isSelected());
        if (javaBox.isDisplayed() && !javaBox.isSelected()){
            javaBox.click();
        }
        System.out.println(javaBox.isSelected());

        WebElement seleniumBox = driver.findElement(By.id("cond2"));
        if (javaBox.isDisplayed() && !javaBox.isSelected()){
         seleniumBox.click();
        }

        System.out.println(seleniumBox.isSelected());

        WebElement testNgBox = driver.findElement(By.id("cond3"));
        if (testNgBox.isDisplayed() && !testNgBox.isSelected()) {
            testNgBox.click();
        }

        WebElement cucumberBox = driver.findElement(By.id("cond4"));
        if (cucumberBox.isDisplayed() && !cucumberBox.isSelected()){
            cucumberBox.click();
        }

        //TAG NAME LOCATOR:

        WebElement version = driver.findElement(By.tagName("u"));
        String actualVersion = version.getText().trim();
        String expectedVersion = "Use Java Version";
        if (actualVersion.equals(expectedVersion)){
            System.out.println("Validation is passed");
        }else {
            System.out.println("Validation is failed");
        }
    }
}
