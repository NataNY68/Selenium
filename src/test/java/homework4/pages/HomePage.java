package homework4.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

import java.util.ArrayList;
import java.util.List;

public class HomePage {

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[@id='selected-location']")
    WebElement location;

    @FindBy(tagName = "h4")
    WebElement header;

    @FindBy(xpath = "//li[@locationname='Pharmacy']")
    WebElement pharmacy;

    @FindBy(css = ".logo")
    WebElement logo;

    @FindBy(xpath = "//div[@id='apps']//a[1]")
    WebElement findPatientRecord;

    @FindBy(xpath = "//input[@id='patient-search']")
    WebElement findPatientField;

    @FindBy(xpath = "//tr[1]//td[1]")  //tr[@class='odd']//td[.='John Johns']//preceding::td
    WebElement firstID;

    @FindBy(xpath = "/tr[@class='odd']//td[.='John Johns']//preceding::td")
    WebElement aaaa;

    @FindBy(xpath = "//tbody[@role='alert']//td[1]")
    List<WebElement> allIdentifier;

    @FindBy(xpath = "//tr[@class='odd']")
    WebElement searchPatient;

    @FindBy(xpath = "//tbody[@role='alert']//td[2]")
    List<WebElement> allPatientName;

    @FindBy(linkText = "Delete Patient")
    WebElement deletePatientButton;

    @FindBy(xpath = "//div[@id='simplemodal-container']//button[1]")
    WebElement confirmButton;

    @FindBy(xpath = "//h6")
    WebElement deleteMessage;

    @FindBy(css = "#delete-reason")
    WebElement deleteReasonField;

    @FindBy(xpath = "//body//div[@class='toast-container toast-position-top-right']")
    WebElement deleteConfirmationMessage;

    public void locationValidation(String expectedLocation, String expectedHeader, String newExpectedHeader)
            throws InterruptedException {
        Assert.assertEquals(BrowserUtils.getText(location), expectedLocation);
        Assert.assertEquals(BrowserUtils.getText(header), expectedHeader);
        location.click();
        pharmacy.click();
        Thread.sleep(1000);
        logo.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(header), newExpectedHeader);
    }

    public void findPatientRecord(String patientName) throws InterruptedException {
        findPatientRecord.click();
        Thread.sleep(1000);
        findPatientField.sendKeys(patientName, Keys.ENTER);

    }

    public void validateIDIsUnique(String patientName) throws InterruptedException {
        int counter = 0;
        Thread.sleep(1000);

        for (int i = 0; i < allPatientName.size(); i++)
            if (BrowserUtils.getText(allPatientName.get(i)).equals(patientName)) {
                for (int j = 0; j < allIdentifier.size(); j++) {
                    if (BrowserUtils.getText(allIdentifier.get(j)).equals(BrowserUtils.getText(allIdentifier.get(i)))) {
                        counter++;
                    }
                }
            }
        Assert.assertEquals(counter, 1);
    }

    public void validatePatientIsCreated(String patientName) throws InterruptedException {
        findPatientRecord.click();
        //Thread.sleep(1000);
        //findPatientField.sendKeys(patientName);
        Thread.sleep(1000);
        for (WebElement eachName : allPatientName) {
            if (BrowserUtils.getText(eachName).equals(patientName)) {
            }
        }
        aaaa.click();
        //searchPatient.click();
    }


    public void deletePatient(String patientName, String expDeleteMessage, String reasonToDelete,
                              String expDeleteConfirmMessage) throws InterruptedException {

//        findPatientRecord.click();
//        Thread.sleep(1000);
//        findPatientField.sendKeys(patientName);
        Thread.sleep(1000);

        searchPatient.click();
        Thread.sleep(1000);
        deletePatientButton.click();
        Thread.sleep(1000);
        confirmButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(deleteMessage), expDeleteMessage);
        deleteReasonField.sendKeys(reasonToDelete);
        confirmButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(deleteConfirmationMessage), expDeleteConfirmMessage);


    }

}
