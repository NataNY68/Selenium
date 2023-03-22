package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class CartPage {

    public CartPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Add to cart')]")
    WebElement addToCartButton;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    WebElement shoppingCart;

    @FindBy(xpath = "//button[@name='checkout']")
    WebElement checkOutButton;

    @FindBy(name = "firstName")
    WebElement name;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(css = "#postal-code")
    WebElement zipCode;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement continueButton;

    @FindBy(css = "#finish")
    WebElement finishButton;

    @FindBy(tagName = "h2")
    WebElement orderMessage;

    @FindBy(xpath = "//div[@class='inventory_item_label']//a")
    List<WebElement> allLinks;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement price;

    @FindBy(xpath = "//div[@class='inventory_details_name large_size']")
    WebElement header;

    public void addToCart(String productName, String priceProduct, String name, String lastName,
                          String zipCode, String expOrderMessage) throws InterruptedException {
        for (WebElement link: allLinks) {
            if(BrowserUtils.getText(link).equals(productName)){
                link.click();
                Assert.assertEquals(BrowserUtils.getText(header), productName);
                Assert.assertEquals(BrowserUtils.getText(price), priceProduct);
                addToCartButton.click();
                shoppingCart.click();
                checkOutButton.click();
                this.name.sendKeys(name);
                this.lastName.sendKeys(lastName);
                this.zipCode.sendKeys(zipCode);
                continueButton.click();
                finishButton.click();
                Assert.assertEquals(BrowserUtils.getText(orderMessage), expOrderMessage);
                break;
            }
        }


    }

}
