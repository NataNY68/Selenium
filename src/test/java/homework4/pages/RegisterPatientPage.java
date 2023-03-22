package homework4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.Arrays;
import java.util.List;

public class RegisterPatientPage {

    public RegisterPatientPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@id='apps']//a[3]")
    WebElement registerPatient;

    @FindBy(xpath = "//input[@name='givenName']")
    WebElement givenName;

    @FindBy(xpath = "//input[@name='familyName']")
    WebElement familyName;

    @FindBy(xpath = "//span[@id='genderLabel']")
    WebElement gender;

    @FindBy(xpath = "//select[@id='gender-field']")
    WebElement genderField;

    @FindBy(xpath = "//span[@id='birthdateLabel']")
    WebElement birthDate;

    @FindBy(xpath = "//input[@id='birthdateDay-field']")
    WebElement day;

    @FindBy(xpath = "//select[@name='birthdateMonth']")
    WebElement month;

    @FindBy(xpath = "//input[@name='birthdateYear']")
    WebElement year;

    @FindBy(xpath = "//span[.='Address']")
    WebElement address;

    @FindBy(xpath = "//input[@id='address1']")
    WebElement addressField;

    @FindBy(xpath = "//input[@id='cityVillage']")
    WebElement city;

    @FindBy(xpath = "//input[@id='stateProvince']")
    WebElement state;

    @FindBy(xpath = "//input[@id='country']")
    WebElement county;

    @FindBy(xpath = "//input[@id='postalCode']")
    WebElement postalCode;

    @FindBy(xpath = "//span[.='Phone Number']")
    WebElement phone;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    WebElement phoneField;

    @FindBy(xpath = "/html/body/div/div[3]/div[2]/form/div/div[2]/div/p/text()")
    List<WebElement> allInfo;

    @FindBy(css = "#confirmation_label")
    WebElement confirmButton;

    @FindBy(css = "#submit")
    WebElement confirmSubmissionButton;

    @FindBy(xpath = "//i[@class='icon-chevron-right link']//following-sibling::text()")
    WebElement patientInfoAfterRegistration;

    @FindBy(xpath = "//body//div[@class='toast-container toast-position-top-right']")
    WebElement confirmMessagePatientIsCreated;


    public void RegisterPatient(String givenName, String familyName, String day ,String year, String address,
                                String city, String state, String county, String postalCode, String phoneNumber) {
        registerPatient.click();
        this.givenName.sendKeys(givenName);
        this.familyName.sendKeys(familyName);
        gender.click();
        BrowserUtils.selectBy(genderField, "F", "value");
        birthDate.click();
        this.day.sendKeys(day);
        BrowserUtils.selectBy(month, "9", "value");
        this.year.sendKeys(year);
        this.address.click();
        addressField.sendKeys(address);
        this.city.sendKeys(city);
        this.state.sendKeys(state);
        this.county.sendKeys(county);
        this.postalCode.sendKeys(postalCode);
        phone.click();
        phoneField.sendKeys(phoneNumber);
        List<String> expectedInfo = Arrays.asList("Nataliia, Yatsyshyn", "Female",
                "09, September, 1996", "2200 E Devon ave, Des Plains, IL, Cook, 60018",
                "1234567890");
        for (int i = 0; i < allInfo.size(); i++) {
            Assert.assertEquals(BrowserUtils.getText(allInfo.get(i)), expectedInfo.get(i));
        }
        confirmButton.click();
        confirmSubmissionButton.click();
        System.out.println(BrowserUtils.getText(confirmMessagePatientIsCreated));
    }

    public void validatePatientIsCreated(String expMessage){
        Assert.assertEquals(BrowserUtils.getText(confirmMessagePatientIsCreated), expMessage);
        //System.out.println(BrowserUtils.getText(patientInfoAfterRegistration));
    }


}
