package com.test.etsy.tests;

import com.test.etsy.pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class MainTestEtsy extends TestBaseEtsy {

    @Parameters({"searchItem", "phoneBrand", "model", "item"})
    @Test
    public void mainPageFunc(String searchItem, String phoneBrand, String model, String item)  {
        MainPage mainPage = new MainPage(driver);
        mainPage.searchData(searchItem);
        mainPage.validateHeaders(phoneBrand, model, item);
    }
}
