package com.nomo.android.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends AbstractPage {
    AppiumBy burgerMenu = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(0)");
    AppiumBy logo = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.view.ViewGroup\").instance(63)");
    AppiumBy loginOption = new AppiumBy.ByAndroidUIAutomator("new UiSelector().className(\"android.widget.ImageView\").instance(6)");

    public HomePage(AppiumDriver driver) {
        super(driver);
    }

    @Override
    public boolean isAt() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logo)).isDisplayed();
    }

    public void goToLoginPage() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(burgerMenu)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginOption)).click();
    }
}
