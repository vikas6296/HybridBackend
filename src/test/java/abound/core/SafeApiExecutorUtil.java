package abound.core;

import abound.adapters.http.HttpClientAdapter;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import utils.PrintUtil;

public class SafeApiExecutorUtil
{

    public static <T> Response execute(HttpClientAdapter<T> adapter, T request, ExtentTest test) {
        try {
            test.info("Sending API request: <pre>" + PrintUtil.printObject(request) + "</pre>");
            Response response = adapter.execute(request);
            test.pass("✅ API executed successfully.");
            return response;
        } catch (Exception e) {
            test.fail("❌ API call failed due to exception: " + e.getClass().getSimpleName());
            test.fail("<pre>" + ExceptionUtil.getStackTrace(e) + "</pre>");
            throw e;
        }
    }
}
