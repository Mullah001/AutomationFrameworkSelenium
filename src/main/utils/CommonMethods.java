package main.utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.nio.file.*;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import test.BaseTest;

import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static main.ApiConfigs.EndPoints.LogInEP.loginEP;
import static main.utils.Constants.appJson;
import static main.utils.Constants.xAuth;

public class CommonMethods {

    PropertyFilesReader propRead = new PropertyFilesReader();

    static final String COMMA_DELIMITER = ",";

    private String localDateTime;

    public static String screenshotPath;

    public static String screenshotName;

    public String getBaseURL_Web(boolean isAdmin) {
        String baseURL = Constants.WebBaseUrl;

        if (isAdmin) {
            baseURL = Constants.adminBaseUrl;
        }

        return baseURL;

    }

    /**
     * Get Authorization Token from API
     *
     * @return token
     */
    public String getTokenInst() {
        String body = propRead.getUserCredentials();

        if (RestAssured.baseURI.isEmpty() || RestAssured.baseURI == null)
            RestAssured.baseURI = getServerURlIns();

        Response response = RestAssured.given()
                .contentType(appJson)
                .body(body)
                .post(loginEP);

        return response.body().jsonPath().get(xAuth).toString();
    }

    public static void sleep(long milliSec) {
        try {
            Thread.sleep(milliSec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public String getServerURlIns() {
        return propRead.getServerURlProp();
    }

    public String getPaypalUserName_sb() {
        return propRead.getPaypalUserName_sb();
    }

    public String getPaypalPassword_sb() {
        return propRead.getPaypalPassword_sb();
    }

    /**
     * Read CSV and Return the data in the form of List
     *
     * @return
     */
    public static List<List<String>> ReadCSV(String path) {
        List<List<String>> records = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File(path));) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return records;
    }

    /**
     * Gets the records from the CSV Line or Given Line
     *
     * @param line String of line with Comma Separator
     */
    private static List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    public static List<String> getRecordFromCSV(String path, int lineNumber) {
        List<String> record = new ArrayList<>();
        int count = 1;
        try (Scanner scanner = new Scanner(new File(path));) {
            while (scanner.hasNextLine()) {
                if (count == lineNumber) {
                    record = getRecordFromLine(scanner.nextLine());
                    break;
                } else
                    count++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return record;
    }

    public String createScreenshotPath(String methodName) {
        localDateTime = getLocalDateAndTimeString();
        screenshotName = methodName + localDateTime;
        screenshotPath = System.getProperty("user.dir") + File.separator + "screenshots" + File.separator + screenshotName;
        return screenshotPath;
    }

    public String getScreenshotName() {
        return screenshotPath;
    }

    public void TakeScreenshot(String methodName) {
        String fileName = createScreenshotPath(methodName);

        try {
            File file = ((TakesScreenshot) BaseTest.driver).getScreenshotAs(OutputType.FILE);
            Files.copy(file.toPath(), new File(fileName + ".png").toPath(), LinkOption.NOFOLLOW_LINKS, StandardCopyOption.REPLACE_EXISTING);
            //FileUtils.copyFile(file, new File(fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLocalDateAndTimeString() {
        localDateTime = LocalDateTime.now().toLocalDate().toString() + "_" + LocalDateTime.now().toLocalTime().toString();
        localDateTime = localDateTime.replace(':', '_').replace('.', '_').replace('/', '_').replace('-', '_');
        return localDateTime;
    }

    public static String generateRandomEmail() {
        String name = RandomStringUtils.randomAlphabetic(9);
        String domain = RandomStringUtils.randomAlphabetic(6);
        String randomWords = RandomStringUtils.randomAlphanumeric(5);
        return name + randomWords + "@" + domain + ".com";
    }

    public static String generateRandomPhoneNumber() {
        String phoneNumber = "+92320" + RandomStringUtils.randomNumeric(7);
        return phoneNumber;
    }

    /******************** Selenium Helper Methods *******************/

    public static String getTitle() {
        return BaseTest.driver.getTitle();
    }

    public static String getCurrentURL() {
        return BaseTest.driver.getCurrentUrl();
    }

    public static void typeWithSpeed(By element, String value, long speedDelay) {
        BaseTest.driver.findElement(element).click();
        for (int i = 0; i < value.length(); i++) {
            BaseTest.driver.findElement(element).sendKeys(value.substring(i, (i + 1)));
            sleep(speedDelay);
        }
    }

    public boolean IsElementPresentAndVisible(By element) {
        boolean elementPresence = false;
        try {
            elementPresence = BaseTest.driver.findElement(element).isEnabled() && BaseTest.driver.findElement(element).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementPresence;
    }

    public boolean IsElementPresent(By element) {
        boolean elementPresence = false;
        try {
            elementPresence = BaseTest.driver.findElement(element).isEnabled();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return elementPresence;
    }

    public void waitForElementPresent(WebDriver driver, By item, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(item));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementVisible(WebDriver driver, By item, int seconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, seconds);
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(item));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void waitForElementPresentAndVisible(WebDriver driver, By item, int seconds) {
        try {
            waitForElementPresent(driver, item, seconds);
            waitForElementVisible(driver, item, seconds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void scrollElementIntoView(By webElement) {
        WebElement element = BaseTest.driver.findElement(webElement);
        ((JavascriptExecutor) BaseTest.driver).executeScript("arguments[0].scrollIntoView(true);", element);
        sleep(500l);
        ((JavascriptExecutor) BaseTest.driver).executeScript("window.scrollBy(250,-150);", element);
        sleep(500l);
    }

    public void clearAndTypeIfPresentAndVisible(String locatorXPath, String value) {
        if (IsElementPresentAndVisible(By.xpath(locatorXPath))) {
            BaseTest.driver.findElement(By.xpath(locatorXPath)).clear();
            BaseTest.driver.findElement(By.xpath(locatorXPath)).sendKeys(value);
        }
    }

}
