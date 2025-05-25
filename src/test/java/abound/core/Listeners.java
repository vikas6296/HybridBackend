package abound.core;

import com.aventstack.extentreports.ExtentTest;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listeners implements ITestListener
{

    @Override
    public void onTestStart(ITestResult iTestResult) {
        String testName = iTestResult.getMethod().getMethodName();
        ExtentTest test = ExtentReportUtil.extent.createTest(testName);
        ExtentReportUtil.setTest(test);
        test.info("🚀 Test started: " + testName);
    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {

    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
    ExtentReportUtil.initReports();
    }

    @Override
    public void onFinish(ITestContext iTestContext) {

        ExtentReportUtil.flushReports();
    }
}
