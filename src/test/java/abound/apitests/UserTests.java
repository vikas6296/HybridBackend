package abound.apitests;

import abound.adapters.http.AdapterType;
import abound.adapters.http.HttpClientAdapter;
import abound.annotations.AutoWire;
import abound.annotations.Injector;
import abound.clients.ClientType;
import abound.clients.UserClient;
import abound.core.*;
import abound.factories.ClientFactory;
import api.models.UserSignupTcRequest;

import api.models.UserSignupTcResponse;
import api.utils.TestContext;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.DataGenerator;
import utils.PrintUtil;

import java.lang.reflect.Method;

public class UserTests extends BaseTest
{

    @AutoWire
    UserSignupTcRequest users;

    @BeforeMethod
    public void dependencyInjection()
    {
        Injector.inject(this);
    }

    @Test
    public void createTcNewUserTest(Method method)
    {
           ExtentTest test =  ExtentReportUtil.extent.createTest("createTcNewUserTest").assignCategory("functional testcase");
           test.info("creation of user on timesclub system...............");

           // UserSignupTcRequest users = new UserSignupTcRequest();
            users.setMobileNumber(DataGenerator.generateUSPhoneNumber());

            PrintUtil.printOperation(users);

//        @SuppressWarnings("unchecked")
//        HttpClientAdapter<UserSignupTcRequest> client =
//                (HttpClientAdapter<UserSignupTcRequest>) ClientFactory.getClient(ClientType.USER);

        HttpClientAdapter<UserSignupTcRequest> client =
                ClientFactory.getClient(ClientType.USER, AdapterType.USER_SIGNUP);

          Response response = SafeApiExecutorUtil.execute(client,users,test);

            UserSignupTcResponse user = response.as(UserSignupTcResponse.class);

            PrintUtil.printOperation(user);
            test.info(user.toString());

            AssertionUtil.assertNotNullWithReport(user.getMessageId(),PrintUtil.printObject(user),test);

            TestContext.setUserRequest(users);
            TestContext.setUserResponse(user);

        ComparisionReportUtil.appendComparisonTable(user,method.getName(),test);


    }

}
