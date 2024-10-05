package com.nomo.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private final AppiumDriver driver;
    private WebDriverWait wait;
    AppiumBy burgerMenu = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");
    AppiumBy logo = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(63)");
    AppiumBy loginOption = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(6)");
    AppiumBy usernameField = new AppiumBy.ByAccessibilityId("Username input field");
    AppiumBy passwordField = new AppiumBy.ByAccessibilityId("Password input field");
    AppiumBy loginButton = new AppiumBy.ByAccessibilityId("Login button");
    AppiumBy productsFlag = new AppiumBy.ByAndroidUIAutomator("new UiSelector().text(\"Products\")");

    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean isAt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    public void goToLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burgerMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginOption)).click();
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

    public boolean isLoggedIn(String text) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(getMessageLocator(text))).isDisplayed();
    }
}
