package app_ui_test;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import io.appium.java_client.android.AndroidDriver;

public class GiphyUITestSIMPLE {
    private AndroidDriver driver;
    // Get the User's name & password from system variables
    String userName = System.getenv("GIPHY_TEST_USERNAME");
    String userPass = System.getenv("GIPHY_TEST_PASSWORD");

    @BeforeMethod
    // Prepare connection
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "galaxy");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "7.1.1");
        // Connected device identifier
        capabilities.setCapability("udid", "f7eca801");
        // Giphy-package to launch
        capabilities.setCapability("appPackage", "com.giphy.messenger");
        // Giphy-activity name to launch
        capabilities.setCapability("appActivity", "com.giphy.messenger.app.OnboardingActivity");
        //capabilities.setCapability("appActivity", "com.giphy.messenger.app.MainActivity");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
    }

    @Test
    // Main test
    public void testLogin() {
        //Click Get Started button
        driver.findElementById("com.giphy.messenger:id/getStartedButton").click();
        // Switch SignUp to Login, enter user data, click login button
        driver.findElementByAccessibilityId("Log In").click();
        driver.findElementById("com.giphy.messenger:id/signupEmailEditText").sendKeys(userName);
        driver.findElementById("com.giphy.messenger:id/signupPasswordEditText").sendKeys(userPass);
        driver.findElementById("com.giphy.messenger:id/startSignUp").click();
        // Waiting for loading, go home page
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.giphy.messenger:id/home_icon")));
        driver.findElementById("com.giphy.messenger:id/home_icon").click();
    }

    @AfterMethod
    // Close account and disconnect
    public void teardown() {
        // Go to Profile
        driver.findElementById("com.giphy.messenger:id/profile_icon").click();
        // Waiting for Profile, go settings
        WebDriverWait wait = new WebDriverWait(driver,7);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.giphy.messenger:id/settings_item")));
        driver.findElementById("com.giphy.messenger:id/settings_item").click();
        // Click logout
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.giphy.messenger:id/logout")));
        driver.findElementById("com.giphy.messenger:id/logout").click();
        // Click confirmation button
        wait.until(ExpectedConditions.elementToBeClickable(By.id("com.giphy.messenger:id/btnConfirm")));
        driver.findElementById("com.giphy.messenger:id/btnConfirm").click();
        // Waiting for login page to check logout
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.giphy.messenger:id/signUpView")));
        // Close
        driver.quit();
    }
}