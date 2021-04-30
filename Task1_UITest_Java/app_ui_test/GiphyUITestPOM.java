package app_ui_test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import java.net.URL;


public class GiphyUITestPOM {
    private AndroidDriver driver;
    // Get the User's name & password from system variables
    String userName = System.getenv("GIPHY_TEST_USERNAME");
    String userPass = System.getenv("GIPHY_TEST_PASSWORD");

    @Test
    public void testLogin() {
        StartPage startPg = new StartPage(driver);
        LoginPage loginPg = startPg.getStarted();
        HomePage homePg = loginPg.loginAs(userName, userPass);
        ProfilePage profilePg = homePg.goProfile();
        profilePg.logOut();
    }

    @BeforeMethod
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

    @AfterMethod
    void teardown() {
        driver.quit();
    }
}
