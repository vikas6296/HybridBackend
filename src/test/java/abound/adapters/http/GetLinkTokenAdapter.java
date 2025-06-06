package abound.adapters.http;

import abound.clients.NeobankUserClient;
import api.models.PublicTokenForAddBankRequest;
import io.restassured.response.Response;

public class GetLinkTokenAdapter implements HttpClientAdapter<Void>
{
    private final NeobankUserClient neobankUserClient;


    public GetLinkTokenAdapter(NeobankUserClient neobankUserClient) {
        this.neobankUserClient = neobankUserClient;
    }

    @Override
    public Response execute(Void request) {
        return neobankUserClient.createLinkToken();
    }
}
