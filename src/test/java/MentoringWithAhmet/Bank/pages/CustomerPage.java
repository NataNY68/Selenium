package MentoringWithAhmet.Bank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utils.BrowserUtils;

public class CustomerPage {

    public CustomerPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#userSelect")
    WebElement allOptions;

    @FindBy (xpath = "//button[@type='submit']")
    WebElement loginButton;

    @FindBy(xpath = "//strong[contains(text(), 'We')]")
    WebElement welcomeCustomerText;

    @FindBy (xpath = "//button[@ng-click='deposit()']")
    WebElement depositButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement depositAmount;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement depositSubmitButton;

    @FindBy(xpath = "//span[.='Deposit Successful']")
    WebElement depositSuccessfulMessage;

    @FindBy(xpath = "//button[@ng-click='withdrawl()']")
    WebElement withdrawButton;

    @FindBy(xpath = "//input[@placeholder='amount']")
    WebElement withdrawAmount;

    @FindBy(xpath = "//button[.='Withdraw']")
    WebElement withdrawSubmitButton;

    @FindBy(xpath = "//span[.='Transaction successful']")
    WebElement withdrawMessage;

    @FindBy(xpath = "//button[@ng-click='transactions()']")
    WebElement transactionButton;

    @FindBy(xpath = "/html/body/div/div/div[2]/div/div[2]/strong[2]")
    WebElement balance;

    @FindBy(xpath = "//tbody//tr[1]//td[2]")
    WebElement depositCheck;

    @FindBy(xpath = "//tbody//tr[2]//td[2]")
    WebElement withdrawCheck;

    @FindBy(xpath = "//button[@ng-click='back()']")
    WebElement backButton;


    public void selectCustomer(String name,String expectedWelcomeCustomer, String expectedDepositMessage,
                               String expectedWithdrawMessage) throws InterruptedException {
        BrowserUtils.selectBy(allOptions, name, "text");
        loginButton.click();
        Assert.assertEquals(BrowserUtils.getText(welcomeCustomerText),expectedWelcomeCustomer);
        depositButton.click();
        Thread.sleep(1000);
        depositAmount.sendKeys("500");
        depositSubmitButton.click();
        Assert.assertEquals(BrowserUtils.getText(depositSuccessfulMessage), expectedDepositMessage);
        withdrawButton.click();
        Thread.sleep(1000);
        withdrawAmount.sendKeys("300");
        withdrawSubmitButton.click();
        Thread.sleep(1000);
        Assert.assertEquals(BrowserUtils.getText(withdrawMessage),expectedWithdrawMessage );
        transactionButton.click();
        Integer depositInteger = Integer.parseInt(BrowserUtils.getText(depositCheck));
        Integer withdrawInteger = Integer.parseInt(BrowserUtils.getText(withdrawCheck));
        backButton.click();
        Integer balanceInteger = Integer.parseInt(BrowserUtils.getText(balance));
        Assert.assertEquals(depositInteger-withdrawInteger,balanceInteger );

    }
}
