package test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.Markup;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.model.Media;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
//import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
//import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import main.utils.CommonMethods;
import main.utils.Constants;
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
import org.testng.reporters.jq.Model;

import java.io.File;
import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static main.utils.Constants.*;

public class BaseTest extends CommonMethods {

    public static WebDriver driver;
    //public ExtentHtmlReporter extentHtmlReporter;
    public ExtentSparkReporter extentHtmlReporter;
    public static ExtentReports extentReports;
    public static ExtentTest extentTestLogger;

    private static RequestSpecification requestSpec;
    //Response response;

    public String getToken() {
        return getTokenInst();
    }

    public String screenshotPAth = "";

    public String getServerURL() {
        return getServerURlIns();
    }

    public void setRestAssuredBaseURL() {
        RestAssured.baseURI = getServerURL();
    }

    public void setScreenshotPath() {
        System.out.println("Setting ScreenshotPAth Value");
        screenshotPAth = getScreenshotName();
        System.out.println("ScreenshotPath Variable Value " + screenshotPAth);
    }

    public void setRestAssuredAuthHeader() {
        RequestSpecBuilder builder = new RequestSpecBuilder();
        builder.addHeader(xAuth, getToken());

        requestSpec = builder.build();

        RestAssured.requestSpecification = requestSpec;
    }

    @BeforeTest(alwaysRun = true)
    public void beforeTestMethod() {
        String localDateTime = getLocalDateAndTimeString();
        extentHtmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + File.separator + "reports" + File.separator + "AutomationReport - " + localDateTime + ".html");
        extentHtmlReporter.config().setEncoding("utf-8");
        extentHtmlReporter.config().setDocumentTitle("TicketLake - Automation Report - " + localDateTime);
        extentHtmlReporter.config().setReportName("TicketLake - Automation Test Results - " + localDateTime);
        extentHtmlReporter.config().setTheme(Theme.DARK);
        extentReports = new ExtentReports();
        extentReports.attachReporter(extentHtmlReporter);
        extentReports.setSystemInfo("Automation Engineer", "Hamza Ashfaq");

        setRestAssuredBaseURL();
        //setRestAssuredAuthHeader();
    }

    @BeforeMethod(alwaysRun = true)
    @Parameters(value = {"browser", "platform", "headless"})
    public void beforeMethodMethod(@Optional String browser, Method testMethod, @Optional String platform, @Optional boolean headless) {
        if (platform != null && platform.equalsIgnoreCase("WEB")) {
            setDriver(browser, headless);

            driver.manage().window().maximize();
            driver.navigate().to(Constants.baseUrl);
            //driver.get(Constants.baseUrl);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        }

        String methodName = testMethod.getName();
        String logText = "Testing: " + methodName;
        Markup markup = MarkupHelper.createLabel(logText, ExtentColor.WHITE);

        extentTestLogger = extentReports.createTest(testMethod.getName());
        extentTestLogger.log(Status.INFO, markup);
    }

    @AfterMethod(alwaysRun = true)
    @Parameters(value = {"platform"})
    public void afterMethodMethod(ITestResult result, String platform) {
        if (result.getStatus() == TestResult.SUCCESS) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Passed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.GREEN);
            extentTestLogger.log(Status.PASS, markup);
        } else if (result.getStatus() == TestResult.FAILURE) {
            screenshotPAth = getScreenshotName();
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Failed";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.RED);
            if (!(screenshotPAth == null || screenshotPAth.isEmpty())) {
                extentTestLogger.addScreenCaptureFromPath(screenshotPath + ".PNG");
            } else {
                System.out.println("Variable: 'ScreenshotPath' is null or Empty");
            }
            extentTestLogger.log(Status.FAIL, markup);
        } else if (result.getStatus() == TestResult.SKIP) {
            String methodName = result.getMethod().getMethodName();
            String logText = "Test Case: " + methodName + " Skipped";
            Markup markup = MarkupHelper.createLabel(logText, ExtentColor.ORANGE);
            extentTestLogger.log(Status.SKIP, markup);
        }
        if (platform.equalsIgnoreCase("WEB")) {
            try {
                driver.close();
                driver.quit();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @AfterTest(alwaysRun = true)
    public void afterTestMethod() {
        extentReports.flush();
    }

    public boolean IsElementPresent(By element) {
        return driver.findElement(element).isEnabled();
    }

    public boolean IsElementVisible(By element) {
        return driver.findElement(element).isDisplayed();
    }

    public boolean IsElementPresentAndVisible(By element) {
        return driver.findElement(element).isEnabled() && driver.findElement(element).isDisplayed();
    }

    public void setWindowSize(int width, int height) {
        driver.manage().window().setSize(new Dimension(width, height));
    }

    public void setDriver(String browser, boolean headless) {
        if (browser.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
            if (headless) {
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.setHeadless(true);
                driver = new ChromeDriver(chromeOptions);
            } else
                driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + File.separator + "drivers" + File.separator + "chromedriver.exe");
            driver = new ChromeDriver();
        }
    }
}
