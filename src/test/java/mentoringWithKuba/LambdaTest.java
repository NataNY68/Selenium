package mentoringWithKuba;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LambdaTest {
@Test
  public void  ValidateEmailAndName() throws InterruptedException {
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.navigate().to("https://www.lambdatest.com/selenium-playground/");

    WebElement clickOnTubPgnBtn = driver.findElement(By.xpath("//a[.='Table Pagination']"));
    clickOnTubPgnBtn.click();

    WebElement selectMyRows = driver.findElement(By.cssSelector("#maxRows"));
    BrowserUtils.selectBy(selectMyRows, "Show ALL Rows", "text");

    //we are storing our data in a list
    Thread.sleep(2000);
    List<WebElement> allNames = driver.findElements(By.xpath("//tr//td[2]"));
    List<WebElement> allEmails = driver.findElements(By.xpath("//tr//td[3]"));
    List<WebElement> allNumbers = driver.findElements(By.xpath("//tr//td[4]"));

    for (int i = 0; i < allNames.size(); i++) {
        Map<String, String> map = new HashMap<>();
        map.put(allNames.get(i).getText(), allEmails.get(i).getText());
        System.out.println(map);
    }

  for (int i = 0; i < allNumbers.size(); i++) {
    String changedNumber = "";
    Map<String, Long> map = new HashMap<>();
    for (int j=0; j<allNumbers.get(i).getText().length(); j++){
      if(Character.isDigit(allNumbers.get(i).getText().charAt(j))){
        changedNumber+=allNumbers.get(i).getText().charAt(j);
      }
    }
    Long integer = Long.valueOf(changedNumber);
    map.put(allNames.get(i).getText(), integer);
    System.out.println(map);

  }


}
}
