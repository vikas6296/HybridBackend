package abound.clients;

import api.models.UpdateUserDetailsRequest;
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

    public Response updateUserDetails(UpdateUserDetailsRequest updateUser)
    {
        return BaseClient.performPut(Constants.updateUserDetails,updateUser,HeaderManager.getDefaultHeadersForRemittanceWithBearerToken());
    }


}
