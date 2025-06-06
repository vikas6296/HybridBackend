package abound.adapters.http;

import abound.clients.UserClient;
import api.models.UserSignupTcRequest;
import io.restassured.response.Response;

public class UserSignupAdapter  implements HttpClientAdapter<UserSignupTcRequest>
{

    private final UserClient userClient;

    public UserSignupAdapter(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public Response execute(UserSignupTcRequest requestObject) {
        return userClient.createUserOnTc(requestObject);
    }


}
