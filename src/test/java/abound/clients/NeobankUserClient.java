package abound.clients;

import api.models.UserLoginOnNeobankRequest;
import api.utils.HeaderManager;
import core.Constants;
import io.restassured.response.Response;

public class NeobankUserClient
{
    public Response createLinkToken()
    {
        return BaseClient.performGet(Constants.createLinkTokenForNeobank, HeaderManager.getDefaultHeadersForTimesclub());

    }

    public Response loginUserOnNeobank(UserLoginOnNeobankRequest userLogin)
    {

        return BaseClient.performPost(Constants.createUserOnNeobank,userLogin,HeaderManager.getDefaultHeadersForRemittance());
    }

}
