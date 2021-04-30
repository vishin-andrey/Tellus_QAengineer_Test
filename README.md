# Tellus_QAengineer_Test
#### Tellus test task for the QA Engineer in Automation

_This repository contains the results of the Test projects of career seeker for the QA Engineer in Automation position.
The project requirements are defined in the file: Tellus QA Automation Engineer Test Task-1.pdf (see below)_

## I. UI test

[See Task1_UITest_Java folder](Task1_UITest_Java/app_ui_test/)

### Tools used:
* [Appium framework](https://appium.io/)
* [Android studio](https://developer.android.com/studio)
* [IntelliJ IDEA IDE](https://www.jetbrains.com/idea/)
* Java
* [TestNG framework](https://testng.org/)
* [Selenium Webdriver](https://www.selenium.dev/downloads/)
* Smartphone Samsung A-7100

### Description:
To get UI selectors, UI Automator Viewer from the Android studio was used to analyze the Giphy app on the Samsung device.
Test scenario includes the next steps:
- Establishing the connection to the app;
- Starting the application on the device;
- Passing Start page;
- Entering user name and password;
- Waiting for Logging in and check it;
- Going to the home page;
- Logging out and closing the connection.

Tests prepared using TestNG approaches. The @BeforeMethod is used to manage a connection to the device and the app. Then @Test executes test steps. Finally, the teardown follows within the @AfterMethod.

The project realized in two ways:
1. Short Linear script.
`See GiphyUITestSIMPLE.java`
2. Simple framework based on Page Object Model approach.
`See GiphyUITestPOM.java
and page class files 
HomePage.java
LoginPage.java
ProfilePage.java
StartPage.java`

#### Notice
To execute tests, register on the giphy.com website. To use the user name and password, after registration set the next environment variables:
```
GIPHY_TEST_USERNAME 
GIPHY_TEST_PASSWORD
```

## II. Back-end test

## III. SQL

## IV. Test Scenarios
