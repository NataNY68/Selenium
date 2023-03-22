package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class CartPage {
    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Cart")
    WebElement cartButton;

    @FindBy(xpath = "//tr[@class='success']//td")
    List<WebElement> productInformation;

    @FindBy(xpath = "//button[@class='btn btn-success']")
    WebElement placeOrderButton;

    public void clickCartButton(String productName, String productPrice) {
        cartButton.click();
        List<String> expectedProductInformation = Arrays.asList("", productName, productPrice);
        for (int i = 1; i < productInformation.size() - 1; i++) {
            Assert.assertEquals(BrowserUtils.getText(productInformation.get(i)), expectedProductInformation.get(i));
        }
    }

    public void clickPlaceOrderButton(){
        placeOrderButton.click();
    }








}
