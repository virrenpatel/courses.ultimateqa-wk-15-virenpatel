package com.ultimateqa.courses.testsuite;

import com.ultimateqa.courses.customlisteners.CustomListeners;
import com.ultimateqa.courses.pages.HomePage;
import com.ultimateqa.courses.pages.LoginPage;
import com.ultimateqa.courses.testbase.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(CustomListeners.class)
public class LoginPageTest extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod(alwaysRun = true)
    public void inIt(){
        loginPage = new LoginPage();
        homePage = new HomePage();
    }

    @Test(groups = {"sanity","regression"})
    public void userShouldNavigateToLoginPageSuccessfully() {
        homePage.clickOnSignInLink();
        String expectedMessage = "Welcome Back!";
        String actualMessage = homePage.getTextWelcomeBack();
        Assert.assertEquals(expectedMessage, actualMessage, "Login page not displayed");

    }

    @Test(groups = {"smoke","regression"})
    public void verifyErrorMessageWithInvalidCredentials() {
        homePage.clickOnSignInLink();
        loginPage.enterUsername("123test@gmail.com");
        loginPage.enterPassword("123456");
        loginPage.clickOnLoginButton();
        String expectedErrorMessage = "Invalid email or password.";
        String actualErrorMessage = loginPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage, "Error message not displayed");
    }
}
