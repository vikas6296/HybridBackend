package abound.apitests;

import abound.adapters.http.AdapterType;
import abound.adapters.http.HttpClientAdapter;
import abound.clients.ClientType;
import abound.core.ComparisionReportUtil;
import abound.core.ExtentReportUtil;
import abound.core.SafeApiExecutorUtil;
import abound.factories.ClientFactory;
import api.builders.UpdateUserDetailsBuilder;
import api.models.UpdateUserDetailsRequest;
import api.models.UpdateUserDetailsResponse;
import api.utils.HeaderManager;
import api.utils.TestContext;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PrintUtil;

import java.lang.reflect.Method;

public class NeobankUpdateUserDetailsTest
{
    @Test
    public void updateUserTest(Method method)
    {
        ExtentTest test =  ExtentReportUtil.extent.createTest("updateUserTest").assignCategory("functional testcase");
        test.info("update user on Neobank system test ...............");

        UpdateUserDetailsRequest updateUser = new UpdateUserDetailsBuilder().build();

        PrintUtil.printOperation(updateUser);
        HttpClientAdapter<UpdateUserDetailsRequest> client = ClientFactory.getClient(ClientType.USER, AdapterType.UPDATE_USER_DETAILS);

        final Response updateUserDetailsResponse = SafeApiExecutorUtil.execute(client,updateUser,test);

        PrintUtil.printOperation(HeaderManager.getDefaultHeadersForRemittanceWithBearerToken());
        UpdateUserDetailsResponse updateUserDetailsResponse1 = updateUserDetailsResponse.as(UpdateUserDetailsResponse.class);

        PrintUtil.printOperation(updateUserDetailsResponse1);

        TestContext.setUpdateUserRequest(updateUser);
        TestContext.setUpdateUserResponse(updateUserDetailsResponse1);

        ComparisionReportUtil.appendComparisonTable(updateUserDetailsResponse1,method.getName(),test);


    }
}
