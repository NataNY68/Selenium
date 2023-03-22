package com.test.saucedemo.tests;

import com.test.saucedemo.pages.CartPage;
import com.test.saucedemo.pages.SauceLoginPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class CartTest extends SauceTestBase {

    @Test(dataProvider="order", dataProviderClass = AllData.class)
    public void validateOrderFunctionality(String productName, String priceProduct, String name, String lastName,
                                           String zipCode, String expOrderMessage) throws InterruptedException {
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.loginPositive(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"));
        CartPage cartPage=new CartPage(driver);
        cartPage.addToCart(productName,priceProduct,name,lastName,
                zipCode,expOrderMessage);
    }
}
