package abound.apitests;

import abound.clients.UserClient;
import abound.core.AssertionUtil;
import abound.core.BaseTest;
import abound.core.ComparisionReportUtil;
import abound.core.ExtentReportUtil;
import api.models.UserSignupTcRequest;

import api.models.UserSignupTcResponse;
import api.utils.TestContext;
import com.aventstack.extentreports.ExtentTest;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.DataGenerator;
import utils.PrintUtil;

import java.lang.reflect.Method;

public class UserTests extends BaseTest
{

    @Test
    public void createTcNewUserTest(Method method)
    {
           ExtentTest test =  ExtentReportUtil.extent.createTest("createTcNewUserTest").assignCategory("functional testcase");
           test.info("creation of user on timesclub system...............");

            UserSignupTcRequest users = new UserSignupTcRequest();
            users.setMobileNumber(DataGenerator.generateUSPhoneNumber());

            PrintUtil.printOperation(users);
            UserClient client = new UserClient();
            Response response = client.createUserOnTc(users);

            UserSignupTcResponse user = response.as(UserSignupTcResponse.class);

            PrintUtil.printOperation(user);
            test.info(user.toString());

            AssertionUtil.assertNotNullWithReport(user.getMessageId(),PrintUtil.printObject(user),test);

            TestContext.setUserRequest(users);
            TestContext.setUserResponse(user);

        ComparisionReportUtil.appendComparisonTable(user,method.getName(),test);


    }

}
