/*
package abound.neobank.TestCases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import abound.neobank.utilities.SparkHTML;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.restassured.response.Response;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.testng.Assert;
import org.testng.annotations.*;

import abound.neobank.services.SignupAndKycFlow;
import abound.neobank.utilities.Log4jClass;
//import io.rest-assured.response.Response;
//import io.restassured.RestAssured.*;

public class SignUpAndKYCFlowTest

{
public static Date randomNoForReport;
	
	// @Test(groups = { "smoke", "sanity", "functional"})
//	public static Properties prop;
	@BeforeTest(groups = { "sanity" ,"failure","smoke","utility","loginUserTxn"})
	public void sparkSetup() throws ConfigurationException {

		System.out.println("configuration stated ....................................");
		SparkHTML.spark.config().setTheme(Theme.DARK);
		SparkHTML.spark.config().setDocumentTitle("Neobank Automation Report");
		SparkHTML.extent.attachReporter(SparkHTML.spark);

		System.out.println("configuration stated ....................................");


	}




	@AfterTest(groups = { "sanity" ,"failure","smoke","utility","loginUserTxn"})
	public void tearDown()
	{
		SparkHTML.extent.flush();
		System.gc();
	}



	@BeforeSuite(groups = { "sanity" ,"failure","smoke","utility","loginUserTxn"})
	public void propertyCheck() throws Throwable, ConfigurationException {
		
    System.out.println("configuration stated ....................................");
	CompositeConfiguration config = new CompositeConfiguration();
	config.addConfiguration(new SystemConfiguration());
	config.addConfiguration(new PropertiesConfiguration("Host.properties"));



	SignupAndKycFlow.host = config.getString("neobankEnvironment");
	
	SignupAndKycFlow.timesclubHost = config.getString("timesClubEnvironment");
	
	SignupAndKycFlow.usersPath=config.getString("users");
	SignupAndKycFlow.bankPath=config.getString("bank");

prop = new Properties();

		try {
			InputStream in = new FileInputStream("Transactions.properties");
			prop.load(in);
		} catch (IOException ex)
		{
			System.out.println(ex);
		}

		//Setting the value to  our properties file.


	}

	
	@AfterSuite(groups = { "sanity" ,"failure","smoke","utility"})
	 public void sendHtmlReport() 
	{


		 String from = "vtest9910@gmail.com";

	        final String username = from;
	        final String password = "fuolcoucdrquknsx";
	        // Get system properties
	        Properties properties = System.getProperties();
	        properties.put("mail.smtp.host", "smtp.gmail.com");
	        //properties.put("mail.smtp.host", HOST);
	    //    properties.put("mail.smtp.port", PORT);
	        properties.put("mail.smtp.auth", "true");
	        properties.put("mail.smtp.port", "465");    
	      properties.put("mail.smtp.socketFactory.port", "465");
	        properties.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
	        properties.put("mail.smtp.starttls.enable", "true"); //TLS
	        properties.put("mail.smtp.ssl.enable", "true");
	        properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
	        properties.put("mail.smtp.socketFactory.fallback", "true");
		properties.put("mail.smtp.starttls.required", "true");
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

	        // Get the Session object.// and pass username and password
	        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {    
	            protected PasswordAuthentication getPasswordAuthentication() {    
	                return new PasswordAuthentication(username,password);  
	                }    

	        });

	        // Used to debug SMTP issues

	        try {
	            // Create a default MimeMessage object.
	            MimeMessage message = new MimeMessage(session);

	            // Set From: header field of the header.
	            message.setFrom(new InternetAddress(from));
	            
	            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
	            LocalDateTime now = LocalDateTime.now();  

	            // Set To: header field of the header.

				//

	 			message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("vikas.kumar5@timesinternet.in,nitin.gambhir@timesinternet.in"));
				 
	 			message.setSubject("Abound Neobank Services Automation Report :"+now+"");
	 			
	 			System.out.println("Neobank Services Automation Report in progress..........");

	            StringBuilder sb = new StringBuilder();

	            sb.append("<html>" +
	                    "<body>" +
	                    "<table border=\"1\">" +
	                    "<tr>" +
	                    "<td><strong> Total no. of TCs </strong></td><td>" + ""+Listeners.totalTest+"" + "</td>" +
	                    "</tr>" +
	                    "<tr>" +
	                    "<td><strong> No. of TCs Passed </strong></td><td>" + ""+Listeners.totalTestPass+"" + "</td>" +
	                    "</tr>" +
	                    "<tr>" +
	                    "<td><strong> No. of TCs Failed  </strong></td><td>" + ""+Listeners.totalTestFail+"" + "</td>" +
	                    "</tr>" +
	                    "<tr>" +
	                    "<td><strong> Dashboard Link </strong></td><td>" + ""+System.getProperty("user.dir")+"\\target\\Spark"+SparkHTML.updatedReport+".html" + "</td>" +
	                    "</tr>" +
	                    "</table></body></html>");

				System.out.println("report path ------------->"+SparkHTML.updatedReport);
	            
	            BodyPart messageBodyPart1 = new MimeBodyPart();
	            
	            //message.setContent(sb.toString(),"text/html; charset=utf-8");

	            messageBodyPart1.setContent(sb.toString(), "text/html; charset=utf-8");
	            
	            // Create a multipar message
	            Multipart multipart = new MimeMultipart();

	            // Set text message part
	            multipart.addBodyPart(messageBodyPart1);
	            
	            
	            BodyPart  messageBodyPart2 = new MimeBodyPart();
	            String filename = System.getProperty("user.dir")+"//target//Spark"+SparkHTML.updatedReport+".html";
				System.out.println("filename --->"+filename);
				DataSource source = new FileDataSource(filename);
	            messageBodyPart2.setDataHandler(new DataHandler(source));
	            messageBodyPart2.setFileName(filename);
	            multipart.addBodyPart(messageBodyPart2);

	            // Send the complete message parts
	            message.setContent(multipart);

	           

	            System.out.println("sending email...");

	            // Send message
	            Transport.send(message);

	            System.out.println("Sent message successfully....");


	        } catch (MessagingException mex)
			{

	            mex.printStackTrace();

			}



	}
	
	@Test(priority=0,groups = { "sanity","failure" ,"smoke"})
	public void linkTokenTest() throws InterruptedException
		
	{
		ExtentTest test=SparkHTML.extent.createTest("linkTokenTest").assignCategory("functionalUseCase");
		test.info("fetching the linktoken for the TC user");
		   String linkToken;	
		   
		   SignupAndKycFlow.newUser();
		   SignupAndKycFlow.verifyOtpForMobileNumberUser();
		   
		   
	       Response response=SignupAndKycFlow.tcLinkToken();
	       
	       Log4jClass.fn_logger_info("Status code of the linkTokenService is : "+response.statusCode());

		test.info("status code --> "+response.statusCode());

		if(response.statusCode()==200) {

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);


		}
		   else {
			   test.fail("failed");
			   Assert.assertTrue(false);

		   }
	       
	       linkToken=response.jsonPath().get("linkToken");
	       
	       Log4jClass.fn_logger_info("value for linkToken is : "+linkToken);
	       
	       
	       
	}

	

	@Test(priority=2,groups = { "sanity","failure","smoke" })

	public void signUpServiceTest() throws InterruptedException
	{

		ExtentTest test=SparkHTML.extent.createTest("signUpServiceTest").assignCategory("functionalUseCase");
		test.info("Signing up the user on neobank");
		String responseString;
		
		Response response=SignupAndKycFlow.loginForNormalUser();
		
		Log4jClass.fn_logger_info("Status code of the signUpServiceTest is : "+response.statusCode());

		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==200) {

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);


		}

		 else {
			 test.fail("failed");
			 Assert.assertTrue(false);

		 }

		 
		 Thread.sleep(50000);
		 
		 
		
	}
	
	
	@Test(priority=2)

	public void uSignUpServiceTest() throws Exception

	{
		ExtentTest test=SparkHTML.extent.createTest(" SignUpServiceTest with invalid token ").assignCategory("functionalUseCase");
		test.info("Signing up on neobank with invalid token");

		String responseString;
		
		Response response=SignupAndKycFlow.userSignupServiceWithInValidToken();
		
		Log4jClass.fn_logger_info("Status code of the userSignupServiceWithInValidToken is : "+response.statusCode());
		test.info("status code --> "+response.statusCode());

		 if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
		  	   Assert.assertTrue(true);

		 else
		 {
			 test.fail("failed");
			 Assert.assertTrue(false);
		 }
		 
		 
		 
		
	}

	
	@Test(priority=3,groups = { "sanity","failure","smoke" },enabled = false)
	public void otpServiceTest() throws InterruptedException
	{

		ExtentTest test=SparkHTML.extent.createTest(" OTP service test ").assignCategory("functionalUseCase");
		test.info("Generating the OTP for the user");
		Thread.sleep(50000);
		

		Response response=SignupAndKycFlow.sendOTPService();
		
	    Log4jClass.fn_logger_info("Status code of the otpServiceTest is : "+response.statusCode());
		test.info("status code --> "+response.statusCode());

		if(response.statusCode()==200) {

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);


		}

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
	    
	}

	@Test(priority=4,groups = { "sanity","failure" ,"smoke" })
	public void verifyOtpServiceTest() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest(" verifyOtpServiceTest").assignCategory("functionalUseCase");
		test.info("Generating the OTP for the user with invalid token");
	     String responseString;
		
		
		Response response=SignupAndKycFlow.verifyOTPService();
		
		System.out.println("***********************************verify service");
	    Log4jClass.fn_logger_info("Status code of the verify OTP Service is : "+response.statusCode());

		test.info("status code --> "+response.statusCode());

		if(response.statusCode()==200) {

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);


		}

		 else {
			 test.fail("failed");
			 Assert.assertTrue(false);

		 }

		 
	}


	@Test(priority=6,groups = { "sanity","failure" ,"smoke" })
	public void validateAdressServiceTest() throws Exception
	{
		ExtentTest test=SparkHTML.extent.createTest(" validateAdressServiceTest").assignCategory("functionalUseCase");
		test.info("Validating the Address Service ");
		
		Response response=SignupAndKycFlow.validateAddressService();
		
	    Log4jClass.fn_logger_info("Status code of the validateAddress Service is : "+response.statusCode());

		test.info("status code --> "+response.statusCode());

		if(response.statusCode()==200) {

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);


		}

		 else {
			 test.fail("failed");
			 Assert.assertTrue(false);

		 }
		 
	}
	@Test(priority=7,groups = { "sanity","failure","smoke"  })
	public void verifyTheSSNService() throws Exception
	{

		ExtentTest test=SparkHTML.extent.createTest(" validate SSN servcice").assignCategory("functionalUseCase");
		test.info("Validating the SSN Service ");
		
		Response response=SignupAndKycFlow.validateSSNService();;
		
	    Log4jClass.fn_logger_info("Status code of the ssn  Service is : "+response.statusCode());

		test.info("status code --> "+response.statusCode());

		if(response.statusCode()==200) {

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);


		}
		 else
		 {

			 test.fail("failed");
			 Assert.assertTrue(false);

		 }


	}

	@Test(priority=5,groups = { "sanity","failure","smoke"  })
	public void verifyTheUpdateUser() throws Exception
	{
		ExtentTest test=SparkHTML.extent.createTest(" validate update user servcice").assignCategory("functionalUseCase");
		test.info("Validating the update user Service ");

	Response response=SignupAndKycFlow.updateUser();
		
	    Log4jClass.fn_logger_info("Status code of the updateUser is : "+response.statusCode());

		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==200) {

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);


		}

		 else {
			 test.fail("failed");
			 Assert.assertTrue(false);

		 }
		 
		 Boolean validateKey=response.jsonPath().get("success");
		 
		 Assert.assertTrue(validateKey);
		 
		 
		 
	}



	@Test(priority=8)
	public void verifySignupWithoutPassingJWTandLinkToken() throws Exception
	{

		ExtentTest test=SparkHTML.extent.createTest(" verifySignupWithoutPassingJWTandLinkToken").assignCategory("functionalUseCase");
		test.info("verify signup service without passing JWT and linktoken ");
		Response response=SignupAndKycFlow.signUpWithoutJWTandLT();
		Log4jClass.fn_logger_info("status code of the verifySignupWithoutPassingJWTandLinkToken is : "+response.statusCode());

		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
			Assert.assertTrue(true);
		
		
	}

	@Test(priority=9)
	public void verifyWithoutLinkTokenInOTPService() throws Exception
	{

		ExtentTest test=SparkHTML.extent.createTest(" verifyWithoutLinkTokenInOTPService").assignCategory("functionalUseCase");
		test.info("verify otp service without passing JWT and linktoken ");
		Response response=SignupAndKycFlow.signUpWithoutJWTandLT();
		Log4jClass.fn_logger_info("status code of the verifyWithoutLinkTokenInOTPService is : "+response.statusCode());

		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
		Assert.assertTrue(true);

	       	
			
	}

	@Test(priority=10)
	public void otpServiceInvalidEmailIdAndAuthorization() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest(" otpServiceInvalidEmailIdAndAuthorization").assignCategory("functionalUseCase");
		test.info("verify otp service without passing emailid and auth ");

		Response response=SignupAndKycFlow.otpServiceInvalidEmailidAndAuthorizatiosn();
		Log4jClass.fn_logger_info("status code of the otpServiceInvalidEmailIdAndAuthorization is : "+response.statusCode());

		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
		Assert.assertTrue(true);
		
	}


	@Test(priority=11)
	public void validationOfTheSSNServcieOnPassingInvalidSSN() throws Exception
	{
		ExtentTest test=SparkHTML.extent.createTest(" validationOfTheSSNServcieOnPassingInvalidSSN").assignCategory("functionalUseCase");
		test.info("verify ssn service on passing invalid ssn ");
		Response response=SignupAndKycFlow.ssnServiceWithOInvalidSSN();
		Log4jClass.fn_logger_info("status code of the validationOfTheSSNServcieOnPassingInvalidSSN is : "+response.statusCode());
		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
			Assert.assertTrue(true);
		
	}


	@Test(priority=11,groups = { "sanity" ,"failure","smoke" })
	public void validationOfDocumentApi() throws Exception
	{
		ExtentTest test=SparkHTML.extent.createTest(" validationOfDocumentApi").assignCategory("functionalUseCase");
		test.info("Validation of document upload api");
		Response response=SignupAndKycFlow.validateDocuments(test);
		Log4jClass.fn_logger_info("status code of the validationOfDocumentApi: "+response.statusCode());
		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==200) {

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);


		}

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}

	}


	@Test(priority=12,groups = { "sanity" ,"failure","smoke" })
	public void validationOfLayer2Api() throws Exception
	{

		ExtentTest test=SparkHTML.extent.createTest(" validationOfLayer2Api").assignCategory("functionalUseCase");
		test.info("Validation of layer2 Api");
		Response response=SignupAndKycFlow.layer2SignupApi(test);
		Log4jClass.fn_logger_info("status code of the validationOfLayer2Api: "+response.statusCode());
		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==200) {

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);


		}

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
	}
	
	@Test(priority=12)
	public void xvalidationOfSynapseService() throws Exception
	{
		ExtentTest test=SparkHTML.extent.createTest(" xvalidationOfSynapseService").assignCategory("functionalUseCase");
		test.info("verify synapse service without passing invalid jwt  ");
		Response response=SignupAndKycFlow.OnPssingInvalidLinkTokenInNeobankSynapseService();
		Log4jClass.fn_logger_info("status code of the xvalidationOfSynapseService: "+response.statusCode());
		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
			Assert.assertTrue(true);

			    else
				Assert.assertTrue(false);
	}

	
	
	@Test(priority=26,groups = { "sanity","failure" ,"smoke" },enabled = true)
	public void validationOfGetKycStatusService() throws Exception

	{
		ExtentTest test=SparkHTML.extent.createTest(" validationOfGetKycStatusService").assignCategory("functionalUseCase");
		test.info("verify of kyc status service ");
		Response response=SignupAndKycFlow.getKYCService();
		//Response responseFromCreateDeposit=SignupAndKycFlow.createDepositAccount();

		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==200) {

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);


		}

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
	}


	@Test(priority=13)
	public void validationOfAddressFlowOnPassingWrongAddress() throws Exception
	{
		ExtentTest test=SparkHTML.extent.createTest(" validationOfAddressFlowOnPassingWrongAddress").assignCategory("functionalUseCase");
		test.info("Validation of address flow on passing wrong address");
		Response response=SignupAndKycFlow.validteAdressServiceOnWrongAddress();
		Log4jClass.fn_logger_info("status code of the validationOfAddressFlowOnPassingWrongAddress is : "+response.statusCode());
		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
		Assert.assertTrue(true);

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
	}

	@Test(priority=14)
	public void validationOfInvalidSSNNumber() throws Exception
	{


		Response response=SignupAndKycFlow.ssnServiceWithOInvalidSSN();
		Log4jClass.fn_logger_info("status code of the validationOfInvalidSSNNumber is : "+response.statusCode());
		ExtentTest test=SparkHTML.extent.createTest(" validationOfInvalidSSNNumber").assignCategory("functionalUseCase");
		test.info("Validation of invalid ssn number");
		test.info("status code --> "+response.statusCode());

		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
		Assert.assertTrue(true);

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
	}

	@Test(priority=15)
	public void validationOfKYCSeviceWithoutDeviceId() throws Exception
	{

		ExtentTest test=SparkHTML.extent.createTest(" validationOfKYCSeviceWithoutDeviceId").assignCategory("functionalUseCase");
		test.info("Validation of kyc Service without Device id");
		Response response=SignupAndKycFlow.getKYCServiceWithoutDeviceId();
		Log4jClass.fn_logger_info("status code of the validationOfKYCSeviceWithoutDeviceId is : "+response.statusCode());
		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
			Assert.assertTrue(true);

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
		
	}




	@Test(priority=16)
	public void validationOfKYCServiceNegative() throws Exception

	{

		Response response=SignupAndKycFlow.getKYCServiceWithoutJWT();
		Log4jClass.fn_logger_info("status code of the validationOfKYCServiceNegative is : "+response.statusCode());
		ExtentTest test=SparkHTML.extent.createTest(" validationOfKYCServiceNegative").assignCategory("functionalUseCase");
		test.info("Validation of KYC service without JWT");
		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==400||response.statusCode()==401||response.statusCode()==404||response.statusCode()==500||response.statusCode()==409)
		Assert.assertTrue(true);

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
		
	}


	@Test(priority=17)
	public void validationOfAddressServiceOnWrongAdd() throws Exception

	{

		Response response=SignupAndKycFlow.validteAdressServiceOnWrongAddress();
		Log4jClass.fn_logger_info("status code of the validationOfAddressServiceOnWrongAdd is : "+response.statusCode());
		ExtentTest test=SparkHTML.extent.createTest(" validationOfAddressServiceOnWrongAdd").assignCategory("functionalUseCase");
		test.info("Validation of address service on passing wrong address");
		test.info("status code --> "+response.statusCode());

		if(response.statusCode()==400||response.statusCode()==401||response.statusCode()==404||response.statusCode()==500||response.statusCode()==409)
		Assert.assertTrue(true);

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
	}


	

	@Test(priority=19)
	public void validUpdateServiceOnPassingInvalidToken() throws Exception

	{

		Response response=SignupAndKycFlow.validateUpdateServiceByPassingInvalidToken();
		abound.neobank.utilities.Log4jClass.fn_logger_info("status code of the validUpdateServiceOnPassingInvalidToken is : "+response.statusCode());
		ExtentTest test=SparkHTML.extent.createTest(" validUpdateServiceOnPassingInvalidToken").assignCategory("functionalUseCase");
		test.info("Validation of update srevice on passing invalid token");
		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==400||response.statusCode()==401||response.statusCode()==404||response.statusCode()==500||response.statusCode()==409)
		Assert.assertTrue(true);

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
	}

	

	@Test(priority=21)
	public void validateLoginServiceWithoutAuth() throws Exception
	{
		
		Response response=SignupAndKycFlow.validateNeobankLoginServiceNegative();
		Log4jClass.fn_logger_info("status code of the login service when not passing auth is : "+response.statusCode());
		ExtentTest test=SparkHTML.extent.createTest(" validateLoginServiceWithoutAuth").assignCategory("functionalUseCase");
		test.info("Validation of login servcie without authentication");
		test.info("status code --> "+response.statusCode());

		if(response.statusCode()==400||response.statusCode()==401||response.statusCode()==404||response.statusCode()==500||response.statusCode()==409)
		Assert.assertTrue(true);

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
		
	}

	@Test(priority=22)
	public void validateWhenSameUserIsLoggedInWithAnotherDevices() throws Exception

	{
		
		Response response=SignupAndKycFlow.validateWhenSameUserIsLoggedInWithAnotherDevice();
		
		Log4jClass.fn_logger_info("status code of the validateWhenSameUserIsLoggedInWithAnotherDevices : "+response.statusCode());

		ExtentTest test=SparkHTML.extent.createTest(" validateWhenSameUserIsLoggedInWithAnotherDevices").assignCategory("functionalUseCase");
		test.info("Validation of logging in with same user on other device");
		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==400||response.statusCode()==401||response.statusCode()==404||response.statusCode()==500||response.statusCode()==409)
		Assert.assertTrue(true);
		
	    else
	    Assert.assertTrue(false);

	}


	@Test(priority=23)
	public void validateSignUpServiceWithoutLongAndLatitude() throws Exception
	{
	Response response=SignupAndKycFlow.validateWhenLongitudeAndlongitudeIsNotPassedInSignUpService();
		
		Log4jClass.fn_logger_info("status code of the validateSignUpServiceWithoutLongAndLatitude : "+response.statusCode());

		ExtentTest test=SparkHTML.extent.createTest(" validateSignUpServiceWithoutLongAndLatitude").assignCategory("functionalUseCase");
		test.info("Validation of signup service without long and lattitude");
		test.info("status code --> "+response.statusCode());

		if(response.statusCode()==400||response.statusCode()==401||response.statusCode()==404||response.statusCode()==500||response.statusCode()==409)
		Assert.assertTrue(true);

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
	}


	@Test(priority=24,enabled = false)
	public void validteLinkTokenOnMultipleHits() throws Exception
	{
		ExtentTest test=SparkHTML.extent.createTest(" validteLinkTokenOnMultipleHits").assignCategory("functionalUseCase");
		test.info("Validation of link token test on hitting same request multiple times");
		Assert.assertTrue(SignupAndKycFlow.validateWetherLinkTokenCanBeGeneratedMultipleTimes());
	}

	
	
	@Test(priority=25)
	public void validateUpdateUserServiceOnNotPassingAuth() throws Exception
	{
		Response response=SignupAndKycFlow.updateUserServiceNegative();
		Log4jClass.fn_logger_info("status code of the validateUpdateUserServiceOnNotPassingAuth  : "+response.statusCode());
		ExtentTest test=SparkHTML.extent.createTest(" validateUpdateUserServiceOnNotPassingAuth").assignCategory("functionalUseCase");
		test.info("Validation of validateUpdateUserServiceOnNotPassingAuth");
		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==400||response.statusCode()==401||response.statusCode()==404||response.statusCode()==500||response.statusCode()==409)
		Assert.assertTrue(true);

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
	}

	

	@Test(priority=27)
	public void validationOfSynapseServiceNegative() throws Exception
	
	{
	
		Response response=SignupAndKycFlow.validtionOfNeobankSynapseServiceNegative();
		Log4jClass.fn_logger_info("status code of the validationOfSynapseServiceNegative: "+response.statusCode());
		ExtentTest test=SparkHTML.extent.createTest(" validationOfSynapseServiceNegative").assignCategory("functionalUseCase");
		test.info("Validation of validationOfSynapseServiceNegative");
		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==400||response.statusCode()==401||response.statusCode()==404||response.statusCode()==500||response.statusCode()==409||response.statusCode()==409)
		Assert.assertTrue(true);
		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
		
	}
	
	@Test(priority=27,groups = { "smoke" })
	public void apiFlowMappingTest() throws Exception
	
	{
	
		Response response=NewUSUserFlow.apiFlowMapping();
		Log4jClass.fn_logger_info("status code of the apiFlowMappingTest: "+response.statusCode());
		ExtentTest test=SparkHTML.extent.createTest(" apiFlowMappingTest").assignCategory("functionalUseCase");
		test.info("Validation of apiFlowMappingTest");
		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==200) {

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);

		}

		else {

			test.fail("failed");
			Assert.assertTrue(false);

		}
		
	}
	
	@Test(priority=27)
	public void apiFlowMappingTestForBlockedApis() throws Exception
	
	{
		Response response=NewUSUserFlow.apiFlowMappingForBlockedApis();
		Log4jClass.fn_logger_info("status code of the apiFlowMappingTestForBlockedApis: "+response.statusCode());
		ExtentTest test=SparkHTML.extent.createTest(" apiFlowMappingTestForBlockedApis").assignCategory("functionalUseCase");
		test.info("Validation of apiFlowMappingTestForBlockedApis");
		test.info("status code --> "+response.statusCode());
		if(response.statusCode()==200)
		{

			test.info("response---->"+response.asPrettyString());
			Assert.assertTrue(true);

		}
		else
		{

			test.fail("failed");
			Assert.assertTrue(false);

		}


	}










	
	
	
	
	
	
	
	
	
	


	
	
	
}
*/
