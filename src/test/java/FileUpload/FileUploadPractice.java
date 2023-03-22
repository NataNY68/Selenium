package FileUpload;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;

public class FileUploadPractice {

    @Test
    public void practice1(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://the-internet.herokuapp.com/upload");

        WebElement chooseFileButton = driver.findElement(By.cssSelector("#file-upload"));
        chooseFileButton.sendKeys("/Users/nataliayatsishin/Desktop/usa.png");

        WebElement fileUploadButton = driver.findElement(By.cssSelector("#file-submit"));
       //fileUploadButton.click();
        fileUploadButton.submit();

        WebElement attachment = driver.findElement(By.cssSelector("#uploaded-files"));
        String actualMessage = BrowserUtils.getText(attachment);
        String expectedMessage = "usa.png";
        Assert.assertEquals(actualMessage, expectedMessage);


    }

    @Test
    public void practice2() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://demo.guru99.com/test/upload/");

        WebElement chooseFileButton = driver.findElement(By.cssSelector(".upload_txt"));
        chooseFileButton.sendKeys("/Users/nataliayatsishin/Desktop/usa.png");

        WebElement selectFileToSend = driver.findElement(By.xpath("//div[@='uploadmode3']//following-sibling::span"));
        String actualSelectFileToSend = BrowserUtils.getText(selectFileToSend);
        String expectedSelectFileToSend = "Select file to send(max 196.45 MB)";
        Assert.assertEquals(actualSelectFileToSend, expectedSelectFileToSend);

        WebElement termsBox = driver.findElement(By.xpath("//a[.='terms of service']//preceding-sibling::input"));
        termsBox.click();

        WebElement submitFileButton = driver.findElement(By.xpath("//button[@id='submitbutton']"));
        submitFileButton.click();
        Thread.sleep(1000);

        WebElement fileHasBeenSuccessfullyUploaded = driver.findElement(By.xpath("//h3[@id='res']"));
        String actualUploaded = BrowserUtils.getText(fileHasBeenSuccessfullyUploaded);
        String expectedUploaded = "1 file\n" +
                "has been successfully uploaded.";
        Assert.assertEquals(actualUploaded, expectedUploaded);



    }
}
