package abound.core;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;

import java.util.List;

public class ExtentReportUtil implements IReporter
{
    public static ExtentReports extent=new ExtentReports();

    public static ExtentSparkReporter spark=new ExtentSparkReporter("test-output/Spark");

    @Override
    public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s)
    {

    }

    public static void initReports()
    {
        extent.attachReporter(spark);

        // Optional: You can customize the report
        spark.config().setReportName("API Test Execution Report");
        spark.config().setDocumentTitle("Hybrid Backend Automation Report");

        // Optional: Add system or environment info
        extent.setSystemInfo("Environment", "QA");
        extent.setSystemInfo("Tester", "Vikas");
    }

    public static void flushReports()
    {
        if (extent != null) {
            extent.flush();
        }
    }

}
