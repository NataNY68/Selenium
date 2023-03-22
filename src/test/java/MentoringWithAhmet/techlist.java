package MentoringWithAhmet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class techlist {

    /*
    1-Open this link - https://www.techlistic.com/p/selenium-practice-form.html
2-Enter first and last name (textbox).
3-Select gender (radio button).
4-Select years of experience (radio button).
5-Enter date.(send keys)
6-Select Profession (Checkbox).
7-Select Automation tools you are familiar with (multiple checkboxes).
8-Select Continent(Send Keys).
9-Click on Submit button.
10-Close the webpage
Try your own logic and automate it without any help.
     */
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.techlistic.com/p/selenium-practice-form.html");

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Nataliia");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Yatsyshyn");

        WebElement gender = driver.findElement(By.id("sex-1"));
        if (gender.isDisplayed() && !gender.isSelected()) {
            gender.click();
        }

        WebElement experience = driver.findElement(By.id("exp-4"));
        if(experience.isDisplayed()  && !experience.isSelected()){
            experience.click();
        }

        WebElement date = driver.findElement(By.id("datepicker"));
        date.sendKeys("02/14/2023");

        WebElement profession = driver.findElement(By.id("profession-0"));
        if (profession.isDisplayed() && !profession.isSelected()){
            profession.click();
        }

        WebElement profession1 = driver.findElement(By.id("profession-1"));
        if (profession1.isDisplayed() && !profession1.isSelected()){
            profession1.click();
        }

        WebElement tool = driver.findElement(By.id("tool-2"));
        if (tool.isDisplayed() && !tool.isSelected()){
            tool.click();
        }

        WebElement continent = driver.findElement(By.id("continents"));
        continent.sendKeys("Europe");

        WebElement button = driver.findElement(By.className("btn-info "));
        button.click();

        //driver.close();


    }
}
