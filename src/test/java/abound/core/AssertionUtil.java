package abound.core;

import com.aventstack.extentreports.ExtentTest;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import org.testng.Assert;

public class AssertionUtil
{
    public static void assertNotNull(Object field , String fieldName)
    {
        Assert.assertNotNull(field,fieldName + " should not be null");
    }


    public static void assertNotNullWithReport( String fieldName, String responseBody, ExtentTest test) {
        try {
            AssertionUtil.assertNotNull(fieldName , fieldName + " should not be null");
            test.pass("Assertion passed: " + fieldName + " is not null");
        } catch (AssertionError e) {
            test.fail("❌ Assertion failed: " + fieldName + " is null");
            test.fail("<pre>" + prettyPrintJson(responseBody) + "</pre>");
            throw e;
        }
    }

    public static void assertEqualsWithReport(Object actual, Object expected, String message, String responseBody, ExtentTest test) {
        try {
            Assert.assertEquals(actual, expected, message);
            test.pass("Assertion passed: " + message);
        } catch (AssertionError e) {
            test.fail("❌ Assertion failed: " + message);
            test.fail("Expected: " + expected + ", but got: " + actual);
            test.fail("<pre>" + prettyPrintJson(responseBody) + "</pre>");
            throw e;
        }
    }

    private static String prettyPrintJson(String rawJson) {
        try {
            return new GsonBuilder().setPrettyPrinting().create()
                    .toJson(JsonParser.parseString(rawJson));
        } catch (Exception e) {
            return rawJson;
        }
    }

}
