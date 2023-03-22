package SeleniumLocators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class XpathRealHealthProject {
    public static void main(String[] args) {
              /*
//THESE PARTS SHOULD BE DONE BY XPATH:
1-Navigate to the https://katalon-demo-cura.herokuapp.com/
2-Click Make an Appointment
3-Login the username and password provided and Login successfully
4-Choose the facility either HongKong or Seoul -->send keys
5-Click apply for hospital admission box if it is displayed and validate it is selected
6-Healthcare program 'Medicaid'
7-Visit date should be provided -->send keys
8-Put your command for this box -->send keys
9-Book your appointment
THESE PARTS SHOULD BE DONE BY CONTAINS or . XPATH METHOD
10-Validate the header is "Appointment confirmation" (if statement)
11-Print out the headers and values(only values) on your console.
12)Click go to homepage and print out url
13)Driver.quit or close.
               */

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.navigate().to("https://katalon-demo-cura.herokuapp.com/");

        WebElement makeAppointment = driver.findElement(By.xpath("//a[@id='btn-make-appointment']"));
        makeAppointment.click();

        WebElement userName = driver.findElement(By.xpath("//input[@id='txt-username']"));
        userName.sendKeys("John Doe");

        WebElement password = driver.findElement(By.xpath("//input[@id='txt-password']"));
        password.sendKeys("ThisIsNotAPassword");

        WebElement loginButton = driver.findElement(By.xpath("//button[@id='btn-login']"));
        loginButton.click();

        WebElement facility = driver.findElement(By.xpath("//select[@id='combo_facility']"));
        facility.sendKeys("Seoul CURA Healthcare Center");

        WebElement checkbox = driver.findElement(By.xpath("//input[@id='chk_hospotal_readmission']"));
        if (checkbox.isDisplayed() && !checkbox.isSelected()) {
            checkbox.click();
        }

        WebElement healtProgram = driver.findElement(By.xpath("//input[@id='radio_program_medicaid']"));
        if (healtProgram.isDisplayed() && !healtProgram.isSelected()) {
            healtProgram.click();
        }

        WebElement date = driver.findElement(By.xpath("//input[@id='txt_visit_date']"));
        date.sendKeys("03/10/2023");

        WebElement comment = driver.findElement(By.xpath("//textarea[@id='txt_comment']"));
        comment.sendKeys("Hello");

        WebElement bookAppointment = driver.findElement(By.xpath("//button[@id='btn-book-appointment']"));
        bookAppointment.click();


        WebElement header = driver.findElement(By.xpath("//h2[.='Appointment Confirmation']"));
        String actualHeader = header.getText().trim();
        String expectedHeader = "Appointment Confirmation";

        System.out.println(actualHeader.equals(expectedHeader) ? "passed" : "failed");

        WebElement h1 = driver.findElement(By.xpath("//p[contains(text(), 'Seoul')]"));
        System.out.println(h1.getText().trim());

        WebElement h2 = driver.findElement(By.xpath("//p[contains(text(), 'Yes')]"));
        System.out.println(h2.getText().trim());

        WebElement h3 = driver.findElement(By.xpath("//p[contains(text(), 'Me')]"));
        System.out.println(h3.getText().trim());

        WebElement h4 = driver.findElement(By.xpath("//p[contains(text(), '/')]"));
        System.out.println(h4.getText().trim());

        WebElement homePage = driver.findElement(By.linkText("Go to Homepage"));
        homePage.click();

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://katalon-demo-cura.herokuapp.com/";
        System.out.println(actualUrl.equals(expectedUrl) ? "URL passed" : "URL failed");

        driver.close();

        //COMMAND+OPTION+L


    }
}
