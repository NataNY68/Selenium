package MentoringWithAhmet.Bank.tests;

import MentoringWithAhmet.Bank.pages.CustomerPage;
import MentoringWithAhmet.Bank.pages.LogInCustomer;
import org.testng.annotations.Test;

public class CustomerTest extends BankTestBase {

    @Test
    public void chooseCustomer()throws InterruptedException{
        LogInCustomer logInCustomer = new LogInCustomer(driver);
        logInCustomer.loginCustomer();
        CustomerPage customerPage = new CustomerPage(driver);
        customerPage.selectCustomer("Harry Potter","Welcome Harry Potter !!", "Deposit Successful",
                "Transaction successful");
    }
}
