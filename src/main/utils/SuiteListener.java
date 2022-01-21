package main.utils;

import org.testng.ITestListener;
import org.testng.ITestContext;
import org.testng.ITestResult;

public class SuiteListener implements ITestListener {

    CommonMethods commonMethods = new CommonMethods();

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
        if (iTestResult.getTestClass().getXmlTest().getSuite().getAllParameters().get("platform") == "WEB")
            commonMethods.TakeScreenshot(iTestResult.getMethod().getMethodName());
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
