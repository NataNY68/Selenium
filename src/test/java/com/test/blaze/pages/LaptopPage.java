package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.BrowserUtils;

import java.util.List;

public class LaptopPage {

    public LaptopPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//h4//a")
    List <WebElement> allLaptops;

    public void validateAllLaptops(String searchBrand) throws InterruptedException {
        Thread.sleep(500);
        for (int i = 0; i < allLaptops.size(); i++) {
            if (BrowserUtils.getText(allLaptops.get(i)).contains(searchBrand)) {
                allLaptops.get(i).click();
                break;
            }
        }
    }
}
