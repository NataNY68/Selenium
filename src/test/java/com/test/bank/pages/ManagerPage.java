package com.test.bank.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class ManagerPage {

    public  ManagerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[@ng-click='addCust()']")
    WebElement addCustomer;

    @FindBy(xpath = "//input[@placeholder='First Name']")
    WebElement firstName;

    @FindBy(xpath = "//input[@placeholder='Last Name']")
    WebElement lastName;

    @FindBy(xpath = "//input[@placeholder='Post Code']")
    WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement submitBtn;

    @FindBy (xpath = "//button[@ng-click='openAccount()']")
    WebElement openAccount;

    @FindBy(xpath = "//select[@name='userSelect']")
    WebElement customerOptions;

    @FindBy(css = "#currency")
    WebElement currencyBtn;

    @FindBy (xpath = "//button[@ng-click='showCust()']")
    WebElement customersBtn;

    @FindBy(tagName = "input")
    WebElement searchBox;

    @FindBy(xpath = "//tr//td[@class]")
    List<WebElement> allInformation;

    @FindBy(xpath = "//tr//button[@ng-click='deleteCust(cust)']")
    WebElement deleteButton;

    public void addCustomer(WebDriver driver,String firstName, String  lastName, String postCode, String message){
        addCustomer.click();
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.postCode.sendKeys(postCode);
        submitBtn.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(message));
        alert.accept();
    }

    public void openAccount(WebDriver driver, String firstAndLastName, String currencyDollar, String message){
        openAccount.click();
        BrowserUtils.selectBy(customerOptions, firstAndLastName, "text");
        BrowserUtils.selectBy(currencyBtn, currencyDollar, "text");
        submitBtn.click();
        Alert alert = driver.switchTo().alert();
        Assert.assertTrue(alert.getText().contains(message));
        alert.accept();
    }

    public void customerValidation(String firstName, String lastName, String postCode) throws InterruptedException {
        customersBtn.click();
        Thread.sleep(3000);

        searchBox.sendKeys(firstName, Keys.ENTER);

        List<String > expectedInfo = Arrays.asList(firstName, lastName, postCode);
        for (int i = 0; i < allInformation.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInformation.get(i)), expectedInfo.get(i));
        }
        deleteButton.click();
    }
}
