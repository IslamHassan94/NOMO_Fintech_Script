package com.nomo.android.stepDef;

import com.nomo.android.pages.LoginPage;
import com.nomo.android.utils.ConfigUtil;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class LoginPageStepDef {
    private AppiumDriver driver;
    private LoginPage loginPage;
    private DesiredCapabilities caps;
    private ConfigUtil config;

    @Before
    public void setup() throws MalformedURLException {
        config = new ConfigUtil();
        caps = new DesiredCapabilities();
        caps.setCapability("platformName", config.getEmulatorPlatformName());
        caps.setCapability("deviceName", config.getEmulatorDeviceName());
        caps.setCapability("platformVersion", config.getEmulatorPlatformVersion());
        caps.setCapability("automationName", config.getEmulatorAutomationName());
        caps.setCapability("app", System.getProperty("user.dir") + "/apps/android/" + config.getAppName());

        driver = new AppiumDriver(new URL("http://127.0.0.1:4725/"), caps);
        loginPage = new LoginPage(driver);
    }


    @AfterStep
    public void takeScreenshotAfterStep(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            try {
                FileOutputStream fos = new FileOutputStream("screenshots/" + scenario.getName() + ".png");
                fos.write(screenshot);
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        if (driver != null) {
            driver.quit();
        }
    }

    @Given("I launch the mobile application")
    public void i_launch_the_mobile_application() {
        Assert.assertTrue(loginPage.isAt());
    }

    @And("I go to the login page")
    public void i_go_to_the_login_page() {
        loginPage.goToLoginPage();
    }

    @When("I enter {string} and {string} on the login screen")
    public void i_enter_and_on_the_login_screen(String username, String password) {
        loginPage.enterCredentials(username, password);
    }

    @And("I click on the login button")
    public void i_click_on_the_login_button() {
        loginPage.login();
    }

    @Then("I should see the {string}")
    public void i_should_see_the(String expectedOutcome) {
        Assert.assertTrue(loginPage.isLoggedIn(expectedOutcome));
    }
}
