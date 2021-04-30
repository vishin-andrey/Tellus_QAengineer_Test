package app_ui_test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    AndroidDriver driver;
    //Locator for Home button
    By homeBtn = By.id("com.giphy.messenger:id/home_icon");
    //Locator for Profile button
    By profileBtn = By.id("com.giphy.messenger:id/profile_icon");

    //Constructor
    public HomePage(AndroidDriver driver) {
        this.driver = driver;
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(homeBtn));
        System.out.println("Home Page loaded");
        switchHome();
    }

    // Methods to manipulate page elements
    private void switchHome() {this.driver.findElement(homeBtn).click();}
    private void switchProfile() {this.driver.findElement(profileBtn).click();}

    // Go to profile method
    public ProfilePage goProfile() {
        switchProfile();
        return new ProfilePage(this.driver);
    }
}
