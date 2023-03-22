package homework4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@id='username']")
    WebElement username;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//li[.='Laboratory']")
    WebElement laboratory;

    @FindBy(css = "#loginButton")
    WebElement loginButton;



    public void loginFunctionality(String username, String password){
        this.username.sendKeys(username);
        this.password.sendKeys(password);
        laboratory.click();
        loginButton.click();
    }
}
