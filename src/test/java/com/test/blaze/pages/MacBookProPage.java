package com.test.blaze.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import utils.BrowserUtils;

public class MacBookProPage {

    public  MacBookProPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//h2[.='MacBook Pro']")
    WebElement macBookProHeader;

    @FindBy(tagName = "h3")
    WebElement price;

    @FindBy(xpath = "//div[@id='more-information']")
    WebElement productDescription;

    @FindBy(xpath = "//a[@onclick='addToCart(15)']")
    WebElement addToCartButton;

    public void productInformationValidation(WebDriver driver, String laptopHeader, String laptopPrice,
                                             String laptopDescription) throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(macBookProHeader), laptopHeader);
        Assert.assertEquals(BrowserUtils.getText(price), laptopPrice);
        Assert.assertTrue(BrowserUtils.getText(productDescription).contains(laptopDescription));
    }

    public void clickAddToCartButton(WebDriver driver, String expectedMessage) throws InterruptedException {
        addToCartButton.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        //Assert.assertEquals(alert.getText(), "Product added");
        alert.accept();
    }


}
