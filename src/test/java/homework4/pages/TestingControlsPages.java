package homework4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class TestingControlsPages {

    public TestingControlsPages(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//select[@id='countriesSingle']")
    WebElement dropDownBox;

    @FindBy(xpath = "//select[@id='countriesMultiple']")
    WebElement multipleSelectBox;

    @FindBy(xpath = "//select[@id='countriesMultiple']//option[.='England']")
    WebElement englandMultipleBox;

    @FindBy(xpath = "//select[@id='countriesMultiple']//option[.='China']")
    WebElement chinaMultipleBox;

    @FindBy(xpath = "//div[@id='result']")
    WebElement displayedMessage;

    public void case1(String expectedSelectedByDefaultCountry, int sizeOfDropBox) {
        Select select = new Select(dropDownBox);
        Assert.assertEquals(select.getFirstSelectedOption().getText(), expectedSelectedByDefaultCountry);
        List<WebElement> actualAllCountries = select.getOptions();
        Assert.assertEquals(actualAllCountries.size(), sizeOfDropBox);
        List<String> expectedAllCountries = Arrays.asList("India", "United states of America", "China", "England");

        for (int i = 0; i < actualAllCountries.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(actualAllCountries.get(i)), expectedAllCountries.get(i));
        }

        BrowserUtils.selectBy(dropDownBox, "2", "index");
        BrowserUtils.selectBy(dropDownBox, "england", "value");
        BrowserUtils.selectBy(dropDownBox, "United states of America", "text");
    }

    public void case2() throws InterruptedException {
        Select select = new Select(multipleSelectBox);
        List<WebElement> allMultipleValues = select.getOptions();
        List<String> expectedAllCountries = Arrays.asList("India", "United states of America", "China", "England");
        for (int i = 0; i < allMultipleValues.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allMultipleValues.get(i)), expectedAllCountries.get(i));
        }

        BrowserUtils.selectBy(multipleSelectBox, "england", "value");
        BrowserUtils.selectBy(multipleSelectBox, "2", "index");
        Assert.assertTrue(displayedMessage.isDisplayed());
        select.deselectAll();

        for (WebElement value : allMultipleValues) {
            if (value.isDisplayed() && !value.isSelected()) {
                BrowserUtils.selectBy(multipleSelectBox, value.getAttribute("value"), "value");
            }
        }
        Assert.assertTrue(displayedMessage.isDisplayed());
        select.deselectByIndex(2);
        select.deselectByValue("england");


    }

}
