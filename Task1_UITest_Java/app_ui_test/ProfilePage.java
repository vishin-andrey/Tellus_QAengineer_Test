package app_ui_test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage {
    AndroidDriver driver;

    //Locator for Settings button
    By settingsBtn = By.id("com.giphy.messenger:id/settings_item");
    //Locator for Logout button
    By logoutBtn = By.id("com.giphy.messenger:id/logout");
    //Locator for Confirm button
    By confirmBtn = By.id("com.giphy.messenger:id/btnConfirm");
    //Locator for Signup View
    By signUpView = By.id("com.giphy.messenger:id/signUpView");

    //Constructor
    public ProfilePage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Go to Settings methods
    private void goSettings() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(settingsBtn));
        System.out.println("Settings Page loaded");
        this.driver.findElement(settingsBtn).click();
    }
    // Logout methods
    private void goLogout() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        this.driver.findElement(logoutBtn).click();
        System.out.println("Logout initialized");
        wait.until(ExpectedConditions.elementToBeClickable(confirmBtn));
        this.driver.findElement(confirmBtn).click();
    }
    // Check logout methods
    private void chkLogout() {
        WebDriverWait wait = new WebDriverWait(driver,5);
        wait.until(ExpectedConditions.elementToBeClickable(signUpView));
        System.out.println("Logged out");
    }

    // Login method
    public void logOut() {
        goSettings();
        goLogout();
        chkLogout();
    }
}
