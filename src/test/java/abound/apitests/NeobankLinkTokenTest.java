package abound.apitests;

import abound.clients.NeobankUserClient;
import abound.core.BaseTest;
import abound.core.ExtentReportUtil;
import api.models.LinktokenResponse;
import api.utils.TestContext;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PrintUtil;

public class NeobankLinkTokenTest extends BaseTest
{

    @Test
    public void createLinkTokenTest()
    {
        ExtentTest test =  ExtentReportUtil.extent.createTest("createLinkTokenTest").assignCategory("functional testcase");
        test.info("Creating link token on Neobank system test ...............");

        NeobankUserClient neobankUserClient = new NeobankUserClient();

        Response response = neobankUserClient.createLinkToken();

        LinktokenResponse linktokenResponse = response.as(LinktokenResponse.class);

        PrintUtil.printOperation(linktokenResponse);
        test.info(linktokenResponse.toString());

        TestContext.setLinktoken(linktokenResponse);

    }




}
