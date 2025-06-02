package abound.factories;

import abound.adapters.http.HttpClientAdapter;
import abound.adapters.http.UserClientAdapter;
import abound.clients.UserClient;
import api.models.UserSignupTcRequest;

public class AboundFactory implements AutomationComponentFactory
{

    @Override
    public HttpClientAdapter<UserSignupTcRequest> UserClientAdapter() {
        return new UserClientAdapter(new UserClient());
    }
}
