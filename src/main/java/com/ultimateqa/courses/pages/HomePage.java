package com.ultimateqa.courses.pages;

import com.aventstack.extentreports.Status;
import com.ultimateqa.courses.customlisteners.CustomListeners;
import com.ultimateqa.courses.utility.Utility;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.testng.Reporter;

public class HomePage extends Utility {
    @CacheLookup
    @FindBy(xpath = "//a[contains(text(),'Sign In')]")
    WebElement signInLink;
    @CacheLookup
    @FindBy(xpath = "//h2[contains(text(),'Welcome Back!')]")
    WebElement textWelcomeBack;

    public void clickOnSignInLink(){
        Reporter.log("clickOnSignInLink" + signInLink.toString());
        clickOnElement(signInLink);
        CustomListeners.test.log(Status.PASS,"clickOnSignInLink");
    }

    public String getTextWelcomeBack() {
        Reporter.log("getTextWelcomeBack" + textWelcomeBack.toString());
        CustomListeners.test.log(Status.PASS, "getTextWelcomeBack");
        return getTextFromElement(textWelcomeBack);
    }

}
