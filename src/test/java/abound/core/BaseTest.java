package abound.core;

import config.ConfigManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import utils.ExtentReportUtil;
import utils.LogUtil;

public class BaseTest
{
    @BeforeSuite
    public void beforeSuite() {
        LogUtil.init(); // Init log4j
        ExtentReportUtil.initReports(); // Initialize Extent Reports
        ConfigManager.load(); // Load environment configs
    }

    @BeforeMethod
    public void setUp() {
        LogUtil.info("==== Test Started ====");
    }

    @AfterMethod
    public void tearDown() {
        LogUtil.info("==== Test Finished ====");
        ExtentReportUtil.flushReports(); // Save test report after each test
    }

    @AfterSuite
    public void afterSuite() {
        // Optional: close DB connections, stop WireMock, etc.
        LogUtil.info("==== Test Suite Execution Completed ====");
    }

}
