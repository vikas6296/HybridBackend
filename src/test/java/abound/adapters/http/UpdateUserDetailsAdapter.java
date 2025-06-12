package abound.adapters.http;

import abound.clients.NeobankUserClient;
import api.models.UpdateUserDetailsRequest;
import io.restassured.response.Response;

public class UpdateUserDetailsAdapter implements HttpClientAdapter<UpdateUserDetailsRequest>
{
   private NeobankUserClient neobankUserClient;

    public UpdateUserDetailsAdapter(NeobankUserClient neobankUserClient) {
        this.neobankUserClient = neobankUserClient;
    }


    @Override
    public Response execute(UpdateUserDetailsRequest requestObject) {
        return neobankUserClient.updateUserDetails(requestObject);
    }
}
