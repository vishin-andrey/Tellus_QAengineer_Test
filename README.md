# Tellus_QAengineer_Test
#### Tellus test task for the QA Engineer in Automation

_This repository contains the results of the Test projects of career seeker for the QA Engineer in Automation position.
The project requirements are defined in the file: Tellus QA Automation Engineer Test Task-1.pdf (see below)_

## I. UI test

[See Task1_UITest_Java folder](Task1_UITest_Java/app_ui_test/)

### Tools used:
* [Appium framework](https://appium.io/)
* [Android studio](https://developer.android.com/studio)
* Java
* [IntelliJ IDEA IDE](https://www.jetbrains.com/idea/)
* [TestNG framework](https://testng.org/)
* [Selenium Webdriver](https://www.selenium.dev/downloads/)
* Smartphone Samsung A-7100

### Description:
Login Test for the [GIPHY Android app](https://play.google.com/store/apps/details?id=com.giphy.messenger) was developed.

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

_For a detailed description, see the code files comments._

#### Notice
To execute tests, register on the giphy.com website. To use the user name and password, after registration set the next environment variables:
```
GIPHY_TEST_USERNAME 
GIPHY_TEST_PASSWORD
```

## II. Back-end test

[See Task2_BackendTest_Ruby folder](Task2_BackendTest_Ruby/)

### Tools used:
* Ruby
* [RubyMine IDE](https://www.jetbrains.com/ruby/)
* [open-uri gem](https://github.com/ruby/open-uri)
* [rest-client gem](https://github.com/rest-client/rest-client)
* [httparty gem](https://github.com/jnunemaker/httparty)

### Description:
Developed Search Test for [GIPHY WEB app](https://giphy.com/)

The test implements the HTTP GET query to Giphy application web API. The test success is checking using the response code 200 OK. The response JSON validation is not included in the test case.

For test execution, received API key using [Giphy developers website](https://developers.giphy.com). However, the project's final code implemented a method for extraction of the API key, using parsing of the landing page HTML.

The project code used three classes:
- class _GiphyAPI_ implement interaction with Giphy web API;
- class _Test_ establishes the form of the final result submission;
- class _TestGiphySearch_ includes a method to implement a test search query

_For a detailed description, see the code files comments._

## III. SQL
[See Task3_SQLTest_SQL folder](Task3_SQLTest_SQL/)

### Tools used:
* Structured Query Language
* [SQL online emulator](http://sqlfiddle.com/)

### Description:
In this project section, developed SQL query prepared a simple test database, and the query tried using an online SQL emulator.
There are two files in the task folder:
* `Test_dbcreate.sql` to create a test table
* `Test_query.sql` with the main query

To create the final request, three nested queries are used.

1. At first, selected laptops.
```
SELECT product_id, price
FROM Products
WHERE product_type='laptop'
```
2. At the next step, a table created, where the records are ordered by price ascending. Into this table, a new column added. The column includes average prices for the items from the first record (cheapest) to the current one.
```
SELECT 
  p.product_id, p.price,
  AVG(p.price) OVER 
    (ORDER BY p.price ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW) AS average_price
  FROM (
    SELECT product_id, price
    FROM Products
    WHERE product_type='laptop'
  ) p
) t
```
3. The last query selects all the items which will have an average price lower than the task limit.
```
SELECT product_id, price 
FROM (
  SELECT 
  p.product_id, p.price,
  AVG(p.price) OVER 
    (ORDER BY p.price ROWS BETWEEN UNBOUNDED PRECEDING AND CURRENT ROW)
                                                           AS average_price
  FROM (
    SELECT product_id, price
    FROM Products
    WHERE product_type='laptop'
  ) p
) t
WHERE
  average_price < 2000;
```

## IV. Test Scenarios
