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
import api.models.LinktokenResponse;
import api.models.PublicTokenForAddBankRequest;
import api.utils.TestContext;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PrintUtil;

import java.lang.reflect.Method;

public class NeobankLinkTokenTest extends BaseTest
{

    @Test
    public void createLinkTokenTest(Method method)
    {
        ExtentTest test =  ExtentReportUtil.extent.createTest("createLinkTokenTest").assignCategory("functional testcase");
        test.info("Creating link token on Neobank system test ...............");



        HttpClientAdapter<Void> client =
                ClientFactory.getClient(ClientType.USER, AdapterType.GET_LINK_TOKEN);

        Response response = SafeApiExecutorUtil.execute(client,null,test);

        LinktokenResponse linktokenResponse = response.as(LinktokenResponse.class);

        PrintUtil.printOperation(linktokenResponse);
        test.info(linktokenResponse.toString());

        TestContext.setLinktoken(linktokenResponse);
        ComparisionReportUtil.appendComparisonTable(linktokenResponse,method.getName(),test);


    }




}
