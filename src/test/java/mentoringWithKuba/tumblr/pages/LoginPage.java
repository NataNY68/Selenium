package mentoringWithKuba.tumblr.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@aria-label='Continue with email']")
    WebElement continueWithEmail;

    @FindBy(xpath = "//input[@type='email']")
    WebElement emailField;

    @FindBy (xpath = "//div[@class='Kz53t']//button[@aria-label='Next']")
    WebElement nextButton;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement passwordField;

    @FindBy(xpath = "//button[@aria-label='Log in']")
    WebElement loginButton;

    @FindBy(xpath = "//div[@class='a0A37 hAkP2']")//a0A37 hAkP2
    WebElement errorMessage;

    public void loginFunctionality(String emailValue, String passwordValue, String errorMsg) throws InterruptedException {
        continueWithEmail.click();
        Thread.sleep(1000);
        emailField.sendKeys(emailValue);
        nextButton.click();
        Thread.sleep(1000);
        passwordField.sendKeys(passwordValue);
        loginButton.click();
        Thread.sleep(2000);
        //System.out.println(BrowserUtils.getText(errorMessage));
        Assert.assertEquals(BrowserUtils.getText(errorMessage), errorMsg);
    }
}
