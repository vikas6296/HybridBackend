package abound.clients;

import api.models.AddBankRequest;
import api.models.PublicTokenForAddBankRequest;
import api.models.UserOtpTcRequest;
import api.models.UserSignupTcRequest;
import api.utils.HeaderManager;
import core.Constants;
import io.restassured.response.Response;

public class UserClient
{

   public Response createUserOnTc(UserSignupTcRequest user)
   {

       return BaseClient.performPost(Constants.userCreation,user, HeaderManager.getDefaultHeadersForTimesclubForNewUser());

   }

   public Response userVerifyOtpOnTc(UserOtpTcRequest userOtp)
   {
       return BaseClient.performPost(Constants.userVerifyOtp,userOtp,HeaderManager.getDefaultHeadersForTimesclubForNewUser());

   }


    public Response createPublicTokenForBankAdd(PublicTokenForAddBankRequest publicToken)
    {
        return BaseClient.performPost(Constants.createPublicLinkToken,publicToken,HeaderManager.getDefaultHeadersForPublicApi());

    }

    public Response addBankForUser(AddBankRequest addBank)
    {
        return BaseClient.performPost(Constants.addBank,addBank,HeaderManager.getDefaultHeadersForTimesclub());

    }



}
