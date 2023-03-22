package mentoringWithKuba.tumblr.tests;

import mentoringWithKuba.tumblr.pages.LoginPage;
import mentoringWithKuba.tumblr.pages.MainPage;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TumblrScript extends TestBase{

    @Parameters({"email", "password", "errorMessage"})
    @Test
    public void validateLoginFunctionality(String email, String password, String errorMsg)
            throws InterruptedException{

        MainPage mainPage = new MainPage(driver);
        mainPage.login();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginFunctionality(email, password, errorMsg);
    }

}
