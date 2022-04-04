package main.utils;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class SuiteListener implements ITestListener {

    @Override
    public void onFinish(ITestContext iTestResult) {
    }

    @Override
    public void onStart(ITestContext iTestResult) {
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        WebDriver driver = null;
        try {
            driver = (WebDriver) iTestResult.getTestClass().getRealClass().getDeclaredField("driver").get(iTestResult.getInstance());
        } catch (Exception e) {

        }

        CommonMethods commonMethods = new CommonMethods(driver);

        if (iTestResult.getTestClass().getXmlTest().getSuite().getAllParameters().get("platform").equals("WEB"))
            commonMethods.TakeScreenshot(iTestResult.getMethod().getMethodName(), driver);
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {
    }

    @Override
    public void onTestStart(ITestResult iTestResult) {
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
    }

}
