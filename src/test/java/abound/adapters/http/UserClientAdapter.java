package abound.adapters.http;

import abound.clients.UserClient;
import api.models.UserOtpTcRequest;
import api.models.UserSignupTcRequest;
import io.restassured.response.Response;


public class UserClientAdapter implements HttpClientAdapter<UserSignupTcRequest>
{
    private final UserClient userClient ;

    public UserClientAdapter(UserClient userClient) {
        this.userClient = userClient;
    }


    @Override
    public Response execute(UserSignupTcRequest requestObject) {


        return userClient.createUserOnTc(requestObject);
    }



    @Override
    public Response execute(UserOtpTcRequest requestObject) {


        return userClient.userVerifyOtpOnTc(requestObject);
    }
}
