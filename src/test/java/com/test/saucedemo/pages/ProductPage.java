package com.test.saucedemo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class ProductPage {

    public ProductPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='inventory_item_label']//a")
    List<WebElement> allLinks;

    @FindBy(xpath = "//div[@class='inventory_details_desc large_size']")
    WebElement productDesc;

    @FindBy(xpath = "//div[@class='inventory_details_price']")
    WebElement price;

    public void linksFunctionality(String productName, String productKeyWord, String priceProduct) throws InterruptedException {
        //Thread.sleep(1000);
        for (WebElement link: allLinks) {
            if(BrowserUtils.getText(link).equals(productName)){
                link.click();
                Assert.assertTrue(BrowserUtils.getText(productDesc).contains(productKeyWord) );
                Assert.assertEquals(BrowserUtils.getText(price), priceProduct);
                break;
            }
        }
    }
}
