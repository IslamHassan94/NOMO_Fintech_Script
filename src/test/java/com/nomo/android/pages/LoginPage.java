package com.nomo.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends AbstractPage {

    // Locators for all the elements needed for login tests
    AppiumBy usernameField = new AppiumBy.ByAccessibilityId("Username input field");
    AppiumBy passwordField = new AppiumBy.ByAccessibilityId("Password input field");
    AppiumBy loginButton = new AppiumBy.ByAccessibilityId("Login button");

    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    // This method makes sure that app is loaded before doing any actions.
    @Override
    public boolean isAt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).isDisplayed();
    }

    public void enterCredentials(String username, String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField)).sendKeys(username);
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void login() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton)).click();
    }

    public AppiumBy getMessageLocator(String text) {
        return new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"" + text + "\")");

    }

    public boolean isProperMessageDisplayed(String text) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getMessageLocator(text))).isDisplayed();
    }
}
