package abound.apitests;

import abound.clients.NeobankUserClient;
import abound.core.BaseTest;
import abound.core.ExtentReportUtil;
import api.builders.UserLoginRequestbuilder;
import api.models.UserLoginOnNeobankRequest;
import api.models.UserLoginOnNeobankResponse;
import api.utils.TestContext;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PrintUtil;

public class NeobankUserLoginTest extends BaseTest
{

    @Test
    public void neobankUserLoginTest()
    {
        ExtentTest test =  ExtentReportUtil.extent.createTest("neobankUserLoginTest").assignCategory("functional testcase");
        test.info("User login on Neobank system test ...............");

        UserLoginOnNeobankRequest userNeobankRequest = new UserLoginRequestbuilder().build();

        NeobankUserClient neobankUserClient = new NeobankUserClient();
        Response neobankUserLoginResponse = neobankUserClient.loginUserOnNeobank(userNeobankRequest);

        UserLoginOnNeobankResponse userLoginOnNeobankResponse = neobankUserLoginResponse.as(UserLoginOnNeobankResponse.class);
        PrintUtil.printOperation(userLoginOnNeobankResponse);
        test.info(userLoginOnNeobankResponse.toString());

        TestContext.setUserNeobankLoginRequest(userNeobankRequest);
        TestContext.setNeobankUserLoginResponse(userLoginOnNeobankResponse);

    }

}
