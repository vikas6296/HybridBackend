package abound.apitests;

import abound.clients.NeobankUserClient;
import api.builders.UserLoginRequestbuilder;
import api.models.UserLoginOnNeobankRequest;
import api.models.UserLoginOnNeobankResponse;
import api.utils.TestContext;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PrintUtil;

public class NeobankUserLoginTest
{

    @Test
    public void neobankUserLoginTest()
    {
        UserLoginOnNeobankRequest userNeobankRequest = new UserLoginRequestbuilder().build();

        NeobankUserClient neobankUserClient = new NeobankUserClient();
        Response neobankUserLoginResponse = neobankUserClient.loginUserOnNeobank(userNeobankRequest);

        UserLoginOnNeobankResponse userLoginOnNeobankResponse = neobankUserLoginResponse.as(UserLoginOnNeobankResponse.class);
        PrintUtil.printOperation(userLoginOnNeobankResponse);

        TestContext.setUserNeobankLoginRequest(userNeobankRequest);
        TestContext.setNeobankUserLoginResponse(userLoginOnNeobankResponse);

    }

}
