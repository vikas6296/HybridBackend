package abound.adapters.http;

import abound.clients.UserClient;
import api.models.PublicTokenForAddBankRequest;
import api.models.UserSignupTcRequest;
import io.restassured.response.Response;

public class CreateTokenAdapter implements HttpClientAdapter<PublicTokenForAddBankRequest>
{
    private final UserClient userClient;

    public CreateTokenAdapter(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public Response execute(PublicTokenForAddBankRequest request) {
        return userClient.createPublicTokenForBankAdd(request);
    }
}

