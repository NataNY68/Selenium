package MentoringWithAhmet.Bank.tests;

import MentoringWithAhmet.Bank.pages.LogInCustomer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LogInCustomerTest extends BankTestBase{

    @Test
    public void customerLogin(){
        LogInCustomer logInCustomer = new LogInCustomer(driver);
        logInCustomer.loginCustomer();
    }


}
