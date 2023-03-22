package SelectClass;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectPractice {

    @Test

    public void validateFirstOptionAndPrintAllOptions() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///Users/nataliayatsishin/Desktop/Techtorialhtml.html");

        WebElement countryBox = driver.findElement(By.xpath("//select[@name='country']"));
        Select country = new Select(countryBox);
        String actualFirstOption = country.getFirstSelectedOption().getText().trim();
        String expectedFirstOption = "UNITED STATES ".trim();
        Assert.assertEquals(actualFirstOption, expectedFirstOption);
        System.out.println(country.getFirstSelectedOption().getText().trim());
        List<WebElement> allCountries = country.getOptions();
        int counter = 0;
        for (WebElement countryName: allCountries) {
            System.out.println(countryName.getText());
            counter++;
        }
        System.out.println(counter);
    country.selectByValue("212");
        Thread.sleep(2000);

        country.selectByVisibleText("QATAR ");
        Thread.sleep(2000);

        country.selectByIndex(68);
        Thread.sleep(2000);

    }

    @Test
    public void multiSelect() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("file:///Users/nataliayatsishin/Desktop/Techtorialhtml.html");

        WebElement countryBox = driver.findElement(By.cssSelector(".select"));
        Select country = new Select(countryBox);
        country.selectByVisibleText("One");
        Thread.sleep(2000);
        country.selectByValue("3");
        Thread.sleep(2000);
        country.selectByIndex(4);
        Thread.sleep(2000);
        country.deselectByVisibleText("One");
        Thread.sleep(2000);
        country.deselectAll();


    }

    @Test
    public void validateOrderMessage(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();

        WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount']"));
        Select passengerCount = new Select(passenger);
        passengerCount.selectByVisibleText("4");

        WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select fromPortOption = new Select(fromPort);
        String actualFirstOption = fromPortOption.getFirstSelectedOption().getText().trim();
        String expectedFirstOption = "Acapulco";
        Assert.assertEquals(actualFirstOption, expectedFirstOption);
        fromPortOption.selectByValue("Paris");

        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        Select fromMonthOption = new Select(fromMonth);
        fromMonthOption.selectByValue("8");

        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        Select fromDayOption = new Select(fromDay);
        fromDayOption.selectByIndex(14);

        WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));
        Select toPortOption = new Select(toPort);
        toPortOption.selectByVisibleText("San Francisco");

        WebElement toMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        Select toMonthOption = new Select(toMonth);
        toMonthOption.selectByIndex(11);

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        Select toDayOption = new Select(toDay);
        fromDayOption.selectByVisibleText("15");

        WebElement serviceClass = driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();

        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlinesOptions = new Select(airlines);
        List<WebElement> actualAllAirlines = airlinesOptions.getOptions();
        List<String> expectedAllAirline = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i=0; i< actualAllAirlines.size(); i++) {
            Assert.assertEquals(actualAllAirlines.get(i).getText().trim(), expectedAllAirline.get(i).trim());
        }
        airlinesOptions.selectByIndex(2);

        WebElement continueBtn = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueBtn.click();

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        String actual = message.getText().trim();
        String expected = "After flight finder - No Seats Avaialable  ";
      //  Assert.assertEquals(actual,expected);

    }

    @Test

    public void shortCutsSelectClass(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://demo.guru99.com/test/newtours/reservation.php");

        WebElement oneWay = driver.findElement(By.xpath("//input[@value='oneway']"));
        oneWay.click();

        WebElement passenger = driver.findElement(By.xpath("//select[@name='passCount']"));
        BrowserUtils.selectBy(passenger,"3", "text");

        WebElement fromPort = driver.findElement(By.xpath("//select[@name='fromPort']"));
        Select fromPortOption = new Select(fromPort);
        String actualFirstOption = fromPortOption.getFirstSelectedOption().getText().trim();
        String expectedFirstOption = "Acapulco";
        Assert.assertEquals(actualFirstOption, expectedFirstOption);
        BrowserUtils.selectBy(fromPort,"Paris", "value");


        WebElement fromMonth = driver.findElement(By.xpath("//select[@name='fromMonth']"));
        BrowserUtils.selectBy(fromMonth,"8", "value");

        WebElement fromDay = driver.findElement(By.xpath("//select[@name='fromDay']"));
        BrowserUtils.selectBy(fromDay, "14", "index");

        WebElement toPort = driver.findElement(By.xpath("//select[@name='toPort']"));
        BrowserUtils.selectBy(toPort, "San Francisco", "text");

        WebElement toMonth = driver.findElement(By.xpath("//select[@name='toMonth']"));
        BrowserUtils.selectBy(toMonth, "11", "index");

        WebElement toDay = driver.findElement(By.xpath("//select[@name='toDay']"));
        BrowserUtils.selectBy(toDay,"15", "text");

        WebElement serviceClass = driver.findElement(By.xpath("//input[@value='First']"));
        serviceClass.click();

        WebElement airlines = driver.findElement(By.xpath("//select[@name='airline']"));
        Select airlinesOptions = new Select(airlines);
        List<WebElement> actualAllAirlines = airlinesOptions.getOptions();
        List<String> expectedAllAirline = Arrays.asList("No Preference", "Blue Skies Airlines", "Unified Airlines", "Pangea Airlines");
        for (int i=0; i< actualAllAirlines.size(); i++) {
            Assert.assertEquals(actualAllAirlines.get(i).getText().trim(), expectedAllAirline.get(i).trim());
        }
        airlinesOptions.selectByIndex(2);

        WebElement continueBtn = driver.findElement(By.xpath("//input[@name='findFlights']"));
        continueBtn.click();

        WebElement message = driver.findElement(By.xpath("//font[@size='4']"));
        String actual = BrowserUtils.getText(message);
        String expected = "After flight finder - No Seats Avaialable  ".trim();
        Assert.assertEquals(actual,expected);

    }



}
