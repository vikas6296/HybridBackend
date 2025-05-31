package abound.core;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;

public class ComparisionReportUtil
{
    private static final Path REPORT_PATH = Paths.get("comparison_report.html");

    public static void initializeReportFile() {
        try {
            String initialHtml = "<html><head><style>" +
                    "table {border-collapse: collapse; width: 100%;}" +
                    "th, td {border: 1px solid #ccc; padding: 8px; text-align: left;}" +
                    "th {background-color: #f2f2f2;}" +
                    "</style></head><body><h1>API Automation Report</h1><br/>";
            Files.write(REPORT_PATH, initialHtml.getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void appendComparisonTable(Object responseObject, String testName, ExtentTest test) {
        try {


            Map<String,Object> responseMap = Helpers.convertPojoToMap(responseObject);

            StringBuilder htmlTable = new StringBuilder();
            htmlTable.append("<h3>").append(testName).append("</h3>");
            htmlTable.append("<table><tr><th>Field</th><th>Actual</th><th>Status</th></tr>");

            String [][] comparisonTable = new String[responseMap.size() + 1][3];

            comparisonTable[0][0] ="Field";
            comparisonTable[0][1] = "Expected";
            comparisonTable[0][2] = "Status";


            int i = 1;

            for(String key : responseMap.keySet())
            {
                comparisonTable[i][0] = key;
                comparisonTable[i][1] = responseMap.get(key).toString();
                comparisonTable[i][2] = responseMap.get(key).toString() != null ? "Passed" : "Failed";

                htmlTable.append("<tr>")
                        .append("<td>").append(comparisonTable[i][0]).append("</td>")
                        .append("<td>").append( comparisonTable[i][1] ).append("</td>")
                        .append("<td>").append(comparisonTable[i][2]).append("</td>")
                        .append("</tr>");
                i++;

            }

            ExtentReportUtil.logLabel(test,"Validating response -->", ExtentColor.BLUE);
            ExtentReportUtil.logTable(test,comparisonTable,"Test validation");

            htmlTable.append("</table><br/>");

            Files.write(REPORT_PATH, htmlTable.toString().getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void finalizeReportFile() {
        try {
            Files.write(REPORT_PATH, "</body></html>".getBytes(StandardCharsets.UTF_8),
                    StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
