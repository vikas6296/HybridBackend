package abound.apitests;

import abound.clients.UserClient;
import abound.core.AssertionUtil;
import api.models.UserSignupTcRequest;

import api.models.UserSignupTcResponse;
import api.utils.TestContext;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.DataGenerator;

public class UserTests
{

    @Test
    public void createTcNewUserTest()
    {
        UserSignupTcRequest users = new UserSignupTcRequest();
        users.setMobileNumber(DataGenerator.generateUSPhoneNumber());

        UserClient client = new UserClient();
        Response response = client.createUserOnTc(users);

        System.out.println(response.asString());

        UserSignupTcResponse user = response.as(UserSignupTcResponse.class);


        System.out.println(user);

        AssertionUtil.assertNotNull(user.getMessageId(),"message ID");

        TestContext.setUserRequest(users);
        TestContext.setUserResponse(user);


    }

}
