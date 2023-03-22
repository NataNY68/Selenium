package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class OrderPage {
    public OrderPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//input[@id='name']")
    WebElement nameBox;

    @FindBy(css = "#country")
    WebElement countryBox;

    @FindBy(css = "#city")
    WebElement cityBox;

    @FindBy(css = "#card")
    WebElement cardBox;

    @FindBy(css = "#month")
    WebElement monthBox;

    @FindBy(css = "#year")
    WebElement yearBox;

    @FindBy (xpath = "//button[@onclick='purchaseOrder()']")
    WebElement purchaseButton;

    @FindBy(xpath = "//h2[contains(text(), 'Thank')]")
    WebElement message;

    @FindBy(xpath = "//button[.='OK']")
    WebElement okButton;



    public void validatePurchaseInformation(String name, String country, String city,
                                            String creditCard, String month, String year) {
        nameBox.sendKeys(name);
        countryBox.sendKeys(country);
        cityBox.sendKeys(city);
        cardBox.sendKeys(creditCard);
        monthBox.sendKeys(month);
        yearBox.sendKeys(year);
        purchaseButton.click();
    }

    public void validateMessageAfterPurchase(String expectedMessage) throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(message), expectedMessage);
        purchaseButton.click();
        okButton.click();
    }


    public void validateUrl(WebDriver driver, String expectedUrl){
        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
}
