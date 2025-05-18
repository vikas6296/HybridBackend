/*
package abound.neobank.services;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;


import abound.neobank.utilities.Log4jClass;
import com.aventstack.extentreports.ExtentTest;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;

public class SignupAndKycFlow extends RequestPayload{

public static String linkToken;

	public static String jwtToken;

	public static String validEmail;

	public static String loginToken;

	public static String phoneNumber;

	public static String nodeId;
	public static String phoneNumberForGetToken;

	public static String messageId;

	public static String deviceId;

	public static String linkTokenSecondHit;

	public static String otp;

	public static String cardDetails;

	public static String accountDetails;

	public static String firstName;

	public static String lastName;

	public static String accountId;


	public static String achMessage;

	public static int userIdOfTc;
	public static String customerId;

	public static String publicLinkToken;

	public static String externalsubnetid;

	public static String kycStatus;

	public static String host;

	public static String timesclubHost;

	public static String invalidLT="d19b11aca134874fa9a8aea9a0e4d1ba";

	public static String usersPath;

	public static String bankPath;

	public static String linkTokenForCMATxn;

	public static String messageIdForLogin;

	public static String jwtForLoginUser;

	public static String messageIdForTc;

	public static String loginTokenForLogInUserUsingMobileNumber;

	public static String verifyOtpForSignupWithMobileno;

	public static String deviceIdForEliteUser;

	public static String linkTokenForEliteUser;
	public static String messageIdForTcForElite;
	public static String jwtForElite;
	public static String loginTokenForLogInUserUsingMobileNumberForElite;

	public static String messageIdForNeobankForElite;




	RequestPayload request=new RequestPayload();


	public static Map<String,String> headersFiles()
	{
		Map<String,String>headers=new HashMap<String,String>();

		headers.put("Content-Type", "application/json");

		headers.put("device-id", deviceId);

		headers.put("link-token", linkToken);

		headers.put("customer-id", customerId);

		headers.put("user_type", "PRIMARY");

		headers.put("source", "BANKING");

		return headers;


	}

	public static Response tcLinkToken()

	{

		String baseURI=""+timesclubHost+"plaid/neo-bank/link/token/v1";

		System.out.println("******************"+baseURI);

		HashMap<String,String> requestHeaders=new HashMap<String,String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("Authorization", "Bearer "+loginToken);

		requestHeaders.put("device-id", deviceId);

		requestHeaders.put("isTokenRotationON", "true");

		requestHeaders.put("Nb-Sso-Enabled", "true");

		requestHeaders.put("User-Agent", "IOS Darwin");

	//	requestHeaders.put("user_type", "PRIMARY");

		System.out.println("logintoken"+loginToken);

		System.out.println("requestHeaders "+requestHeaders);

		Response response = given().headers(requestHeaders).get(baseURI);

		String responseText = response.asString();

		System.out.println("response of linktoken --> "+response.getStatusCode());

		Log4jClass.fn_logger_info("Response :"+responseText);

		linkToken=response.jsonPath().getString("linkToken").toString();

		response.jsonPath().get("linkToken").toString().contains(".*");

		System.out.println("linktokennnnnnnnnn"+linkToken);


		System.out.println("all data for new user-----> device id"+deviceId+"linktoken--> "+linkToken+"customer id --->"+customerId+"");

		return response;
	}




		public static Response userSignupService()

		{

			String baseURI=""+host+""+usersPath+"/signup/v1";

			System.out.println("usersignup service "+baseURI);
			HashMap<String,String> requestHeaders=new HashMap<String,String>();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("device-id", deviceId);

            requestHeaders.put("link-token", linkToken);

			requestHeaders.put("customer-id", customerId);

			requestHeaders.put("isTokenRotationON", "true");

			requestHeaders.put("Nb-Sso-Enabled", "true");

			requestHeaders.put("User-Agent", "IOS Darwin");

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("source", "BANKING");

			RequestPayload request=new RequestPayload();


			Response response = given().headers(requestHeaders).body(request.userSignUpService).post(baseURI);

			System.out.println("requestpyload of usersignup service "+request.userSignUpService);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response :"+responseText);

			messageId=response.jsonPath().getString("messageId");

			response.jsonPath().get("messageId").toString().contains("[A-Za-z0-9]*");

			return response;


		}

		public static Response userSignupServiceWithInValidToken()

		{

			String baseURI=""+host+""+usersPath+"/signup/v1";

			System.out.println("usersignup service "+baseURI);
			HashMap<String,String> requestHeaders=new HashMap<String,String>();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("device-id", deviceId);

            requestHeaders.put("link-token", invalidLT);

			requestHeaders.put("customer-id", customerId);

			requestHeaders.put("isTokenRotationON", "true");

			requestHeaders.put("Nb-Sso-Enabled", "true");

			requestHeaders.put("User-Agent", "IOS Darwin");

			requestHeaders.put("user_type", "PRIMARY");

			RequestPayload request=new RequestPayload();


			Response response = given().headers(requestHeaders).body(request.userSignUpService).post(baseURI);

			System.out.println("requestpyload of usersignup service "+request.userSignUpService);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response :"+responseText);



			return response;


		}

		public static Response userSignupServiceForLogout()

		{

			String baseURI=""+host+""+usersPath+"/signup/v1";

			System.out.println("userSignupServiceForLogout url "+baseURI);

			HashMap<String,String> requestHeaders=new HashMap<String,String>();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("device-id", deviceId);

            requestHeaders.put("link-token", linkToken);

			requestHeaders.put("customer-id", customerId);
			requestHeaders.put("user_type", "PRIMARY");

			RequestPayload request=new RequestPayload();


			Response response = given().headers(requestHeaders).body(request.userSignUpService).post(baseURI);

			System.out.println("requestpyload of usersignup service "+request.userSignUpService);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response :"+responseText);

			messageId=response.jsonPath().getString("messageId");

			return response;


		}

		public static Response sendOTPService()

		{
			String baseURI=""+host+""+usersPath+"/send-otp/v1";

			HashMap<String,String> requestHeaders=new HashMap<String,String>();

			requestHeaders.put("Content-Type", "application/json");


			requestHeaders.put("device-id", deviceId);

            requestHeaders.put("link-token", linkToken);

			requestHeaders.put("customer-id", customerId);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("source", "BANKING");

			RequestPayload request=new RequestPayload();

			Response response = given().headers(requestHeaders).body(request.sendOTPService).post(baseURI);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response :"+responseText);

			return response;
		}


		public static  Response verifyOTPService()

		{
			String baseURI=""+host+""+usersPath+"/verify-otp/v1";
			HashMap<String,String> requestHeaders=new HashMap<String,String>();

			requestHeaders.put("Content-Type", "application/json");
			requestHeaders.put("device-id", deviceId);

            requestHeaders.put("link-token", linkToken);

			requestHeaders.put("customer-id", customerId);

			requestHeaders.put("user_type", "PRIMARY");

			 otp=getOTPService();

			RequestPayload request=new RequestPayload();

			Response response = given().headers(requestHeaders).body(request.verifyOTPService).post(baseURI);

			String responseText = response.asString();


			Log4jClass.fn_logger_info("response of verifyOTP :"+responseText);


			Log4jClass.fn_logger_info("invalidLT :"+invalidLT);

			Log4jClass.fn_logger_info("invalidLT :"+invalidLT);

			requestHeaders.put("source", "BANKING");


			Log4jClass.fn_logger_info("status code :"+response.statusCode());
			//jwtToken=response.getHeader("Auth-Token").toString();




			System.out.println("jwtToken is  "+jwtToken);
			System.out.println("linkToken is  "+linkToken);
			System.out.println("customerId is  "+customerId);
			System.out.println("deviceId is  "+deviceId);

			jwtToken=response.jsonPath().getString("jwtToken").toString();

			response.jsonPath().get("jwtToken").toString().contains(".*");

			 responseText = response.asString();


			Log4jClass.fn_logger_info("Response :"+responseText);

			return response;


		}

		public static Response validateAddressService()
		{
			String baseURI=""+host+""+usersPath+"/validate-update-address/v1?address_type=KYC_ADDRESS";

			HashMap<String,String> requestHeaders=new HashMap<String,String>();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("Authorization", "Bearer "+jwtToken);

			requestHeaders.put("device-id", deviceId);

            requestHeaders.put("link-token", linkToken);

			requestHeaders.put("customer-id", customerId);

			requestHeaders.put("source", "BANKING");
			requestHeaders.put("user_type", "PRIMARY");
			RequestPayload request=new RequestPayload();


			Response response = given().headers(requestHeaders).body(request.addressService).post(baseURI);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response :"+responseText);

			return response;

		}


		public static Response validateSSNService()

		{

			//String ssn=randomSSNGenerator();
		//	System.out.println("ssn number----------------->"+ssn);
			String baseURI=""+host+""+usersPath+"/validate-ssn/v1";
			System.out.println("baseURI--> "+baseURI);
			HashMap<String,String> requestHeaders=new HashMap<String,String>();

			requestHeaders.put("Content-Type", "application/json");
			requestHeaders.put("Authorization", "Bearer "+jwtToken);
			requestHeaders.put("device-id", deviceId);

            requestHeaders.put("link-token", linkToken);

			requestHeaders.put("customer-id", customerId);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("source", "BANKING");
			RequestPayload r=new RequestPayload();

			Response response = given().headers(requestHeaders).body(r.ssnPayload).post(baseURI);
			String responseText = response.asString();
			Log4jClass.fn_logger_info("Response :"+responseText);

			return response;
		}



		public static Response newUser()
		{

			String baseURI=""+timesclubHost+"users/signup-with-mobile";
			System.out.println("tc signup URL -->>"+baseURI);

			HashMap<String,String> requestHeaders=new HashMap<String,String>();
			requestHeaders.put("Content-Type", "application/json");
			requestHeaders.put("device-id", deviceId);
			requestHeaders.put("User-Agent", "IOS Darwin");

			validEmail=randomGenerator();
			phoneNumber=randomPhoneNumberForLayer2();
			deviceId=randomDeviceId();
			phoneNumberForGetToken=phoneNumber;
			RequestPayload request=new RequestPayload();


			Response response = given().headers(requestHeaders).body(request.timesClubUserSignupService).post(baseURI);
			String responseText = response.asString();
			Log4jClass.fn_logger_info("Response :"+responseText);

			verifyOtpForSignupWithMobileno = JsonPath.read(responseText,"$.message_id");

			Log4jClass.fn_logger_info("new user created");

			return response;

		}

		public static void verifyOtpForMobileNumberUser() throws InterruptedException {
			String baseURI=""+timesclubHost+"users/verify-otp-login";
			System.out.println("tc signup URL -->>"+baseURI);

			HashMap<String,String> requestHeaders=new HashMap<String,String>();
			requestHeaders.put("Content-Type", "application/json");
			requestHeaders.put("device-id", deviceId);
			requestHeaders.put("User-Agent", "IOS Darwin");

			RequestPayload request=new RequestPayload();

			Response response = given().headers(requestHeaders).body(request.verifyOtpServicePayload).post(baseURI);
			System.out.println("payload of verifyOtp "+request.verifyOtpServicePayload);
			String responseText = response.asString();
			Log4jClass.fn_logger_info("Response :"+responseText);


			String successfulMessage = JsonPath.read(responseText,"$.message");

			System.out.println("successful message for mobile no verification" + successfulMessage);

			loginToken = JsonPath.read(responseText,"$.token");

			customerId = JsonPath.read(responseText,"$.user.customer_id");

			userIdOfTc = JsonPath.read(responseText,"$.user.id");


			Log4jClass.fn_logger_info("new user created");

			Log4jClass.fn_logger_info("new session created");

			createPublicTokenForBank();
			addBankItem();

		}



public static Response createNewSession() throws InterruptedException

		{

			String baseURI=""+timesclubHost+"users/login/v1/";
			System.out.println("tc login URL -->>"+baseURI);
			HashMap<String,String> requestHeaders=new HashMap<String,String>();
			requestHeaders.put("Content-Type", "application/json");
			requestHeaders.put("device-id", deviceId);

			requestHeaders.put("link-token", linkToken);

		    requestHeaders.put("customer-id", customerId);

			RequestPayload request=new RequestPayload();


			Response response = given().headers(requestHeaders).body(request.createNewService).post(baseURI);
			String responseText = response.asString();
			Log4jClass.fn_logger_info("Response :"+responseText);

			loginToken=response.jsonPath().getString("token").toString();



			response.jsonPath().get("token").toString().contains(".*");

			Map<Object, Object> user = response.jsonPath().getMap("user");

			customerId=user.get("customer_id").toString();
			userIdOfTc=Integer.parseInt(user.get("id").toString());

			System.out.println("customerIddddddddddddd");



			Log4jClass.fn_logger_info("token---->"+loginToken);

			Log4jClass.fn_logger_info("new session created");

			createPublicTokenForBank();
			addBankItem();

			return response;

		}




		public static Response updateUser () throws Exception

		{

			String baseURI=""+host+""+usersPath+"/update/v1";
			HashMap<String,String> requestHeaders=new HashMap<String,String>();
			requestHeaders.put("Content-Type", "application/json");
			requestHeaders.put("Authorization", "Bearer "+jwtToken);
			requestHeaders.put("device-id", deviceId);
			   requestHeaders.put("link-token", linkToken);

				requestHeaders.put("customer-id", customerId);
				requestHeaders.put("source", "BANKING");
				requestHeaders.put("user_type", "PRIMARY");

			firstName=randomFirstName();
			lastName=randomLastName();
			RequestPayload request=new RequestPayload();

			Response response = given().headers(requestHeaders).body(request.updateUserService).put(baseURI);
			String responseText = response.asString();
			Log4jClass.fn_logger_info("Response :"+responseText);
			System.out.println("request is" +request);
			System.out.println("requestUUUU is" +request.updateUserService);
			System.out.println("response is" +response);
			System.out.println("jwt is" +jwtToken);



			return response;

		}



		public static String randomGenerator()


		{

			Random random=new Random();
			int number=random.nextInt(100000);
		    String email="Neo"+number+"bank"+"@yahoo.com";
			//String email=""+number;
			return email;

		}

		public static Response signUpWithoutJWTandLT()

		{
			String baseURI=""+host+""+usersPath+"/signup/v1";
			HashMap<String,String> requestHeaders=new HashMap<String,String>();
			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("device-id", deviceId);

			   requestHeaders.put("link-token", linkToken);

				requestHeaders.put("customer-id", customerId);

				requestHeaders.put("user_type", "PRIMARY");

			RequestPayload request=new RequestPayload();



			Response response = given().headers(requestHeaders).body(request.signUpWithoutJWT).post(baseURI);
			String responseText = response.asString();
			Log4jClass.fn_logger_info("Response :"+responseText);

			return response;

		}

		public static Response verifyOTPServiceWithoutJWT()

		{

			String baseURI=""+host+""+usersPath+"/send-otp/v1";

			HashMap<String,String> requestHeader=new HashMap<String,String>();

			requestHeader.put("Content-Type", "application/json");
			requestHeader.put("device-id", deviceId);

			    requestHeader.put("link-token", linkToken);

				requestHeader.put("customer-id", customerId);
			RequestPayload request=new RequestPayload();

			Response response = given().headers(requestHeader).body(request.otpServicesWithoutJWT).post(baseURI);
			String responseText = response.asString();
			Log4jClass.fn_logger_info("Response :"+responseText);

			return response;



		}

		public static String randomPhoneNumber()
		{

			Random c=new Random();
			int number=ThreadLocalRandom.current().nextInt(10000, 99999);
			int secondNumber=ThreadLocalRandom.current().nextInt(10000, 99999);

			String phoneNumberGenerated="+1"+number+""+secondNumber+"";

			return phoneNumberGenerated;
		}


		public static String getPhoneNumber()
		{
			Random random=new Random();
			int number=ThreadLocalRandom.current().nextInt(10000, 99999);
			int secondNumber=ThreadLocalRandom.current().nextInt(10000, 99999);

			String phoneNumberGenerated="+1"+number+""+secondNumber+"";

			return phoneNumberGenerated;
		}


	    public static Response otpServiceInvalidEmailidAndAuthorizatiosn()
	    {
	        String baseURI=""+host+""+usersPath+"/send-otp/v1";

			HashMap<String,String> requestHeader=new HashMap<String,String>();

			requestHeader.put("Content-Type", "application/json");
			requestHeader.put("device-id", deviceId);
			   requestHeader.put("link-token", linkToken);

				requestHeader.put("customer-id", customerId);

				requestHeader.put("user_type", "PRIMARY");

			RequestPayload request=new RequestPayload();


			Response response = given().headers(requestHeader).body(request.otpServiceInvalidEmailidAndAuthorizatiosn).post(baseURI);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response :"+responseText);

			return response;
	    }

	    public static Response ssnServiceWithOInvalidSSN()

	    {
	        String baseURI=""+host+""+usersPath+"/validate-ssn/v1";

			HashMap<String,String> requestHeader=new HashMap<String,String>();

			requestHeader.put("Content-Type", "application/json");
			requestHeader.put("device-id", deviceId);
			   requestHeader.put("link-token", linkToken);

				requestHeader.put("customer-id", customerId);

				requestHeader.put("user_type", "PRIMARY");


			Response response = given().headers(requestHeader).queryParam("ssn_number", "123456690").post(baseURI);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response :"+responseText);

			return response;

	    }



	    public static Response getKYCService()

	    {

			Response response;

			while(true)
	    {
	        String baseURI=""+host+""+usersPath+"/kycstatus/v1";

			HashMap<String,String> requestHeader=new HashMap<String,String>();

			requestHeader.put("Content-Type", "application/json");
			requestHeader.put("device-id", deviceId);
			requestHeader.put("Authorization", "Bearer "+jwtToken);

			   requestHeader.put("link-token", linkToken);

				requestHeader.put("customer-id", customerId);

				requestHeader.put("user_type", "PRIMARY");
			 response = given().headers(requestHeader).get(baseURI);

			 String responseText = response.asString();

				Log4jClass.fn_logger_info("Response :"+responseText);

		kycStatus=response.jsonPath().getString("kyc_status").toString();

		response.jsonPath().get("kyc_status").toString().contains(".*");

		 if(kycStatus.equals("VERIFIED"))

		 {

			 responseText = response.asString();

			 Log4jClass.fn_logger_info("Response :"+responseText);

			 break;

		 }



	    }
	    return response;

	    }



	 public static Response getKYCServiceWithoutJWT()

	    {

	        String baseURI=""+host+""+usersPath+"/kycstatus/v1";

			HashMap<String,String> requestHeader=new HashMap<String,String>();

			requestHeader.put("Content-Type", "application/json");
			requestHeader.put("device-id", deviceId);

			   requestHeader.put("link-token", linkToken);

				requestHeader.put("customer-id", customerId);


			Response response = given().headers(requestHeader).get(baseURI);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response :"+responseText);

			return response;


	    }



	 public static Response getKYCServiceWithoutDeviceId()

	    {

	        String baseURI=""+host+""+usersPath+"/kycstatus/v1";

			HashMap<String,String> requestHeader=new HashMap<String,String>();

			requestHeader.put("Content-Type", "application/json");

			   requestHeader.put("link-token", linkToken);

				requestHeader.put("customer-id", customerId);

			Response response = given().headers(requestHeader).get(baseURI);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response :"+responseText);

			return response;


	    }




	    public static Response validteAdressServiceOnWrongAddress()

	    {

	   	String baseURI=""+host+""+usersPath+"/validate-update-address/v1?address_type=KYC_ADDRESS";

		HashMap<String,String> requestHeader=new HashMap<String,String>();

		requestHeader.put("Content-Type", "application/json");

		requestHeader.put("device-id", deviceId);

		requestHeader.put("Authorization", "Bearer "+jwtToken);

		   requestHeader.put("link-token", linkToken);

					requestHeader.put("customer-id", customerId);


		RequestPayload request=new RequestPayload();


		Response response = given().headers(requestHeader).body(request.validteAdressServiceOnWrongAddress).post(baseURI);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response :"+responseText);

		return response;

	    }


	    public static Response validateValidSSsNumber()
	    {


	    	String baseURI=""+host+""+usersPath+"/validate-ssn/v1";

	    	HashMap<String,String> requestHeader=new HashMap<String,String>();

	    	requestHeader.put("Content-Type", "application/json");

	    	requestHeader.put("device-id", deviceId);

	    	requestHeader.put("Authorization", "Bearer "+jwtToken);

	    	   requestHeader.put("link-token", linkToken);

	    	   requestHeader.put("user_type", "PRIMARY");
				requestHeader.put("customer-id", customerId);

	    	Response response = given().headers(requestHeader).queryParam("ssn_number", "233-22-3333").post(baseURI);

	    	String responseText = response.asString();

	    	Log4jClass.fn_logger_info("Response :"+responseText);

	    	return response;

	    }



	    public static Response validateUpdateServiceByPassingInvalidToken()

	    {

	    	String baseURI=""+host+""+usersPath+"/update/v1";

	    	HashMap<String,String> requestHeader=new HashMap<String,String>();

	    	requestHeader.put("Content-Type", "application/json");

	    	requestHeader.put("device-id", deviceId);

	    	requestHeader.put("Authorization", "Bearer "+jwtToken+deviceId);

	    	   requestHeader.put("link-token", linkToken);

				requestHeader.put("customer-id", customerId);

	    	RequestPayload request=new RequestPayload();

			Response response = given().headers(requestHeader).body(request.validateUpdateServiceByPassingInvalidToken).post(baseURI);

	    	String responseText = response.asString();

	    	Log4jClass.fn_logger_info("Response :"+responseText);

	    	return response;
	    }

	    public static Response validateNeobankLoginService() throws Exception

	    {

	    	//SignupAndKycFlow.tcLinkToken();

			String baseURI=""+host+""+usersPath+"/login/v1";

	    	HashMap<String,String> requestHeader=new HashMap<String,String>();

	    	requestHeader.put("Content-Type", "application/json");

	    	requestHeader.put("device-id", deviceId);

	    	requestHeader.put("link-token", linkToken);

			requestHeader.put("customer-id", customerId);

			requestHeader.put("user_type", "PRIMARY");

	    	Response response = given().headers(requestHeader).post(baseURI);

	    	String responseText = response.asString();

	    	Log4jClass.fn_logger_info("Response :"+responseText);

	    	return response;


	    }

	    public static Response validateNeobankLoginServiceNegative() throws Exception

	    {

          	String baseURI=""+host+""+usersPath+"/login/v1";

	    	HashMap<String,String> requestHeader=new HashMap<String,String>();

	    	requestHeader.put("Content-Type", "application/json");

	    	requestHeader.put("device-id", deviceId);

	    	requestHeader.put("Authorization", "Bearer "+jwtToken+deviceId);

	    	requestHeader.put("link-token", linkToken);

		    requestHeader.put("customer-id", customerId);

		    Response response = given()
	    	.headers(requestHeader)
	    	.post(baseURI);

	    	String responseText = response.asString();

	    	Log4jClass.fn_logger_info("Response :"+responseText);

	    	return response;

	    }


	    public static String randomDeviceId()

	    {

	    	Random random=new Random();
			int number=random.nextInt(100);
		    String email="vikas"+number+"91"+number+"@gmail.com";
			return email;

	    }


	    public static Response validateWhenSameUserIsLoggedInWithAnotherDevice()

	    {

	    	Response response=userSignupServiceForLogout();

	    	System.out.println(response.asString());

	    	return response;

	    }

	    public static Response validateWhenLongitudeAndlongitudeIsNotPassedInSignUpService()

	    {

	          String baseURI=""+host+""+usersPath+"/signup/v1";

			  HashMap<String,String> requestHeaders=new HashMap<String,String>();

			  requestHeaders.put("Content-Type", "application/json");

			  requestHeaders.put("device-id", deviceId);

			   requestHeaders.put("link-token", linkToken);

				requestHeaders.put("customer-id", customerId);

				RequestPayload request=new RequestPayload();

			Response response = given().headers(requestHeaders).body(request.validateWhenLongitudeAndlongitudeIsNotPassedInSignUpService).post(baseURI);

			String responseText = response.asString();


			return response;

	    }

	    public static boolean validateWetherLinkTokenCanBeGeneratedMultipleTimes()
	    {


	    	String baseURI=""+timesclubHost+"/plaid/neo-bank/link/token/v1";

	    	HashMap<String,String> requestHeaders=new HashMap<String,String>();

	    	requestHeaders.put("Content-Type", "application/json");

	    	requestHeaders.put("Authorization", "Bearer "+loginToken);

	    	requestHeaders.put("device-id", deviceId);

	    	requestHeaders.put("user_type", "PRIMARY");

			Response response = given().headers(requestHeaders).get(baseURI);

	    	String responseText = response.asString();

	    	Log4jClass.fn_logger_info("Response :"+responseText);

	    	linkTokenSecondHit=response.jsonPath().getString("linkToken").toString();


	    	if(linkToken.contains(linkTokenSecondHit))
	         return true;

	    	return false;

	    }

	    public static Response updateUserServiceNegative()
	    {
	        String baseURI=""+host+""+usersPath+"/update/v1";

	    	HashMap<String,String> requestHeader=new HashMap<String,String>();

	    	requestHeader.put("Content-Type", "application/json");

	    	requestHeader.put("device-id", deviceId);

	    	   requestHeader.put("link-token", linkToken);

				requestHeader.put("customer-id", customerId);

	    	RequestPayload request=new RequestPayload();

			Response response = given().headers(requestHeader).body(request.updateUserServiceNegative).post(baseURI);

	    	String responseText = response.asString();

	    	Log4jClass.fn_logger_info("Response :"+responseText);

	    	return response;

	    }


	    public static Response validationOfLogoutService()

	    {

	    	String baseURI=""+host+""+usersPath+"/logout/v1";

	     	HashMap<String,String> requestHeader=new HashMap<String,String>();

	     	requestHeader.put("Content-Type", "application/json");

	     	requestHeader.put("device-id", deviceId);

	     	requestHeader.put("Authorization", "Bearer "+jwtToken);

	        requestHeader.put("link-token", linkToken);

	        requestHeader.put("customer-id", customerId);

	        requestHeader.put("user_type", "PRIMARY");

	     	Response response = given().headers(requestHeader).post(baseURI);

	     	String responseText = response.asString();

	     	Log4jClass.fn_logger_info("Response :"+responseText);

	     	return response;

	    }

	    public static Response validationOfLogoutServiceNegative()

	    {

	        String baseURI=""+host+""+usersPath+"/logout/v1";

	     	HashMap<String,String> requestHeader=new HashMap<String,String>();

	     	requestHeader.put("Content-Type", "application/json");

	     	requestHeader.put("device-id", deviceId);

	        requestHeader.put("link-token", linkToken);

	        requestHeader.put("customer-id", customerId);

	     	Response response = given().headers(requestHeader).post(baseURI);

	     	String responseText = response.asString();

	     	Log4jClass.fn_logger_info("Response :"+responseText);

	     	return response;

		}


		public static Response validationOfLogoutServiceOnHittingMultipleTimes()
		{

			Response response=null;


			for(int i=0;i<10;i++)

			{

				 String baseURI=""+host+""+usersPath+"/logout/v1";

			     HashMap<String,String> requestHeader=new HashMap<String,String>();

			     requestHeader.put("Content-Type", "application/json");

			     requestHeader.put("device-id", deviceId);

			     requestHeader.put("Authorization", "Bearer "+jwtToken);

			     requestHeader.put("link-token", linkToken);

				 requestHeader.put("customer-id", customerId);

			     response = given().headers(requestHeader).post(baseURI);

			     String responseText = response.asString();

			     Log4jClass.fn_logger_info("Response :"+responseText);


			}

			return response;
		}

		public static Response validationOfNeobankSynapseService()

		{

	        String baseURI=""+host+""+usersPath+"/signup/synapsefi/v1";

	    	HashMap<String,String> requestHeaders=new HashMap<String,String>();

	    	requestHeaders.put("Content-Type", "application/json");
	    	requestHeaders.put("user_type", "PRIMARY");
	    	requestHeaders.put("Authorization", "Bearer "+jwtToken);

	    	requestHeaders.put("device-id", deviceId);


			requestHeaders.put("link-token", linkToken);

			requestHeaders.put("customer-id", customerId);

	    	String RequestPayload="{}";

	    	Response response = given().headers(requestHeaders).body(RequestPayload).post(baseURI);

	    	String responseText = response.asString();

	    	Log4jClass.fn_logger_info("Response :"+responseText);

	    	return response;

		}

		public static Response OnPssingInvalidLinkTokenInNeobankSynapseService()

		{

	        String baseURI=""+host+""+usersPath+"/signup/synapsefi/v1";

	    	HashMap<String,String> requestHeaders=new HashMap<String,String>();

	    	requestHeaders.put("Content-Type", "application/json");

	    	requestHeaders.put("Authorization", "Bearer "+jwtToken);

	    	requestHeaders.put("device-id", deviceId);

	        requestHeaders.put("link-token", "d19b11aca134874fa9a8aea9a0e4d1ba");

		    requestHeaders.put("customer-id", customerId);

	    	String RequestPayload="{}";

	    	Response response = given().headers(requestHeaders).body(RequestPayload).post(baseURI);

	    	String responseText = response.asString();

	    	Log4jClass.fn_logger_info("Response :"+responseText);

	    	return response;

		}

		public static Response validtionOfNeobankSynapseServiceNegative()

		{
			  String baseURI=""+host+""+usersPath+"/signup/synapsefi/v1";

		    	HashMap<String,String> requestHeaders=new HashMap<String,String>();

		    	requestHeaders.put("Content-Type", "application/json");

		    	requestHeaders.put("device-id", deviceId);

		    	requestHeaders.put("link-token", linkToken);

					requestHeaders.put("customer-id", customerId);

		    	String RequestPayload="{}";

		    	Response response = given().headers(requestHeaders).body(RequestPayload).post(baseURI);

		    	String responseText = response.asString();

		    	Log4jClass.fn_logger_info("Response :"+responseText);

		    	return response;
		}






	public static String getOTPService()

	{
		System.out.println("message id --------->"+messageId);

		String baseURI=""+host+""+usersPath+"/utility/decrypt-otp?message_id="+messageId+"";

		System.out.println("URL *****************"+baseURI);

	 	HashMap<String,String> requestHeaders=new HashMap<String,String>();

	 	requestHeaders.put("Content-Type", "application/json");

	 	requestHeaders.put("device-id", deviceId);

	 	System.out.println("device id **************"+deviceId);

	 	Response response = given().headers(requestHeaders).get(baseURI);

	 	System.out.println("response code of getOTPservices------------->"+response.getStatusCode());

	 	System.out.println("response of getOTPServices---------"+response.asString());

	 	String responseText = response.asString();

	 	otp=response.jsonPath().getString("response").toString();

	 	Log4jClass.fn_logger_info("Response :"+responseText);

	 	return otp;

	}



	  public static String randomSSNGenerator()

	  {

		  Random random=new Random();
		  int number=random.ints(100,900).findFirst().getAsInt();
		  int number2=random.ints(10,100).findFirst().getAsInt();
	      String ssn=""+number+"-"+number2+""+"-"+"2222";
	      return ssn;

	 }





	public static String randomFirstName()

	{
		Random random=new Random();
		int first=random.ints(1000).findFirst().getAsInt();
		String firstName="vikas"+first;
		return firstName;

	}

	public static String randomLastName()

	{

		Random random=new Random();
		int last=random.ints(1000).findFirst().getAsInt();
		String lastName="kum"+last;
		return lastName;

	}


      public static void createPublicTokenForBank()

      {

    	String baseURI="https://sandbox.plaid.com/sandbox/public_token/create";

  	 	HashMap<String,String> requestHeaders=new HashMap<String,String>();

  	 	requestHeaders.put("Content-Type", "application/json");

  	 	RequestPayload request=new RequestPayload();

    	Response response = given().headers(requestHeaders).body(request.publicTokenForBank).post(baseURI);

    	System.out.println("response of create public token "+response.asString());

    	publicLinkToken=response.jsonPath().getString("public_token").toString();

    	System.out.println("public link token from create public link token bank "+publicLinkToken);


      }


      public static void addBankItem() throws InterruptedException

      {
    	    String baseURI=""+timesclubHost+"/plaid/additem/v1/";

    	 	HashMap<String,String> requestHeaders=new HashMap<String,String>();

    	 	requestHeaders.put("Content-Type", "application/json");

    	 	requestHeaders.put("Authorization", "Bearer "+loginToken);

		  requestHeaders.put("isTokenRotationON", "true");


		  requestHeaders.put("Nb-Sso-Enabled", "true");

		  requestHeaders.put("User-Agent", "IOS Darwin");

    	 	requestHeaders.put("device-id", deviceId);

			RequestPayload request=new RequestPayload();

      	    Response response = given().headers(requestHeaders).body(request.bankLink).post(baseURI);

      	    System.out.println("response of add bank "+response.asString());

         	System.out.println("response status "+response.getStatusCode());

        	Thread.sleep(20000);

      }


      public static Response createDepositAccount()

  	{

  		 String baseURI=""+host+""+bankPath+"/account/create?preview_only=false";

  		 	HashMap<String,String> requestHeaders=new HashMap<String,String>();

  		 	requestHeaders.put("Content-Type", "application/json");

  		 	requestHeaders.put("Authorization", "Bearer "+SignupAndKycFlow.jwtToken);

  		 	requestHeaders.put("device-id",SignupAndKycFlow.deviceId);

  		 	requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

			   requestHeaders.put("user_type", "PRIMARY");

			   requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

  		 	Response response = given().headers(requestHeaders).post(baseURI);

  		 	String responseText = response.asString();

  		 	Log4jClass.fn_logger_info("Response :"+responseText);
		SignupAndKycFlow.nodeId = response.jsonPath().getString("node_id");
  		 	depositAccountCreateforUserAgreement();

  		 	return response;

  	}


      public static Response depositAccountCreateforUserAgreement()

    	{

    		 String baseURI=""+host+""+bankPath+"/account/create?preview_only=true";

    		 	HashMap<String,String> requestHeaders=new HashMap<String,String>();

    		 	requestHeaders.put("Content-Type", "application/json");

    		 	requestHeaders.put("Authorization", "Bearer "+SignupAndKycFlow.jwtToken);

    		 	requestHeaders.put("device-id",SignupAndKycFlow.deviceId);

    		 	requestHeaders.put("link-token", SignupAndKycFlow.linkToken);
    		 	requestHeaders.put("user_type", "PRIMARY");

    		    requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

    		 	Response response = given().headers(requestHeaders).post(baseURI);
				 String responseText = response.asString();

    		 	Log4jClass.fn_logger_info("Response :"+responseText);

    		 	return response;

    	}



		public static void loginOnTcForGettingMessageId()

		{

			String baseURI=""+timesclubHost+"users/login-with-mobile";

			System.out.println("******************"+baseURI);

			HashMap<String,String> requestHeaders=new HashMap<String,String>();

			RequestPayload rq=new RequestPayload();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("isTokenRotationON", "true");

			//requestHeaders.put("Advertising-Id", "eb0eeb86-6a7e-40ef-aad9-18be23076b5e");

			requestHeaders.put("Nb-Sso-Enabled", "true");

			requestHeaders.put("User-Agent", "IOS Darwin");
			requestHeaders.put("device-id", rq.deviceIdForLoginUser);



			Response response = given().headers(requestHeaders).body(rq.loginPayloadForExistingUser).post(baseURI);

			System.out.println("payload -->"+rq.loginPayloadForExistingUser);
			String responseText = response.asString();

			System.out.println("response of login api --->"+responseText);
			Log4jClass.fn_logger_info("Response :"+responseText);

			messageIdForTc = JsonPath.read(responseText,"$.message_id");
			Log4jClass.fn_logger_info("messageIdForTc :"+messageIdForTc);


		}

	public static String loginOnTcForOtpVerification()
	{
		String baseURI=""+timesclubHost+"users/verify-otp-login";

		System.out.println("******************"+baseURI);

		HashMap<String,String> requestHeaders=new HashMap<String,String>();
		RequestPayload rq=new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("device-id", rq.deviceIdForLoginUser);


		Response response = given().headers(requestHeaders).body(rq.verifYOTPPayloadForTc).post(baseURI);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response :"+responseText);

		loginTokenForLogInUserUsingMobileNumber = JsonPath.read(responseText,"$.token");

		System.out.println("login token for tc "+loginTokenForLogInUserUsingMobileNumber);

		return loginTokenForLogInUserUsingMobileNumber;
	}


		public static String linkTokenGeneartionForLogin()
		{

			String baseURI=""+timesclubHost+"plaid/neo-bank/link/token/v1";

			RequestPayload rq =new RequestPayload();

			System.out.println("******************"+baseURI);

			HashMap<String,String> requestHeaders=new HashMap<String,String>();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("Authorization", "Bearer "+loginTokenForLogInUserUsingMobileNumber);

requestHeaders.put("isTokenRotationON", "true");

			requestHeaders.put("Nb-Sso-Enabled", "true");

			requestHeaders.put("User-Agent", "IOS Darwin");


			requestHeaders.put("device-id", rq.deviceIdForLoginUser);

			//	requestHeaders.put("user_type", "PRIMARY");

			System.out.println("logintoken"+loginTokenForLogInUserUsingMobileNumber);

			System.out.println("requestHeaders "+requestHeaders);

			Response response = given().headers(requestHeaders).get(baseURI);

			String responseText = response.asString();

			System.out.println("response of linktoken --> "+response.getStatusCode());

			Log4jClass.fn_logger_info("Response :"+responseText);

			String linkToken=response.jsonPath().getString("linkToken").toString();

			response.jsonPath().get("linkToken").toString().contains(".*");

			System.out.println("linktokennnnnnnnnn"+linkToken);

			return linkToken;

		}


       public static void loginOnNeoBankForNormalTransaction()
	   {

		   linkTokenForCMATxn= SignupAndKycFlow.linkTokenGeneartionForLogin();

		   RequestPayload re= new RequestPayload();

		   String baseURI=""+host+""+usersPath+"/login/v1";

		   System.out.println("baseURI -->"+baseURI);

		   HashMap<String,String> requestHeader=new HashMap<String,String>();

		   requestHeader.put("Content-Type", "application/json");

		   requestHeader.put("device-id", re.deviceIdForLoginUser);

		   requestHeader.put("link-token", linkTokenForCMATxn);

		   requestHeader.put("customer-id", re.customerIdForLoginUser);

		   requestHeader.put("user_type", "PRIMARY");

		   System.out.println("requestPayload for login ---> "+requestHeader);

		   System.out.println(re.loginPayloadForExistingUserOnNeobank);

		   Response response = given().headers(requestHeader).body(re.loginPayloadForExistingUserOnNeobank).post(baseURI);

		   System.out.println("response--->"+response.asString());

		   messageIdForLogin=response.jsonPath().getString("messageId");

		   //Assert.assertTrue(response.jsonPath().getString("userSignUpStatus").contains("ACCOUNT_CREATED"));

		   String responseText = response.asString();

		   Log4jClass.fn_logger_info("Response :"+responseText);


	   }

	public static void loginOnNeoBankForNormalTransaction(String jwt)
	{


		RequestPayload re= new RequestPayload();

		String baseURI=""+host+""+usersPath+"/login/v1";

		System.out.println("baseURI -->"+baseURI);

		HashMap<String,String> requestHeader=new HashMap<String,String>();

		requestHeader.put("Content-Type", "application/json");

		requestHeader.put("device-id", re.deviceIdForLoginUser);

		requestHeader.put("isTokenRotationON", "true");

		requestHeader.put("Nb-Sso-Enabled", "true");

		//	requestHeader.put("link-token", linkTokenForCMATxn);

		requestHeader.put("customer-id", re.customerIdForLoginUser);
		requestHeader.put("Authorization", "Bearer " + jwt);

		requestHeader.put("user_type", "PRIMARY");

		System.out.println("requestPayload for login ---> "+requestHeader);

		System.out.println(re.loginPayloadForExistingUserOnNeobank);

		Response response = given().headers(requestHeader).body(re.loginPayloadForExistingUserOnNeobank).post(baseURI);

		System.out.println("response--->"+response.asString());

		messageIdForLogin=response.jsonPath().getString("messageId");

		//Assert.assertTrue(response.jsonPath().getString("userSignUpStatus").contains("ACCOUNT_CREATED"));

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response :"+responseText);


	}

     public static void verifyOTPForLoginUser()

	 {

		 String baseURI=""+host+""+usersPath+"/verify-otp/v1";

		 HashMap<String,String> requestHeaders=new HashMap<String,String>();

		 RequestPayload re= new RequestPayload();

		 requestHeaders.put("Content-Type", "application/json");

		 requestHeaders.put("device-id", re.deviceIdForLoginUser);

		 requestHeaders.put("link-token", linkTokenForCMATxn);

		 requestHeaders.put("customer-id",  re.customerIdForLoginUser);

		 requestHeaders.put("user_type", "PRIMARY");

		 requestHeaders.put("source", "REMITTANCE");

		 Response response = given().headers(requestHeaders).body(re.verifyOtpForLoginUser).post(baseURI);

		 String responseText = response.asString();

		 Log4jClass.fn_logger_info("response of verifyOTP :"+responseText);

		 Log4jClass.fn_logger_info("status code :"+response.statusCode());

		 //jwtToken=response.getHeader("Auth-Token").toString();

		 jwtForLoginUser=response.jsonPath().getString("jwtToken").toString();

		 response.jsonPath().get("jwtToken").toString().contains(".*");

		 responseText = response.asString();

		 Log4jClass.fn_logger_info("Response :"+responseText);

	 }


	public static void verifyOTPForLoginUser(String jwt)

	{

		String baseURI=""+host+""+usersPath+"/verify-otp/v1";

		HashMap<String,String> requestHeaders=new HashMap<String,String>();

		RequestPayload re= new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", re.deviceIdForLoginUser);

		requestHeaders.put("link-token", linkTokenForCMATxn);

		requestHeaders.put("customer-id",  re.customerIdForLoginUser);

		requestHeaders.put("Authorization", "Bearer " + jwt);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("source", "REMITTANCE");

		Response response = given().headers(requestHeaders).body(re.verifyOtpForLoginUser).post(baseURI);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("response of verifyOTP :"+responseText);

		Log4jClass.fn_logger_info("status code :"+response.statusCode());

		//jwtToken=response.getHeader("Auth-Token").toString();

		jwtForLoginUser=response.jsonPath().getString("jwtToken").toString();

		response.jsonPath().get("jwtToken").toString().contains(".*");

		responseText = response.asString();

		Log4jClass.fn_logger_info("Response :"+responseText);

	}

	public static Response loginForNormalUser()
	{

		RequestPayload re= new RequestPayload();

		String baseURI=""+host+""+usersPath+"/login/v1";

		System.out.println("baseURI -->"+baseURI);

		HashMap<String,String> requestHeaders=new HashMap<String,String>();
		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", deviceId);

		requestHeaders.put("link-token", linkToken);

		requestHeaders.put("customer-id", customerId);

		requestHeaders.put("isTokenRotationON", "true");

		requestHeaders.put("Nb-Sso-Enabled", "true");

		requestHeaders.put("User-Agent", "IOS Darwin");

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("source", "BANKING");

		System.out.println("requestPayload for login ---> "+requestHeaders);

		System.out.println(re.loginPayloadForNormalUserOnNeobank);

		Response response = given().headers(requestHeaders).body(re.loginPayloadForNormalUserOnNeobank).post(baseURI);

		System.out.println("response--->"+response.asString());

		messageId=response.jsonPath().getString("messageId");

		//Assert.assertTrue(response.jsonPath().getString("userSignUpStatus").contains("ACCOUNT_CREATED"));

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response :"+responseText);

		return response;

	}


	public static Response validateDocuments(ExtentTest t)
	{
		String baseURI=""+host+""+usersPath+"/document/update";

		HashMap<String,String> requestHeaders=new HashMap<String,String>();

		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("user_type", "PRIMARY");
		requestHeaders.put("Authorization", "Bearer "+jwtToken);

		requestHeaders.put("device-id", deviceId);


		requestHeaders.put("link-token", linkToken);

		requestHeaders.put("customer-id", customerId);

		RequestPayload rs = new RequestPayload();

		Response response = given().headers(requestHeaders).body(rs.documentValidate).post(baseURI);

		String responseText = response.asString();

		String message = JsonPath.read(responseText,"$.message");

		t.info("message from document api ---->"+message);
		Log4jClass.fn_logger_info("Response :"+responseText);

		return response;

	}


	public static Response layer2SignupApi(ExtentTest t)
	{
		String baseURI=""+host+""+usersPath+"/signup/layer2/v1";

		HashMap<String,String> requestHeaders=new HashMap<String,String>();

		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("user_type", "PRIMARY");
		requestHeaders.put("Authorization", "Bearer "+jwtToken);

		requestHeaders.put("device-id", deviceId);

		requestHeaders.put("link-token", linkToken);

		requestHeaders.put("customer-id", customerId);

		RequestPayload rs = new RequestPayload();

		Response response = given().headers(requestHeaders).body("{}").post(baseURI);

		String responseText = response.asString();

		System.out.println("response text -->"+responseText);
		String message = JsonPath.read(responseText,"$.responseString");

		t.info("message from layer2 signup api ---->"+message);
		Log4jClass.fn_logger_info("Response :"+responseText);

		return response;

	}



	public static String randomSSN()
	{
		Random r = new Random();
		int i = r.nextInt(999);
		if(i <= 100) {
			i = i + 100;
		}
		int j = r.nextInt(99);

		if(j <= 10) {
			j = j + 10;
		}
		int k = r.nextInt(9999);

		if(k <= 1000) {
			k = k + 1000;
		}
		String s = String.valueOf(i)+"-"+String.valueOf(j)+"-"+String.valueOf(k);

         return s;
	}


	public static String randomPhoneNumberForLayer2()
	{
		String s ="+1815679";

		Random r = new Random();
		int i = r.nextInt(9999);
		if(i <= 1000) {
			i = i + 1000;
		}

		s= s + String.valueOf(i);

		return s;

	}


	public static String getLinkTokenV2()
	{
		String baseURI=""+timesclubHost+"plaid/neo-bank/token/v2?request_type=GET_USER&source=REMITTANCE";

		RequestPayload rq =new RequestPayload();

		System.out.println("******************"+baseURI);

		HashMap<String,String> requestHeaders=new HashMap<String,String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("Authorization", "Bearer "+loginTokenForLogInUserUsingMobileNumber);

			requestHeaders.put("isTokenRotationON", "true");

			requestHeaders.put("Nb-Sso-Enabled", "true");

		//	requestHeaders.put("User-Agent", "IOS Darwin");

		requestHeaders.put("device-id", rq.deviceIdForLoginUser);

		//	requestHeaders.put("user_type", "PRIMARY");

		System.out.println("logintoken"+loginTokenForLogInUserUsingMobileNumber);

		System.out.println("requestHeaders "+requestHeaders);

		Response response = given().headers(requestHeaders).get(baseURI);

		String responseText = response.asString();

		System.out.println("response of linktoken --> "+response.getStatusCode());

		Log4jClass.fn_logger_info("Response :"+responseText);

		String jwt=response.jsonPath().getString("jwt_token").toString();

		return jwt;

	}



	public static void loginOnTcForEliteUser()

	{

		String baseURI=""+timesclubHost+"users/login-with-mobile";

		System.out.println("******************"+baseURI);

		HashMap<String,String> requestHeaders=new HashMap<String,String>();

		RequestPayload rq=new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("isTokenRotationON", "true");


		requestHeaders.put("Nb-Sso-Enabled", "true");

		requestHeaders.put("User-Agent", "IOS Darwin");
		requestHeaders.put("device-id", rq.deviceIdForEliteUser);



		Response response = given().headers(requestHeaders).body(rq.loginMobileNoForEliteUser).post(baseURI);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response :"+responseText);

		messageIdForTcForElite = JsonPath.read(responseText,"$.message_id");
		Log4jClass.fn_logger_info("messageIdForTc :"+messageIdForTc);


	}

	public static String loginOnTcOtpVerificationForElite()
	{
		String baseURI=""+timesclubHost+"users/verify-otp-login";

		System.out.println("******************"+baseURI);

		HashMap<String,String> requestHeaders=new HashMap<String,String>();
		RequestPayload rq=new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("device-id", rq.deviceIdForEliteUser);


		Response response = given().headers(requestHeaders).body(rq.verifYOTPPayloadForTcForElite).post(baseURI);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response :"+responseText);

		loginTokenForLogInUserUsingMobileNumberForElite = JsonPath.read(responseText,"$.token");

		System.out.println("login token for tc "+loginTokenForLogInUserUsingMobileNumberForElite);

		return loginTokenForLogInUserUsingMobileNumberForElite;
	}

	public static String linkTokenGeneartionForELiteUser()
	{

		String baseURI=""+timesclubHost+"plaid/neo-bank/token/v2?request_type=GET_USER&source=REMITTANCE";

		RequestPayload rq =new RequestPayload();

		System.out.println("******************"+baseURI);

		HashMap<String,String> requestHeaders=new HashMap<String,String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("Authorization", "Bearer "+loginTokenForLogInUserUsingMobileNumberForElite);

		requestHeaders.put("isTokenRotationON", "true");

		requestHeaders.put("Nb-Sso-Enabled", "true");

		//	requestHeaders.put("User-Agent", "IOS Darwin");

		requestHeaders.put("device-id", rq.deviceIdForEliteUser);

		//	requestHeaders.put("user_type", "PRIMARY");

		System.out.println("logintoken"+loginTokenForLogInUserUsingMobileNumberForElite);

		System.out.println("requestHeaders "+requestHeaders);

		Response response = given().headers(requestHeaders).get(baseURI);

		String responseText = response.asString();

		System.out.println("response of linktoken --> "+response.getStatusCode());

		Log4jClass.fn_logger_info("Response :"+responseText);

		String jwt=response.jsonPath().getString("jwt_token").toString();

		return jwt;

	}

public static void loginOnNeoBankForPrefundingTransaction()
	{

		linkTokenForEliteUser= SignupAndKycFlow.linkTokenGeneartionForELiteUser();

		RequestPayload re= new RequestPayload();

		String baseURI=""+host+""+usersPath+"/login/v1";

		System.out.println("baseURI -->"+baseURI);

		HashMap<String,String> requestHeader=new HashMap<String,String>();

		requestHeader.put("Content-Type", "application/json");

		requestHeader.put("device-id", re.deviceIdForEliteUser);

		requestHeader.put("link-token", linkTokenForEliteUser);

		requestHeader.put("customer-id", re.customerIdForEliteUser);

		requestHeader.put("user_type", "PRIMARY");

		System.out.println("requestPayload for login ---> "+requestHeader);

		System.out.println(re.loginPayloadForEliteUser);

		Response response = given().headers(requestHeader).body(re.loginPayloadForEliteUser).post(baseURI);

		System.out.println("response--->"+response.asString());

		messageIdForNeobankForElite=response.jsonPath().getString("messageId");

		//Assert.assertTrue(response.jsonPath().getString("userSignUpStatus").contains("ACCOUNT_CREATED"));

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response :"+responseText);


	}




public static void verifyOTPForEliteUser()

	{

		String baseURI=""+host+""+usersPath+"/verify-otp/v1";

		HashMap<String,String> requestHeaders=new HashMap<String,String>();

		RequestPayload re= new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", re.deviceIdForEliteUser);

		requestHeaders.put("link-token", linkTokenForEliteUser);

		requestHeaders.put("customer-id",  re.customerIdForEliteUser);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("source", "REMITTANCE");

		Response response = given().headers(requestHeaders).body(re.verifyOtpForEliteUser).post(baseURI);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("response of verifyOTP :"+responseText);

		Log4jClass.fn_logger_info("status code :"+response.statusCode());

		//jwtToken=response.getHeader("Auth-Token").toString();

		jwtForElite=response.jsonPath().getString("jwtToken").toString();

		response.jsonPath().get("jwtToken").toString().contains(".*");

		responseText = response.asString();

		Log4jClass.fn_logger_info("Response :"+responseText);

	}


	}


*/
