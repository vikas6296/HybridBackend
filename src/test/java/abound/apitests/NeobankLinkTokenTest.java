package abound.apitests;

import abound.clients.NeobankUserClient;
import api.models.LinktokenResponse;
import api.utils.TestContext;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PrintUtil;

public class NeobankLinkTokenTest
{

    @Test
    public void createLinkTokenTest()
    {
        NeobankUserClient neobankUserClient = new NeobankUserClient();

        Response response = neobankUserClient.createLinkToken();

        LinktokenResponse linktokenResponse = response.as(LinktokenResponse.class);

        PrintUtil.printOperation(linktokenResponse);

        TestContext.setLinktoken(linktokenResponse);

    }




}
