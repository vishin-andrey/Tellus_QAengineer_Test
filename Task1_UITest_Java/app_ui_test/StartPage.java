package app_ui_test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class StartPage {
    private AndroidDriver driver;
    //Locator for Get Started button
    By getStartedBtn = By.id("com.giphy.messenger:id/getStartedButton");

    //Constructor
    public StartPage(AndroidDriver driver) {
        this.driver = driver;
    }

    //Method to click Get Started button
    public LoginPage getStarted() {
        this.driver.findElement(getStartedBtn).click();
        System.out.println("Start Page passed");
        return new LoginPage(this.driver);
    }
}
