package com.ultimateqa.courses.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.courses.customlisteners.CustomListeners;
import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class LoginPage extends Utility {
    @CacheLookup
    @FindBy(id = "user[email]")
    WebElement userNameField;
    @CacheLookup
    @FindBy(id = "user[password]")
    WebElement passwordField;
    @CacheLookup
    @FindBy(xpath = "//button[contains(text(),'Sign in')]")
    WebElement loginButton;
    @CacheLookup
    @FindBy(xpath = "//li[contains(text(),'Invalid email or password.')]")
    WebElement errorMessage;

    public void enterUsername(String userName) {
        Reporter.log("enterUsername" + userNameField.toString());
        sendTextToElement(userNameField, userName);
        CustomListeners.test.log(Status.PASS,"enterUsername");
    }

    public void enterPassword(String password) {
        Reporter.log("enterPassword" + passwordField.toString());
        sendTextToElement(passwordField, password);
        CustomListeners.test.log(Status.PASS,"enterPassword");
    }

    public void clickOnLoginButton() {
        Reporter.log("clickOnLoginButton" + loginButton.toString());
        clickOnElement(loginButton);
        CustomListeners.test.log(Status.PASS,"clickOnLoginButton");
    }

    public String getErrorMessage() {
        Reporter.log("getErrorMessage" + errorMessage.toString());
        CustomListeners.test.log(Status.PASS,"getErrorMessage");
        return getTextFromElement(errorMessage);
    }
}
