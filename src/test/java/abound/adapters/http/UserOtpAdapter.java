package abound.adapters.http;

import abound.clients.UserClient;
import api.models.UserOtpTcRequest;
import io.restassured.response.Response;

public class UserOtpAdapter implements HttpClientAdapter<UserOtpTcRequest>
{
    private final UserClient userClient;

    public UserOtpAdapter(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public Response execute(UserOtpTcRequest requestObject) {
        return userClient.userVerifyOtpOnTc(requestObject);
    }


}
