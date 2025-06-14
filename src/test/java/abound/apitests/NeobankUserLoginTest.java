package abound.apitests;

import abound.adapters.http.AdapterType;
import abound.adapters.http.HttpClientAdapter;
import abound.clients.ClientType;
import abound.clients.NeobankUserClient;
import abound.core.BaseTest;
import abound.core.ComparisionReportUtil;
import abound.core.ExtentReportUtil;
import abound.core.SafeApiExecutorUtil;
import abound.factories.ClientFactory;
import api.builders.UserLoginRequestbuilder;
import api.models.UserLoginOnNeobankRequest;
import api.models.UserLoginOnNeobankResponse;
import api.utils.TestContext;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PrintUtil;

import java.lang.reflect.Method;

public class NeobankUserLoginTest extends BaseTest
{

    @Test
    public void neobankUserLoginTest(Method method)
    {
        ExtentTest test =  ExtentReportUtil.extent.createTest("neobankUserLoginTest").assignCategory("functional testcase");
        test.info("User login on Neobank system test ...............");

        UserLoginOnNeobankRequest userNeobankRequest = new UserLoginRequestbuilder().build();

        HttpClientAdapter<UserLoginOnNeobankRequest> client = ClientFactory.getClient(ClientType.USER, AdapterType.NEOBANK_USER_SIGNUP);

        Response neobankUserLoginResponse = SafeApiExecutorUtil.execute(client,userNeobankRequest,test);

        UserLoginOnNeobankResponse userLoginOnNeobankResponse = neobankUserLoginResponse.as(UserLoginOnNeobankResponse.class);

        PrintUtil.printOperation(userLoginOnNeobankResponse);
        test.info(userLoginOnNeobankResponse.toString());

        TestContext.setUserNeobankLoginRequest(userNeobankRequest);
        TestContext.setNeobankUserLoginResponse(userLoginOnNeobankResponse);

        ComparisionReportUtil.appendComparisonTable(userLoginOnNeobankResponse,method.getName(),test);


    }

}
