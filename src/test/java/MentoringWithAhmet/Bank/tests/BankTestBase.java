package MentoringWithAhmet.Bank.tests;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.BrowserUtils;
import utils.DriverHelper;

public class BankTestBase {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverHelper.getDriver();
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login");
    }

    @AfterMethod
    public void tearDown(ITestResult iTestResult) throws InterruptedException {
        if(!iTestResult.isSuccess()){
            Thread.sleep(2000);
            BrowserUtils.getScreenShot(driver,"Bank");
        }
        driver.quit();
    }

}
