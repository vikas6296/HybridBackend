package abound.apitests;

import abound.adapters.http.AdapterType;
import abound.adapters.http.HttpClientAdapter;
import abound.clients.ClientType;
import abound.clients.UserClient;
import abound.core.BaseTest;
import abound.core.ComparisionReportUtil;
import abound.core.ExtentReportUtil;
import abound.core.SafeApiExecutorUtil;
import abound.factories.ClientFactory;
import api.builders.PublicTokenRequestBuilder;
import api.models.*;
import api.utils.TestContext;
import com.aventstack.extentreports.ExtentTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PrintUtil;

import java.lang.reflect.Method;

public class TokenCreateAndBankAdd extends BaseTest
{

    @Test
    public void createPublicTokenTest(Method method) {

        ExtentTest test =  ExtentReportUtil.extent.createTest("createPublicTokenTest").assignCategory("functional testcase");
        test.info("creating public token for bankadd for user on timesclub system............");

    PublicTokenForAddBankRequest publicToken = PublicTokenRequestBuilder.defaultRequest();

        HttpClientAdapter<PublicTokenForAddBankRequest> client =
                ClientFactory.getClient(ClientType.USER, AdapterType.GET_PUBLIC_TOKEN);

        Response response = SafeApiExecutorUtil.execute(client,publicToken,test);


    PublicTokenForAddBankResponse publicTokenResponse = response.as(PublicTokenForAddBankResponse.class);
    PrintUtil.printOperation(publicTokenResponse);
    test.info(publicTokenResponse.toString());

    TestContext.setPublicTokenContextRequest(publicToken);
    TestContext.publicTokenForAddBankResponse(publicTokenResponse);

        ComparisionReportUtil.appendComparisonTable(publicTokenResponse,method.getName(),test);


    }

@Test(dependsOnMethods = "createPublicTokenTest" )
    public void addBankForUser(Method method) throws JsonProcessingException {
    ExtentTest test =  ExtentReportUtil.extent.createTest("addBankForUser").assignCategory("functional testcase");
    test.info("Bank add test for user on timesclub system............");

    AddBankRequest addBank = new AddBankRequest();
    addBank.setPublicToken(TestContext.publicTokenResponse().getPublicToken());

    UserClient uc = new UserClient();
    Response response = uc.addBankForUser(addBank);

   /* ObjectMapper mapper = new ObjectMapper();
    AddBankResponse adbResponse = mapper.readValue(response.getBody().asString(), AddBankResponse.class);*/

    AddBankResponse adbResponse = response.as(AddBankResponse.class);
    PrintUtil.printOperation(adbResponse);
    test.info(adbResponse.toString());
    TestContext.setAddBankRequestContext(addBank);
    TestContext.setAddBankResponseContext(adbResponse);

    ComparisionReportUtil.appendComparisonTable(adbResponse,method.getName(),test);


}




}
