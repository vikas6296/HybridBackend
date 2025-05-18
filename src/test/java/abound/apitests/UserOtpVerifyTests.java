package abound.apitests;

import abound.clients.UserClient;
import api.models.UserOtpTcRequest;
import api.models.UserOtpTcResponse;
import api.utils.TestContext;
import core.Constants;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserOtpVerifyTests {

  @Test
  public void userOtpTest() {
    UserOtpTcRequest userOtp = new UserOtpTcRequest();
    userOtp.setMessageId(TestContext.getUserResponse().getMessageId());
    userOtp.setMobileNumber(TestContext.getUserRequest().getMobileNumber());
    userOtp.setOtp(Constants.otp);
    userOtp.setVerifyOtpLogin(Constants.verifyOtpLoginType);

    UserClient user = new UserClient();
    Response response = user.userVerifyOtpOnTc(userOtp);

    UserOtpTcResponse userOtpTcResponse = response.as(UserOtpTcResponse.class);

    System.out.println(userOtpTcResponse.toString());

   TestContext.setUserOtpRequest(userOtp);
   TestContext.setUserOtpResponse(userOtpTcResponse);



  }


}
