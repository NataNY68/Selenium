package com.test.etsy.pages;

import com.beust.ah.A;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.List;

public class MainPage {

    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@data-id='search-query']")
    WebElement searchField;

    @FindBy(xpath = "//div[@data-search-results]//h3")
    List<WebElement> allHeaders;

    public void searchData(String searchItem) {
        searchField.sendKeys(searchItem, Keys.ENTER);
    }

    public void validateHeaders(String phoneBrand, String model, String item)  {
        for (WebElement header : allHeaders) {
            String word = BrowserUtils.getText(header).toLowerCase();
            Assert.assertTrue(word.contains(phoneBrand)  || word.contains(model) || word.contains(item));
        }

    }
}
