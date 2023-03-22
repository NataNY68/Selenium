package MentoringWithAhmet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Facebook {

    @Test
    public void facebookSignUp() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.facebook.com/");
        Thread.sleep(1000);

        WebElement createNewAccountButton = driver.findElement(By.xpath("//a[.='Create new account']"));
        createNewAccountButton.click();

        WebElement firstName = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstName.sendKeys("Nata");

        WebElement lastName = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastName.sendKeys("Yatsyshyn");

        WebElement phoneOrEmail = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        phoneOrEmail.sendKeys("nataliia1234@gmail.com");

        WebElement reEnteremail = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        reEnteremail.sendKeys("nataliia1234@gmail.com");

        WebElement newPassword = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        newPassword.sendKeys("123F");

        WebElement birthMonth = driver.findElement(By.xpath("//select[@name='birthday_month']"));
        birthMonth.sendKeys("Sep");

        WebElement birthDay = driver.findElement(By.xpath("//select[@name='birthday_day']"));
        birthDay.sendKeys("9");

        WebElement birthYear = driver.findElement(By.xpath("//select[@name='birthday_year']"));
        birthYear.sendKeys("2000");

        Thread.sleep(1000);
        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        female.click();

        WebElement customButton = driver.findElement(By.xpath("//input[@value='-1']"));
        customButton.click();


        WebElement selectYourPronoun = driver.findElement(By.xpath("//select[@aria-label='Select your pronoun']"));
        selectYourPronoun.sendKeys("She: \"Wish her a happy birthday!\"");
        selectYourPronoun.findElement(By.xpath("//option[.='She: \"Wish her a happy birthday!\"']")).click();

        WebElement genderOptional = driver.findElement(By.xpath("//input[@aria-label='Gender (optional)']"));
        genderOptional.sendKeys("I am women");

        WebElement signUp = driver.findElement(By.xpath("//button[@name='websubmit']"));
        signUp.click();
        Thread.sleep(5000);
        WebElement message = driver.findElement(By.cssSelector("#reg_error_inner"));
        String actualMessage = message.getText().trim();
        Thread.sleep(1000);
        String expectedMessage = "Your password must be at least 6 characters long. Please try another.";

        Assert.assertEquals(actualMessage, expectedMessage);


    }


}

