package abound.adapters.http;

import abound.clients.NeobankUserClient;
import api.models.UserLoginOnNeobankRequest;
import io.restassured.response.Response;

public class NeobankUserSignupAdapter implements HttpClientAdapter<UserLoginOnNeobankRequest>
{
    private NeobankUserClient neobankUserClient;


    public NeobankUserSignupAdapter(NeobankUserClient neobankUserClient) {
        this.neobankUserClient = neobankUserClient;
    }


    @Override
    public Response execute(UserLoginOnNeobankRequest requestObject) {
        return neobankUserClient.loginUserOnNeobank(requestObject);
    }
}
