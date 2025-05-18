/*
package abound.neobank.utilities;

import abound.neobank.TestCases.SignUpAndKYCFlowTest;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.IReporter;
import org.testng.ISuite;
import org.testng.xml.XmlSuite;


import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;

public class SparkHTML implements IReporter
{

   public static String updatedReport;

   public static ExtentReports extent=new ExtentReports();

   public static ExtentSparkReporter spark=new ExtentSparkReporter("target/Spark"+getDate()+".html");

   @Override
   public void generateReport(List<XmlSuite> list, List<ISuite> list1, String s)
   {

   }

   public static String getDate()
   {
      LocalDateTime myObj = LocalDateTime.now();
      String time=myObj.toString();
      time=time.replace(":","");
      updatedReport=time;
      return time;
   }
}




*/
