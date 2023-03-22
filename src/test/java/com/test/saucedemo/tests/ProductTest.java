package com.test.saucedemo.tests;

import com.test.saucedemo.pages.ProductPage;
import com.test.saucedemo.pages.SauceLoginPage;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class ProductTest extends SauceTestBase{

    @Test(dataProvider = "productInfo", dataProviderClass = AllData.class)
    public void validateAllProductLinksAreWorking(String productName, String productKeyWord, String priceProduct) throws InterruptedException {
        SauceLoginPage sauceLoginPage = new SauceLoginPage(driver);
        sauceLoginPage.loginPositive(ConfigReader.readProperty("QA_username"),
                ConfigReader.readProperty("QA_password"));
        ProductPage productPage = new ProductPage(driver);
        productPage.linksFunctionality(productName,productKeyWord, priceProduct);

    }
}
