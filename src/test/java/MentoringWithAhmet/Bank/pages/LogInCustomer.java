package MentoringWithAhmet.Bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInCustomer {

    public LogInCustomer(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@ng-click='customer()']")
    WebElement customerLoginButton;

    public void loginCustomer(){
        customerLoginButton.click();
    }
}
