package com.test.blaze.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

    public MainPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[.='Laptops']")
    WebElement laptopsButton;

    @FindBy(id="cartur")
    WebElement cartButton;

    public void clickLaptopButton(){
        laptopsButton.click();
    }

    public void clickCartButton(){
        cartButton.click();
    }
}
