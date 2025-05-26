package abound.apitests;

import abound.clients.UserClient;
import abound.core.BaseTest;
import abound.core.ExtentReportUtil;
import api.models.UserOtpTcRequest;
import api.models.UserOtpTcResponse;
import api.utils.TestContext;
import com.aventstack.extentreports.ExtentTest;
import core.Constants;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PrintUtil;

public class UserOtpVerifyTests extends BaseTest
{

  @Test
  public void userOtpTest() {

    ExtentTest test =  ExtentReportUtil.extent.createTest("userOtpTest").assignCategory("functional testcase");
    test.info("Validation of users otp on timesclub system............");

    UserOtpTcRequest userOtp = new UserOtpTcRequest();
    userOtp.setMessageId(TestContext.getUserResponse().getMessageId());
    userOtp.setMobileNumber(TestContext.getUserRequest().getMobileNumber());
    userOtp.setOtp(Constants.otp);
    userOtp.setVerifyOtpLogin(Constants.verifyOtpLoginType);

    UserClient user = new UserClient();
    Response response = user.userVerifyOtpOnTc(userOtp);

    PrintUtil.printOperation(userOtp);
    UserOtpTcResponse userOtpTcResponse = response.as(UserOtpTcResponse.class);


    PrintUtil.printOperation(userOtpTcResponse);
    test.info(userOtpTcResponse.toString());

   TestContext.setUserOtpRequest(userOtp);
   TestContext.setUserOtpResponse(userOtpTcResponse);



  }


}
