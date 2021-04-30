package app_ui_test;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class LoginPage {
    AndroidDriver driver;
    //Locator for SignUp/Login Switch
    String loginSw = "Log In";
    //Locator for username
    By userNameField = By.id("com.giphy.messenger:id/signupEmailEditText");
    //Locator for password
    By userPassField = By.id("com.giphy.messenger:id/signupPasswordEditText");
    //Locator for Login Button
    By loginBtn = By.id("com.giphy.messenger:id/startSignUp");

    //Constructor
    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // Methods to manipulate page elements: switch SignUp to Login, enter user data, click login button
    private void switchToLogin() {this.driver.findElementByAccessibilityId(loginSw).click();}
    private void typeUsername(String username) {this.driver.findElement(userNameField).sendKeys(username);}
    private void typePassword(String password) {this.driver.findElement(userPassField).sendKeys(password);}
    private void clickLoginBtn() {this.driver.findElement(loginBtn).click();}

    // Login method
    public HomePage loginAs(String username, String password) {
        switchToLogin();
        typeUsername(username);
        typePassword(password);
        clickLoginBtn();
        System.out.println("Login Page passed");
        return new HomePage(this.driver);
    }
}