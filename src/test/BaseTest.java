package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.aventstack.extentreports.reporter.configuration.ViewName;
import com.sun.org.apache.xpath.internal.operations.Bool;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.utils.CommonMethods;
import main.utils.Constants;
import main.utils.PropertyFilesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.*;
import org.testng.internal.TestResult;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static main.data.Web.MoviesData.moviesURL;
import static main.utils.CommonMethods.screenshotPath;
import static main.utils.Constants.*;

public class BaseTest{

    PropertyFilesReader propRead = new PropertyFilesReader();

    public WebDriver driver;
    CommonMethods commonMethods = new CommonMethods(driver);
    //public ExtentHtmlReporter extentHtmlReporter;
    public ExtentSparkReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTestLogger;
    private String baseUrl_Web;

    private static RequestSpecification requestSpec;

    public String getToken() {
        return commonMethods.getTokenInst();
    }

    public String screenshotPAth = "";

    private void setBaseUrl_Web(boolean isAdmin) {
        baseUrl_Web = commonMethods.getBaseURL_Web(isAdmin);
    }

    public String getServerURL() {
        return commonMethods.getServerURlIns();
    }

    public void setRestAssuredBaseURL() {
        RestAssured.baseURI = getServerURL();
    }

    public void setScreenshotPath() {
        System.out.println("Setting ScreenshotPAth Value");
        screenshotPAth = commonMethods.getScreenshotName();
        System.out.println("ScreenshotPath Variable Value " + screenshotPAth);
    }

    public void setRestAssuredAuthHeader() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader(xAuth, getToken());

        requestSpec = builder.build();

        RestAssured.requestSpecification = requestSpec;
    }

    public void loadMoviesSearchURL() {
        driver.navigate().to(baseUrl_Web + moviesURL);
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTestMethod() {
        String localDateTime = commonMethods.getLocalDateAndTimeString();
        extentHtmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport - " + localDateTime + ".html");
        extentHtmlReporter.config().setEncoding("utf-8");
        extentHtmlReporter.config().setDocumentTitle("TicketLake - Automation Report - " + localDateTime);
        extentHtmlReporter.config().setReportName("TicketLake - Automation Test Results - " + localDateTime);
        extentHtmlReporter.config().setTheme(Theme.STANDARD);
        extentHtmlReporter.viewConfigurer().viewOrder().as(new ViewName[]{ViewName.DASHBOARD, ViewName.TEST, ViewName.AUTHOR}).apply();

        ExtentSparkReporter sparkFail = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport - " + localDateTime + " - Failed.html")
                .filter()
                .statusFilter()
                .as(new Status[]{Status.FAIL})
                .apply();

        extentReports = new ExtentReports();
        extentReports.attachReporter(sparkFail, extentHtmlReporter);
        extentReports.setSystemInfo("Automation Engineer", "Hamza Ashfaq");

        setRestAssuredBaseURL();
        //setRestAssuredAuthHeader();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters(value = {"browser", "platform", "headless", "isAdmin"})
    public void beforeMethodMethod(@Optional String browser, Method testMethod, String platform,
                                   @Optional boolean headless, @Optional boolean isAdmin) {

        String testName = testMethod.getAnnotation(Test.class).testName();

        extentTestLogger = extentReports.createTest(testName);
        extentTestLogger.log(Status.INFO, createMarkupText(testName, ExtentColor.WHITE));
    }

    public WebDriver initializeBrowser() {
        String browser = propRead.getBrowser();
        Boolean headless = propRead.getHeadLess();
        Boolean isAdmin = propRead.getIsAdmin();

        driver = setDriver(browser, headless);

        baseUrl_Web = commonMethods.getBaseURL_Web(isAdmin);

        driver.manage().window().maximize();
        driver.navigate().to(baseUrl_Web);
        //driver.get(Constants.baseUrl);
        setMaxTimeout(30);

        return driver;
    }

    public void setMaxTimeout(int seconds) {
        driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
    }

    public void resetMaxTimeout() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    private Markup createMarkupText(String testName, ExtentColor color) {
        String logText = "Testing: " + testName;
        Markup markup = MarkupHelper.createLabel(logText, color);
        return markup;
    }

    public void logTextOnReport(String text) {
        Markup markup = MarkupHelper.createLabel(text, ExtentColor.WHITE);
        extentTestLogger.log(Status.INFO, markup);
    }

    @AfterMethod(alwaysRun = true)
    @Parameters(value = {"platform"})
    public void afterMethodMethod(ITestResult result, String platform) {
        String testName = result.getMethod().getMethodName();
        if (result.getStatus() == TestResult.SUCCESS) {
            String logText = "Test Case: " + testName + " Passed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            extentTestLogger.log(Status.PASS, markup);
        } else if (result.getStatus() == TestResult.FAILURE) {
            screenshotPAth = commonMethods.getScreenshotName();

            String logText = ((TestResult) result).getThrowable().getMessage();
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            extentTestLogger.log(Status.FAIL, markup);

            logText = "Test Case: " + testName + " Failed";
            markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            if (!(screenshotPAth == null || screenshotPAth.isEmpty())) {
                extentTestLogger.addScreenCaptureFromPath(screenshotPath + ".PNG");
            } else {
                System.out.println("Variable: 'ScreenshotPath' is null or Empty");
            }
            extentTestLogger.log(Status.FAIL, markup);
        } else if (result.getStatus() == TestResult.SKIP) {
            String logText = "Test Case: " + testName + " Skipped";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
            extentTestLogger.log(Status.SKIP, markup);
        }
    }

    public void closeAndQuitBrowser(WebDriver driver) {
        try {
            driver.close();
            driver.quit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterTest(alwaysRun = true)
    public void afterTestMethod() {
        extentReports.flush();
    }

//    public static boolean IsElementPresent(By element) {
//        return driver.findElement(element).isEnabled();
//    }

    public boolean IsElementVisible(By element) {
        return driver.findElement(element).isDisplayed();
    }

    public boolean IsElementPresentAndVisible(By element) {
        return driver.findElement(element).isEnabled() && driver.findElement(element).isDisplayed();
    }

    public void setWindowSize(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public WebDriver setDriver(String browser, boolean headless) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
            ChromeOptions chromeOptions = new ChromeOptions();
            //chromeOptions.setBinary("C:\\Google Chrome Selenium\\chrome.exe");
            if (headless) {
                chromeOptions.setHeadless(true);
            }
            driver = new ChromeDriver(chromeOptions);
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
            driver = new ChromeDriver();
        }

        return driver;
    }

}
