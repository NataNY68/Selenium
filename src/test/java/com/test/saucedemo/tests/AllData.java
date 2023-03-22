package com.test.saucedemo.tests;

import org.testng.annotations.DataProvider;

public class AllData {
    @DataProvider(name = "negativeLogin")
    public Object[][] getUserInfo(){
        return new Object[][]{
                {"standard_user", "","Epic sadface: Password is required"},
                {"","secret_sauce", "Epic sadface: Username is required"},
                {"abc", "123", "Epic sadface: Username and password do not match any user in this service"}
        };
    }

    @DataProvider(name="productInfo")
    public Object[][] getProductInfo() {
        return new Object[][]{
                {"Sauce Labs Backpack", "carry.allTheThings()", "$29.99"},
                {"Sauce Labs Bike Light", "Water-resistant with 3 lighting modes", "$9.99"},
                {"Sauce Labs Bolt T-Shirt", "American Apparel, 100% ringspun combed cotton,", "$15.99"},
                {"Sauce Labs Fleece Jacket", "quarter-zip fleece jacket", "$49.99"},
                {"Sauce Labs Onesie", "Rib snap infant onesie for the junior", "$7.99"},
                {"Test.allTheThings() T-Shirt (Red)", "Super-soft and comfy ringspun combed cotton.", "$15.99"}
        };
    }

    @DataProvider(name="order")
    public Object[][] orderFunctionality(){
        return new Object[][]{
                {"Sauce Labs Backpack", "$29.99", "Nataliia", "Johns", "12345", "Thank you for your order!"},
                {"Sauce Labs Bike Light", "$9.99", "Nataliia", "Johns", "12345", "Thank you for your order!"},
                {"Sauce Labs Bolt T-Shirt", "$15.99", "Nataliia", "Johns", "12345", "Thank you for your order!"},
                {"Sauce Labs Fleece Jacket", "$49.99", "Nataliia", "Johns", "12345", "Thank you for your order!"},
                {"Sauce Labs Onesie", "$7.99", "Nataliia", "Johns", "12345", "Thank you for your order!"},
                {"Test.allTheThings() T-Shirt (Red)", "$15.99", "Nataliia", "Johns", "12345", "Thank you for your order!"}
        };
    }
}
