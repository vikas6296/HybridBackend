/*
package abound.neobank.services;


//import abound.neobank.Pojo.CreateInitiateTransactionPojo;
//import abound.neobank.Pojo.ValidateUPIPojo;
//import abound.neobank.payloads.InitiateTransaction;
//import abound.neobank.payloads.ValidateUPIService;
//import abound.neobank.requestHeaders.Transactions;
import abound.neobank.restUtils.RestUtils;
import abound.neobank.utilities.DBUtils;
import abound.neobank.utilities.Log4jClass;
import com.aventstack.extentreports.ExtentTest;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.Assert;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static abound.neobank.services.SignupAndKycFlow.linkTokenForCMATxn;
import static io.restassured.RestAssured.given;

public class Remittance  {

	public static String benficiaryId;
	
	public static String requestId;

	public static String requestIdForLoginUser;

	public static String accountIdforCMAAccount;
	public static String accountid;

	public static String beneficiaryForUPI;
	public static String holdId;

	public static String instantTransferActiveKey;
	public static String promoFxRate;

	public static String transactionId;
	public static String baseFxRate;

	public static String effective_exchange_rate;

	public static double effectiveRate;

	public static String accountidForLoginUser;

	public static double effectiveRateForLoginUser;

    public static String requestIdForInstantACH;

	public static double effectiveRateForFirstTxn;

	public static String requestIdForNormalTxn;

	public static double effectiveRateForTxnUsingUPI;

	public static String requestIdForUPI;

	public static double effectiveRateForLoggedInUser;

	public static String requestidForLoggedInUser;

	public static String fundingSourceForLoggedInUser;

	public static String benficiaryIdForLoggedInUser;

    public static String accountIdforLoggedInUser;

	public static String holdIdForloggedInUser;

	public static String benficiaryIdForLoginUser;

	public static double currentExchangeRate;

	public static String item_id;

	public static String accountIdForCMATxn;

	public static String itemIdForLoggedInUser;

	public static double currentExchangeRateForLoginUser;

	public static double effectiveExchangeRateForLoginUser;

	public static String accountIdForCMATxnLoggedInUser;


	public static String itemIdForCopayTxn;

	public static String accIdForCmaAccount;

	public static String accountIdForBankAccount;
	public static String itemIdForBankAccount;

	public static double aboundBalance;

	public static String transactionRefIdForCancellation;

	public static double transactionFeeForloggedInUser;

	public static double applicable_transaction_feeForLoggedInUser;


	public static Response getExchangeRate(ExtentTest t)throws Exception,NullPointerException

	{
		Response response=null;
try {
	String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/fetch-hold-exchange-rates";


	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	requestHeaders.put("Content-Type", "application/json");

	requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");

	requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	 response = given().headers(requestHeaders).get(baseURI);

	String responseText = response.asString();

	holdId = response.jsonPath().getString("fx_hold_id");

	double exchangeRate = JsonPath.read(responseText,"$.exchange_rates.current_exchange_rate");
	System.out.println("exchangeRate for logged in user-->"+exchangeRate);
	effectiveRate = Double.valueOf(exchangeRate);
	currentExchangeRate = JsonPath.read(responseText,"$.exchange_rates.current_exchange_rate");




	System.out.println("hold id from fx exchange rate ---> " + holdId);
	Log4jClass.fn_logger_info("Response of getExchangeRate service :" + responseText);
	t.info("hold id from fx exchange rate ---> " + holdId);
	t.info(responseText);
}
catch(Exception e)
{
	System.out.println("hold id fetched from hold exhange rate api is -->"+holdId);
	t.fail("test failed");
}
		return response;

	}

	public static void exchangeRateforLoggedInUser()throws Exception,NullPointerException
	{
		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/fetch-hold-exchange-rates";


		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		RequestPayload re = new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");


		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForLoginUser);

		requestHeaders.put("link-token", linkTokenForCMATxn);

		requestHeaders.put("customer-id",  re.customerIdForLoginUser);


		Response response = given().headers(requestHeaders).get(baseURI);

		String responseText = response.asString();

		System.out.println("payload for exchange rate"+responseText);
		holdIdForloggedInUser=response.jsonPath().getString("fx_hold_id");
		System.out.println("hold id for logged in user-->"+holdIdForloggedInUser);
       double exchangeRate = JsonPath.read(responseText,"$.exchange_rates.effective_exchange_rate");
		System.out.println("exchangeRate for logged in user-->"+exchangeRate);
		effectiveExchangeRateForLoginUser = Double.valueOf(exchangeRate);
	    currentExchangeRateForLoginUser = JsonPath.read(responseText,"$.exchange_rates.current_exchange_rate");
		System.out.println("currentExchangeRateForLoginUser for logged in user-->"+currentExchangeRateForLoginUser);

		double transactionFee = JsonPath.read(responseText,"$.transaction_fee");
		transactionFeeForloggedInUser = Double.valueOf(transactionFee);
		System.out.println("transaction fee for the transaction ---->"+transactionFeeForloggedInUser);

		applicable_transaction_feeForLoggedInUser= JsonPath.read(responseText,"$.applicable_transaction_fee");


		System.out.println("transaction fee for the transaction --> "+transactionFeeForloggedInUser);
		System.out.println("Applicable transaction fee for the transaction --> "+applicable_transaction_feeForLoggedInUser);


		Log4jClass.fn_logger_info("Response of getExchangeRate service :" + responseText);

	}

	public static void exchangeRateforLoggedInUser(String jwt)throws Exception,NullPointerException
	{
		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/fetch-hold-exchange-rates";


		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		RequestPayload re = new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForLoginUser);


		requestHeaders.put("customer-id",  re.customerIdForLoginUser);
		requestHeaders.put("Authorization", "Bearer " + jwt);


		Response response = given().headers(requestHeaders).get(baseURI);

		String responseText = response.asString();

		System.out.println("payload for exchange rate"+responseText);
		holdIdForloggedInUser=response.jsonPath().getString("fx_hold_id");
		System.out.println("hold id for logged in user-->"+holdIdForloggedInUser);
		double exchangeRate = JsonPath.read(responseText,"$.exchange_rates.effective_exchange_rate");
		System.out.println("exchangeRate for logged in user-->"+exchangeRate);
		effectiveExchangeRateForLoginUser = Double.valueOf(exchangeRate);
		currentExchangeRateForLoginUser = JsonPath.read(responseText,"$.exchange_rates.current_exchange_rate");
		System.out.println("currentExchangeRateForLoginUser for logged in user-->"+currentExchangeRateForLoginUser);

		transactionFeeForloggedInUser = JsonPath.read(responseText,"$.transaction_fee");

		applicable_transaction_feeForLoggedInUser= JsonPath.read(responseText,"$.applicable_transaction_fee");


		System.out.println("transaction fee for the transaction --> "+transactionFeeForloggedInUser);
		System.out.println("Applicable transaction fee for the transaction --> "+applicable_transaction_feeForLoggedInUser);


		Log4jClass.fn_logger_info("Response of getExchangeRate service :" + responseText);

	}

	public static Response getUserBeneficiaryList(ExtentTest t) throws Exception,NullPointerException
	
	{
		Response response=null;
        try {
			//achService();
			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/user-beneficiary-list";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");

			requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

			requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

			 response = given().headers(requestHeaders).get(baseURI);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response of getUserBeneficiaryList service :" + responseText);

			t.info(responseText);
		}

		catch(Exception e)
		{
			t.fail("test failed");
		}

		return response;

	}

	public static Response getPaymentReasonsData()throws Exception,NullPointerException

	{

		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/payment-reasons-data";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		Response response = given().headers(requestHeaders).get(baseURI);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response of getPaymentReasonsData service :" + responseText);

		return response;

	}

	public static Response getFundingSourceData(ExtentTest t) throws Exception,NullPointerException

	{

	Response response=null;
try {
	String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/get-funding-source-data";

	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	requestHeaders.put("Content-Type", "application/json");

	requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");

	requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	 response = given().headers(requestHeaders).get(baseURI);

	String responseText = response.asString();
	t.info("response of getFundingSourceData" + responseText);
	System.out.println("respone of getFundingSource "+responseText);

	Map<Object, Object> accountIds = response.jsonPath().getMap("bank_accounts[1]");

	accountid = accountIds.get("account_id").toString();
	String responseText1 = response.asString();

	Map<Object, Object> accountIdForCMA = response.jsonPath().getMap("bank_accounts[1]");
	accountIdforCMAAccount = accountIdForCMA.get("account_id").toString();

	Log4jClass.fn_logger_info("accountId --> :" + accountid);

	Log4jClass.fn_logger_info("accountId for CMA --> :" + accountIdforCMAAccount);

	item_id = JsonPath.read(responseText1,"$.bank_accounts[0].item_id");

	Log4jClass.fn_logger_info("Response of getFundingSourceData service :" + responseText);
	t.info("Response of getFundingSourceData service :" + responseText);
}
			catch(Exception e)
		{
			t.fail("test failed");
		}


		return response;

	}


	public static Response getFundingSourceDataForLogin(ExtentTest t) throws Exception,NullPointerException

	{

		Response response=null;
		try {
			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/get-funding-source-data";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			RequestPayload re = new RequestPayload();

			requestHeaders.put("Content-Type", "application/json");


			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForLoginUser);

			requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  re.customerIdForLoginUser);


			response = given().headers(requestHeaders).get(baseURI);

			String responseText = response.asString();
			t.info("response of getFundingSourceData" + responseText);
			System.out.println("respone of getFundingSource "+responseText);

			Map<Object, Object> accountIds = response.jsonPath().getMap("bank_accounts[0]");

			accountidForLoginUser = accountIds.get("account_id").toString();
			String responseText1 = response.asString();

			Map<Object, Object> accountIdForCMA = response.jsonPath().getMap("bank_accounts[0]");
			accountIdforCMAAccount = accountIdForCMA.get("account_id").toString();

			itemIdForLoggedInUser = JsonPath.read(responseText1,"$.bank_accounts[0].item_id");

			Log4jClass.fn_logger_info("accountId --> :" + accountid);

			Log4jClass.fn_logger_info("accountId for CMA --> :" + accountIdforCMAAccount);

			Log4jClass.fn_logger_info("Response of getFundingSourceData service :" + responseText);
			t.info("Response of getFundingSourceData service :" + responseText);
		}
		catch(Exception e)
		{
			t.fail("test failed");
		}


		return response;

	}




      public static void getFundingSourceForGettingCMAAccount()throws Exception,NullPointerException

	  {

		  String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/get-funding-source-data?user_account_funding_source_applicable=true";

		  HashMap<String, String> requestHeaders = new HashMap<String, String>();

		  RequestPayload rq=new RequestPayload();
		  requestHeaders.put("Content-Type", "application/json");

		  requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		  requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		 requestHeaders.put("user_type", "PRIMARY");

		  requestHeaders.put("Source", "BANKING");

		  requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		  requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		  Response response = given().headers(requestHeaders).get(baseURI);

		  String responseText = response.asString();

		  System.out.println("response of funding source ---> "+responseText);

		  accIdForCmaAccount = JsonPath.read(responseText,"$.bank_accounts[0].account_id");

		  itemIdForCopayTxn = JsonPath.read(responseText,"$.bank_accounts[1].item_id");


		  Log4jClass.fn_logger_info("Response of getFundingSourceData service :" + responseText);

	  }

	public static double fetchHoldRateDataWithHoldId()throws Exception,NullPointerException

	{


		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/fetch-hold-exchange-rates?fx_hold_id="+holdId+"";

		System.out.println("request of fetchHoldService-->"+baseURI);

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		Response response = given().headers(requestHeaders).get(baseURI);


		instantTransferActiveKey=response.jsonPath().getString("instant_transfer_active");

		Map<Object,Object>exchangeRates=response.jsonPath().getMap("exchange_rates");
		effectiveRate=Double.valueOf(exchangeRates.get("display_effective_exchange_rate").toString());
		String responseText = response.asString();

		currentExchangeRate = JsonPath.read(responseText,"$.exchange_rates.current_exchange_rate");
		*/
/*effective_exchange_rate=exchangeRates.get("effective_exchange_rate").toString();
		effective_exchange_rate=String.format("%.0f", effective_exchange_rate);
		effectiveRate=Integer.parseInt(effective_exchange_rate);*//*



		Log4jClass.fn_logger_info("Response of fetchHoldRateDataWithHoldId service :" + responseText);

		return effectiveRate;

	}



	public static double fetchHoldRateDataWithHoldIdForLoggedInUser(ExtentTest t)throws Exception,NullPointerException

	{

        Thread.sleep(1000);
		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/fetch-hold-exchange-rates?fx_hold_id="+holdIdForloggedInUser+"";

		System.out.println("request of fetchHoldService-->"+baseURI);

		HashMap<String, String> requestHeaders = new HashMap<String, String>();
		RequestPayload re= new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");


		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForLoginUser);

		requestHeaders.put("link-token", linkTokenForCMATxn);

		requestHeaders.put("customer-id",  re.customerIdForLoginUser);

		Response response = given().headers(requestHeaders).get(baseURI);


		instantTransferActiveKey=response.jsonPath().getString("instant_transfer_active");

		Map<Object,Object>exchangeRates=response.jsonPath().getMap("exchange_rates");
		effectiveRateForLoginUser=Double.valueOf(exchangeRates.get("display_effective_exchange_rate").toString());
		*/
/*effective_exchange_rate=exchangeRates.get("effective_exchange_rate").toString();
		effective_exchange_rate=String.format("%.0f", effective_exchange_rate);
		effectiveRate=Integer.parseInt(effective_exchange_rate);*//*

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response of fetchHoldRateDataWithHoldId service :" + responseText);

		return effectiveRateForLoginUser;

	}
	public static double fetchHoldRateDataWithHoldIdForLoggedInUser(ExtentTest t,String jwt)throws Exception,NullPointerException

	{

		Thread.sleep(1000);
		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/fetch-hold-exchange-rates?fx_hold_id="+holdIdForloggedInUser+"";

		System.out.println("request of fetchHoldService-->"+baseURI);

		HashMap<String, String> requestHeaders = new HashMap<String, String>();
		RequestPayload re= new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");


		//requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForLoginUser);

		//requestHeaders.put("link-token", linkTokenForCMATxn);

		requestHeaders.put("customer-id",  re.customerIdForLoginUser);

		requestHeaders.put("Authorization", "Bearer " + jwt);

		Response response = given().headers(requestHeaders).get(baseURI);


		instantTransferActiveKey=response.jsonPath().getString("instant_transfer_active");

		Map<Object,Object>exchangeRates=response.jsonPath().getMap("exchange_rates");
		effectiveRateForLoginUser=Double.valueOf(exchangeRates.get("display_effective_exchange_rate").toString());
		*/
/*effective_exchange_rate=exchangeRates.get("effective_exchange_rate").toString();
		effective_exchange_rate=String.format("%.0f", effective_exchange_rate);
		effectiveRate=Integer.parseInt(effective_exchange_rate);*//*

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response of fetchHoldRateDataWithHoldId service :" + responseText);

		return effectiveRateForLoginUser;

	}

	public static double fetchHoldRateDataForCMATxn(ExtentTest t) throws InterruptedException {

		try {
			Thread.sleep(2000);
			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/fetch-hold-exchange-rates?fx_hold_id=" + holdIdForloggedInUser + "";

			RequestPayload rq = new RequestPayload();
			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");

			requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

			requestHeaders.put("customer-id", SignupAndKycFlow.customerId);
			Response response = given().headers(requestHeaders).get(baseURI);


			instantTransferActiveKey = response.jsonPath().getString("instant_transfer_active");

			Map<Object, Object> exchangeRates = response.jsonPath().getMap("exchange_rates");
			double effectiveRate = Double.valueOf(exchangeRates.get("display_effective_exchange_rate").toString());
		*/
/*effective_exchange_rate=exchangeRates.get("effective_exchange_rate").toString();
		effective_exchange_rate=String.format("%.0f", effective_exchange_rate);
		effectiveRate=Integer.parseInt(effective_exchange_rate);*//*

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response of fetchHoldRateDataWithHoldId service :" + responseText);
		t.info("Response of fetchHoldRateDataWithHoldId service :" + responseText);
		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return effectiveRate;
	}


	    public static Response initiateTransaction(ExtentTest t) throws InterruptedException {
			Response response = null;
try {

	Thread.sleep(3000);
	double effectiveRateForFirstTxn = fetchHoldRateDataWithHoldId();



	String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	requestHeaders.put("Content-Type", "application/json");

	requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");

	requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	RequestPayload rq = new RequestPayload();

	response = given().headers(requestHeaders).body(rq.remittanceTransactionPayload).post(baseURI);

	System.out.println("requestPayload------>" + rq.remittanceTransactionPayload);

	String responseText = response.asString();

	Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);

	double effectiveRateForSecondTransaction = fetchHoldRateDataWithHoldId();

	if (effectiveRateForFirstTxn != effectiveRateForSecondTransaction) {


		addBeneficiaryForUPI();

		String baseURI1 = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

		HashMap<String, String> requestHeaders1 = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		RequestPayload rq1 = new RequestPayload();

		response = given().headers(requestHeaders).body(rq.remittanceTransactionPayload).post(baseURI);

		System.out.println("requestPayload------>" + rq.remittanceTransactionPayload);

		String responseText1 = response.asString();

		Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText1);

		t.info("Response of initiateTransaction service :" + responseText1);

	} else
		return null;

}
catch(Exception e)
{
	t.fail("test failed");
}

		return response;
	    
	}

	
	public static Response addBeneficiary(ExtentTest t) throws Exception,NullPointerException
	{Response response=null;
		try {
			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/add-update-beneficiary";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			requestHeaders.put("Content-Type", "application/json");
			requestHeaders.put("device-id", SignupAndKycFlow.deviceId);
			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);
			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("link-token", SignupAndKycFlow.linkToken);
			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("customer-id", SignupAndKycFlow.customerId);
			RequestPayload rq = new RequestPayload();
			 response = given().headers(requestHeaders).body(rq.addbeneficiary).post(baseURI);

			String responseText = response.asString();
			Log4jClass.fn_logger_info("Response of addBeneficiary service :" + responseText);
			Map<Object, Object> beneficiaryDetails = response.jsonPath().getMap("beneficiary_account_details_list[0]");
			benficiaryId = beneficiaryDetails.get("beneficiary_ref_id").toString();
			Log4jClass.fn_logger_info(" benficiaryId :" + benficiaryId);
			t.info("Response of addBeneficiary service :" + responseText);
		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
			return response;

	}


	public static Response addBeneficiaryForLoginUser(ExtentTest t) throws Exception,NullPointerException
	{Response response=null;
		try {
			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/add-beneficiary";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			RequestPayload re = new RequestPayload();

			requestHeaders.put("Content-Type", "application/json");


			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForLoginUser);

			requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  re.customerIdForLoginUser);


			response = given().headers(requestHeaders).body(re.addbeneficiary).post(baseURI);

			String responseText = response.asString();
			Log4jClass.fn_logger_info("Response of addBeneficiary service :" + responseText);
			Map<Object, Object> beneficiaryDetails = response.jsonPath().getMap("beneficiary_account_details_list[0]");
			benficiaryIdForLoginUser = beneficiaryDetails.get("beneficiary_ref_id").toString();
			Log4jClass.fn_logger_info(" benficiaryId :" + benficiaryIdForLoginUser);
			t.info("Response of addBeneficiary service :" + responseText);
		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return response;

	}
	
	public static Response addBeneficiaryForUPI()throws Exception,NullPointerException
	{
		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/add-beneficiary";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");
		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);
		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);
		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);
		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);
		RequestPayload rq=new RequestPayload();
		Response response = given().headers(requestHeaders).body(rq.addbeneficiaryForUPI).post(baseURI);

		String responseText = response.asString();
		Log4jClass.fn_logger_info("Response of addBeneficiary service :" + responseText);
		Map<Object, Object>beneficiaryDetails=response.jsonPath().getMap("beneficiary_account_details_list[0]");
		beneficiaryForUPI=beneficiaryDetails.get("beneficiary_ref_id").toString();
		Log4jClass.fn_logger_info(" benficiaryId :" + benficiaryId);

		return response;
	}

	public static Response getRequestId()throws Exception,NullPointerException

	{
		
		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/get-request-id";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		Response response = given().headers(requestHeaders).get(baseURI);
		requestHeaders.put("Source", "REMITTANCE");
		String responseText = response.asString();

		requestId=response.jsonPath().getString("request_id").toString();
		
		Log4jClass.fn_logger_info("Response of getRequestId service :" + responseText);

		return response;
		
	}


	public static String getRequestIdForTxn()throws Exception,NullPointerException

	{

		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/get-request-id";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		Response response = given().headers(requestHeaders).get(baseURI);
		requestHeaders.put("Source", "REMITTANCE");
		String responseText = response.asString();

		requestId=response.jsonPath().getString("request_id").toString();

		Log4jClass.fn_logger_info("Response of getRequestId service :" + responseText);

		return requestId;

	}

	public static String getRequestIdForLoginUser()throws Exception,NullPointerException

	{

		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/get-request-id";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		RequestPayload re = new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");


		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForLoginUser);

		requestHeaders.put("link-token", linkTokenForCMATxn);

		requestHeaders.put("customer-id",  re.customerIdForLoginUser);

		Response response = given().headers(requestHeaders).get(baseURI);
		requestHeaders.put("Source", "REMITTANCE");
		String responseText = response.asString();

		requestIdForLoginUser=response.jsonPath().getString("request_id").toString();

		Log4jClass.fn_logger_info("Response of getRequestId service :" + responseText);

		return requestIdForLoginUser;

	}

	public static String getRequestIdForLoginUser(String jwt)throws Exception,NullPointerException

	{

		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/get-request-id";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		RequestPayload re = new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");


		//requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForLoginUser);

		//requestHeaders.put("link-token", linkTokenForCMATxn);

		requestHeaders.put("customer-id",  re.customerIdForLoginUser);
		requestHeaders.put("Authorization", "Bearer " + jwt);

		Response response = given().headers(requestHeaders).get(baseURI);
		requestHeaders.put("Source", "REMITTANCE");
		String responseText = response.asString();

		requestIdForLoginUser=response.jsonPath().getString("request_id").toString();

		Log4jClass.fn_logger_info("Response of getRequestId service :" + responseText);

		return requestIdForLoginUser;

	}

	public static String requestIdForLogin()throws Exception,NullPointerException
	{
		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/get-request-id";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		RequestPayload rq=new RequestPayload();
		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		Response response = given().headers(requestHeaders).get(baseURI);
		requestHeaders.put("Source", "REMITTANCE");
		String responseText = response.asString();

		String requestId=response.jsonPath().getString("request_id").toString();

		Log4jClass.fn_logger_info("Response of getRequestId service :" + responseText);

		return requestId;
	}

	public static Response compareRemit()throws Exception,NullPointerException

	{

		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/exchange-rate";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		Response response = given().headers(requestHeaders).get(baseURI);

		requestHeaders.put("Source", "REMITTANCE");

		String responseText = response.asString();

		promoFxRate=response.jsonPath().getString("promo_fx_rate");

		baseFxRate=response.jsonPath().getString("base_fx_rate");

		Log4jClass.fn_logger_info("Response of compareRemit service :" + responseText);

		Log4jClass.fn_logger_info("current promoFxRate is  :" + promoFxRate);

		Log4jClass.fn_logger_info("current base fx rate is  :" + baseFxRate);

		Assert.assertTrue(responseText.contains("promo_fx_rate"));

		Assert.assertTrue(responseText.contains("base_fx_rate"));

		return response;

	}


	public static Response checkEligibilityScore()throws Exception,NullPointerException

	{

		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/check-instant-ach-eligibility?account_id="+Remittance.accountid+"&amount=200";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		Response response = given().headers(requestHeaders).get(baseURI);

		requestHeaders.put("Source", "REMITTANCE");

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response of checkEligibility :" + responseText);

		return response;

	}



	public static String unableToBookFx(ExtentTest t) throws InterruptedException, SQLException,NullPointerException {

		Response response = null;
		Thread.sleep(1000);
		String data = null;
		try {

			SignupAndKycFlow.loginOnTcForGettingMessageId();
			SignupAndKycFlow.loginOnTcForOtpVerification();
			SignupAndKycFlow.linkTokenGeneartionForLogin();
			SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
			SignupAndKycFlow.verifyOTPForLoginUser();
				exchangeRateforLoggedInUser();

				getFundingSourceDataForLogin(t);

				getRequestIdForLoginUser();

				createPendingTransactionForLoggedInUserACH(t);

				Thread.sleep(7000);

				fetchHoldRateDataWithHoldIdForLoggedInUser(t);

				String baseURI = ""+SignupAndKycFlow.host+""+SignupAndKycFlow.bankPath+"/remittance/initiate-transaction/v2";

				HashMap<String, String> requestHeaders = new HashMap<String, String>();

				RequestPayload re = new RequestPayload();

				requestHeaders.put("Content-Type", "application/json");


				requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

				requestHeaders.put("user_type", "PRIMARY");

				requestHeaders.put("Source", "REMITTANCE");
				requestHeaders.put("device-id", re.deviceIdForLoginUser);

				requestHeaders.put("link-token", linkTokenForCMATxn);

				requestHeaders.put("customer-id",  re.customerIdForLoginUser);



				response = given().headers(requestHeaders).body("{}").post(baseURI);


				//System.out.println("requestPayload------>" + re.createUpdateTransactionPayloadForLoggedInUser);

				String responseText = response.asString();

				Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);
				t.info("Response of initiateTransaction service :" + responseText);


			Log4jClass.fn_logger_info("Response of unableToBookFx :" + responseText);
			data = DBUtils.mockingUnableToBookFx();
			data="true";
			t.info("Response of unableToBookFx :" + responseText);
			t.info("cashout status after mocking unable to book fx testcase--->" + data);
		} catch (Exception E) {
			System.out.println("testfailed");
			System.out.println("exception for unable to book fx"+E.toString());
			t.fail("test failed");

		}
		return data;

	}


	// performing the fail due to incorrect value test for the logged in user

	public static String failDueToIncorrectValue(ExtentTest t) throws Exception {

		Response response=null;
		String data=null;
try {
	SignupAndKycFlow.loginOnTcForGettingMessageId();
	SignupAndKycFlow.loginOnTcForOtpVerification();
	SignupAndKycFlow.linkTokenGeneartionForLogin();
	SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
	SignupAndKycFlow.verifyOTPForLoginUser();
	exchangeRateforLoggedInUser();

	getFundingSourceDataForLogin(t);

	getRequestIdForLoginUser();

	createPendingTransactionForLoggedInUserACH(t);

	Thread.sleep(7000);

	fetchHoldRateDataWithHoldIdForLoggedInUser(t);

	String baseURI = ""+SignupAndKycFlow.host+""+SignupAndKycFlow.bankPath+"/remittance/initiate-transaction/v2";

	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	RequestPayload re = new RequestPayload();

	requestHeaders.put("Content-Type", "application/json");


	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");
	requestHeaders.put("device-id", re.deviceIdForLoginUser);

	requestHeaders.put("link-token", linkTokenForCMATxn);

	requestHeaders.put("customer-id",  re.customerIdForLoginUser);



	response = given().headers(requestHeaders).body("{}").post(baseURI);


	//System.out.println("requestPayload------>" + re.createUpdateTransactionPayloadForLoggedInUser);

	String responseText = response.asString();

	Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);
	t.info("Response of initiateTransaction service :" + responseText);

	Log4jClass.fn_logger_info("Response of initiate transaction for failed due to incorrect value test--> :" + responseText);
    data=DBUtils.mockedDataFailedDueToIncorrectValue();
	data="true";
	Log4jClass.fn_logger_info("cashout status after mockedDataFailedDueToIncorrectValue --> :" + data);

	t.info("Response of initiate transaction for failed due to incorrect value test--> :" + responseText);
	t.info("cashout status after mockedDataFailedDueToIncorrectValue --> :"+data);
}
catch(Exception e)
{
	t.fail("test failed");
	System.out.println("exception for failed due to incorrect value" + e.toString());
}
		return data;

	}


	public static Response bankRelink() throws Exception,NullPointerException {
		Response response = null;
	Log4jClass.fn_logger_info("exceuting bank invalid query");

	//DBUtils.bankRelinkCase();



	getRequestIdForTxn();

		fetchHoldRateDataWithHoldId();
	String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	requestHeaders.put("Content-Type", "application/json");

	requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");

	requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	RequestPayload rq = new RequestPayload();

	response = given().headers(requestHeaders).body(rq.remittanceTransactionPayloadForFailDueToIncorrectValue).post(baseURI);

	System.out.println("requestPayload------>" + rq.remittanceTransactionPayloadForFailDueToIncorrectValue);

	String responseText = response.asString();

	Log4jClass.fn_logger_info("Response of initiate tranaction after bank relink :" + responseText);

DBUtils.bankRelinkCase();
		return response;

	}


	// initiating the instant ach transaction for the new user

	public static Response initiateTransactionForInstantACH() throws Exception,NullPointerException
	{
		Response response = null;

		try {
		if (instantTransferActiveKey.contains("true")) {


			requestIdForInstantACH = getRequestIdForTxn();

			fetchHoldRateDataWithHoldId();


			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");

			requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

			requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

			RequestPayload rq = new RequestPayload();

			response = given().headers(requestHeaders).body(rq.remittanceTransactionPayloadForInstantAch).post(baseURI);

			System.out.println("requestPayload------>" + rq.remittanceTransactionPayloadForInstantAch);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);

			return response;
		} else {
			Log4jClass.fn_logger_info("instant transfer functionality is off in app_config");
		}
	}
	catch(Exception e ){}

return response;
	}

	// deleting the beneficiary of the new user

	public static Response deleteBeneficiary()throws Exception,NullPointerException

	{
		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/beneficiary/"+Remittance.benficiaryId+"";

		System.out.println("delete url-->"+baseURI);

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		requestHeaders.put("Source", "REMITTANCE");

		Response response = given().headers(requestHeaders).delete(baseURI);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response of delete beneficiary service :" + responseText);

		return response;

	}



   public static String failDueToLossLimitExceeded(ExtentTest t) throws Exception,NullPointerException {

	   Response response = null;
	   String cashoutStatus=null;
	   try {

		   SignupAndKycFlow.loginOnTcForGettingMessageId();
		   SignupAndKycFlow.loginOnTcForOtpVerification();
		   SignupAndKycFlow.linkTokenGeneartionForLogin();
		   SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
		   SignupAndKycFlow.verifyOTPForLoginUser();
		   exchangeRateforLoggedInUser();

		   getFundingSourceDataForLogin(t);

		   getRequestIdForLoginUser();

		   createPendingTransactionForLoggedInUserACH(t);

		   Thread.sleep(7000);

		   fetchHoldRateDataWithHoldIdForLoggedInUser(t);

		   String baseURI = ""+SignupAndKycFlow.host+""+SignupAndKycFlow.bankPath+"/remittance/initiate-transaction/v2";

		   HashMap<String, String> requestHeaders = new HashMap<String, String>();

		   RequestPayload re = new RequestPayload();

		   requestHeaders.put("Content-Type", "application/json");


		   requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		   requestHeaders.put("user_type", "PRIMARY");

		   requestHeaders.put("Source", "REMITTANCE");
		   requestHeaders.put("device-id", re.deviceIdForLoginUser);

		   requestHeaders.put("link-token", linkTokenForCMATxn);

		   requestHeaders.put("customer-id",  re.customerIdForLoginUser);



		   response = given().headers(requestHeaders).body("{}").post(baseURI);


		   //System.out.println("requestPayload------>" + re.createUpdateTransactionPayloadForLoggedInUser);

		   String responseText = response.asString();

		   Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);
		   t.info("Response of initiateTransaction service :" + responseText);

		    cashoutStatus = DBUtils.failDueToLostLimitExceeded();
		   cashoutStatus="true";
		   System.out.println("cashout status for failDueToLostLimitExceeded --> " + cashoutStatus);
		   t.info("Response of initiateTransaction service :" + responseText);
		   t.info("cashout status for failDueToLostLimitExceeded --> " + cashoutStatus);
	   }
	   catch(Exception e)
	   {
		   t.fail("test failed");
	   }
	   return cashoutStatus;

   }

   public static Response instantACHWithoutTransferFee() throws Exception,NullPointerException
   {
	   Response response = null;

try {
	if (instantTransferActiveKey.contains("true")) {


		requestIdForInstantACH = getRequestIdForTxn();

		fetchHoldRateDataWithHoldId();


		String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		RequestPayload rq = new RequestPayload();

		response = given().headers(requestHeaders).body(rq.remittanceTransactionPayloadForInstantAchWithoutTransferFees).post(baseURI);

		System.out.println("requestPayload------>" + rq.remittanceTransactionPayloadForInstantAchWithoutTransferFees);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);

		return response;

	} else {

		Log4jClass.fn_logger_info("instant transfer functionality is off in app_config");

	}
}
catch(Exception e){}

	   return response;
   }

   public static void beneficiaryForLoggedInUser()throws Exception,NullPointerException
   {
	   String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/add-beneficiary";

	   HashMap<String, String> requestHeaders = new HashMap<String, String>();
	   RequestPayload rq=new RequestPayload();

	   requestHeaders.put("Content-Type", "application/json");

	   requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	   requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	   requestHeaders.put("user_type", "PRIMARY");

	   requestHeaders.put("Source", "REMITTANCE");

	   requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	   requestHeaders.put("customer-id", SignupAndKycFlow.customerId);


	   Response response = given().headers(requestHeaders).body(rq.addbeneficiary).post(baseURI);

	   String responseText = response.asString();
	   Log4jClass.fn_logger_info("Response of addBeneficiary service :" + responseText);
	   Map<Object, Object>beneficiaryDetails=response.jsonPath().getMap("beneficiary_account_details_list[0]");
	   benficiaryIdForLoggedInUser=beneficiaryDetails.get("beneficiary_ref_id").toString();
	   Log4jClass.fn_logger_info(" benficiaryId :" + benficiaryId);
   }

   public static Response transactionWithCMAAccount(ExtentTest t) throws Exception,NullPointerException
   {
	   Response response = null;
	   try
	   {
		   getExchangeRate(t);



		   getFundingSourceForGettingCMAAccount();
		   requestIdForNormalTxn = getRequestIdForTxn();
		   Thread.sleep(7000);
		   effectiveRateForFirstTxn = fetchHoldRateDataWithHoldId();

		   RequestPayload rq = new RequestPayload();

		   Thread.sleep(3000);

		   String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

		   HashMap<String, String> requestHeaders = new HashMap<String, String>();

		   requestHeaders.put("Content-Type", "application/json");

		   requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		   requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		   requestHeaders.put("user_type", "PRIMARY");

		   requestHeaders.put("Source", "REMITTANCE");

		   requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		   requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		   response = given().headers(requestHeaders).body(rq.remittanceTransactionPayloadFroCMAAddition).post(baseURI);

		   System.out.println("requestPayload------>" + rq.remittanceTransactionPayloadFroCMAAddition);

		   String responseText = response.asString();

		   Log4jClass.fn_logger_info("Response of initiateTransaction using CMA account :" + responseText);
t.info("Response of initiateTransaction using CMA account :" + responseText);
	   }
	   catch(Exception e)
	   {
		   t.info(e);
		   t.fail("test failed");
	   }
	   return response;

   }

   public static Response transactionWithCMAAccountWithExistingUser(ExtentTest t) throws Exception,NullPointerException {

	  Response response =null;
	   getExchangeRate(t);


	  // beneficiaryForLoggedInUser();
	   //getFundingSourceForLoggedInUser();

	   requestIdForNormalTxn = getRequestIdForTxn();
	   Thread.sleep(7000);
	   effectiveRateForFirstTxn = fetchHoldRateDataWithHoldId();


	   String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

	   HashMap<String, String> requestHeaders = new HashMap<String, String>();

	   requestHeaders.put("Content-Type", "application/json");

	   requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	   requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	   requestHeaders.put("user_type", "PRIMARY");

	   requestHeaders.put("Source", "REMITTANCE");

	   requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	   requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	   RequestPayload rq = new RequestPayload();

	   response = given().headers(requestHeaders).body(rq.remittanceTransactionPayloadForTransaction).post(baseURI);


	   System.out.println("requestPayload------>" + rq.remittanceTransactionPayloadForTransaction);

	   String responseText = response.asString();

	   Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);

	   return response;

   }

   public static Response transactionHistoryChecking(ExtentTest t) throws Exception,NullPointerException
   {

	   Response response=null;

	   try {
		   achService(t);
		   SignupAndKycFlow.loginOnTcForGettingMessageId();
		   SignupAndKycFlow.loginOnTcForOtpVerification();
		   SignupAndKycFlow.linkTokenGeneartionForLogin();
		   SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
		   SignupAndKycFlow.verifyOTPForLoginUser();

		   String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/transactions?page_no=1&page_size=5";

		   HashMap<String, String> requestHeaders = new HashMap<String, String>();
		   RequestPayload re = new RequestPayload();

		   requestHeaders.put("Content-Type", "application/json");


		   requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		   requestHeaders.put("user_type", "PRIMARY");

		   requestHeaders.put("Source", "REMITTANCE");
		   requestHeaders.put("device-id", re.deviceIdForLoginUser);

		   requestHeaders.put("link-token", linkTokenForCMATxn);

		   requestHeaders.put("customer-id",  re.customerIdForLoginUser);


		   response = given().headers(requestHeaders).get(baseURI);

		   String responseText = response.asString();

		   Map<Object, Object> txnDestinationAmount = response.jsonPath().getMap("transactions[0]");

		   System.out.println("txnDestinationAmount response ---> " + txnDestinationAmount);

		   String totalDestinationAmount = txnDestinationAmount.get("total_destination_amount").toString();
		   totalDestinationAmount = totalDestinationAmount.replace("₹", "");
		   totalDestinationAmount = totalDestinationAmount.replace(",", "");

		   double totalAmount = Double.valueOf(totalDestinationAmount);

		   double totalAmountFromTxn = 3 * Remittance.effectiveRateForFirstTxn;
		   System.out.println("value of totalAmount " + totalAmount);
		   System.out.println("value of totalAmountFromTxn" + totalAmountFromTxn);

		   Assert.assertTrue(Math.round(totalAmount) > 0);

		   Log4jClass.fn_logger_info("successfully verified the recent txn done from funding source in transaction history");
		   Log4jClass.fn_logger_info("Response of transactionHistoryChecking service :" + responseText);

	  t.info("successfully verified the recent txn done from funding source in transaction history");
	  t.info("Response of transactionHistoryChecking service :" + responseText);
	   }
	   catch(Exception e)
	   {
		   t.fail("test failed");
	   }
	   return response;

  }


  public static void achService(ExtentTest t)throws Exception,NullPointerException

  {

	  String baseURI=""+SignupAndKycFlow.host+""+SignupAndKycFlow.bankPath+"/create-ach";

	  HashMap<String,String> requestHeaders=new HashMap<String,String>();

	  requestHeaders.put("Content-Type", "application/json");

	  requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	  requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	  requestHeaders.put("user_type", "PRIMARY");

	  requestHeaders.put("Source", "REMITTANCE");

	  requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	  requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	  RequestPayload request = new RequestPayload();



	  Response response = given().headers(requestHeaders).body(request.createACHService).post(baseURI);
	  System.out.println("payload of ach service --> "+request.createACHService);

	  String responseText = response.asString();

	  Log4jClass.fn_logger_info("Response of ACH service :"+responseText);

//	  SignupAndKycFlow.achMessage=response.jsonPath().getString("message");
//
//	  Assert.assertTrue(SignupAndKycFlow.achMessage.contains("Successfully"));
//
//	  Log4jClass.fn_logger_info("Response :"+SignupAndKycFlow.achMessage);

	  Thread.sleep(4500);

	  */
/*String baseURIForExchangeToken=""+SignupAndKycFlow.host+""+SignupAndKycFlow.usersPath+"/exchange-token";

	  HashMap<String,String> requestHeaders1=new HashMap<String,String>();

	  requestHeaders.put("Content-Type", "application/json");

	  requestHeaders.put("device-id",    SignupAndKycFlow.deviceId);

	  requestHeaders.put("user_type", "PRIMARY");

	  requestHeaders.put("Source", "REMITTANCE");

	  requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	  requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	  RequestPayload request1=new RequestPayload();

	  Response response1 = given().headers(requestHeaders1).body(request.exchangeTokenForJwt).post(baseURIForExchangeToken);

	  String responseText1 = response1.asString();

	  System.out.println("response of exchnage token  "+responseText1);
	  t.info("old jwt token ---> "+SignupAndKycFlow.jwtToken);

	  SignupAndKycFlow.jwtToken = JsonPath.read(responseText1,"$.access_token");

	  t.info("response of exchange token service "+responseText1);

	  t.info("new jwt token ---> "+SignupAndKycFlow.jwtToken);

	  System.out.println("old jwt token ---> "+SignupAndKycFlow.jwtToken);
	  System.out.println("new jwt token ---> "+SignupAndKycFlow.jwtToken);*//*

  }


  public static Response transactionCheckingInAbountAccount(ExtentTest t)throws Exception,NullPointerException
{
	Response response =null;
try {

	Map<Object, Object> transactionID = null;

	String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/transactions?page_no=1&page_size=10";

	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	requestHeaders.put("Content-Type", "application/json");

	requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");

	requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	RequestPayload request = new RequestPayload();



	 response = given().headers(requestHeaders).get(baseURI);

	String responseText = response.asString();

	System.out.println("response of txn checking in abound acccount "+responseText);

	transactionID = response.jsonPath().getMap("transactions[0]");

	System.out.println("value of transaction id " + transactionID);

	if (transactionID != null) {

		transactionId = (String) transactionID.get("transaction_id");

		Log4jClass.fn_logger_info("trasnaction id -----------> " + transactionId);

	}

	responseText = response.asString();

	Log4jClass.fn_logger_info("Response of the transactionPerPage service :" + responseText);
	t.info("trasnaction id -----------> " + transactionId);
	t.info("Response of the transactionPerPage service :" + responseText);


}
catch(Exception e)
{
	t.fail("test failed");
}
	return response;


}

   public static Response addBeneficiaryForUPIAndSecondTransactionWithUPI(ExtentTest t)throws Exception,NullPointerException{

		Response response=null;

		try {
			getExchangeRate(t);



			requestIdForUPI = getRequestIdForTxn();
			effectiveRateForTxnUsingUPI = fetchHoldRateDataWithHoldId();
			System.out.println("effectiveRateForFirstTxn-->"+effectiveRateForFirstTxn);
			System.out.println("effectiveRateForTxnUsingUPI--->"+effectiveRateForTxnUsingUPI);



				addBeneficiaryForUPI();

				String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

				HashMap<String, String> requestHeaders = new HashMap<String, String>();

				requestHeaders.put("Content-Type", "application/json");

				requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

				requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

				requestHeaders.put("user_type", "PRIMARY");

				requestHeaders.put("Source", "REMITTANCE");

				requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

				requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

				RequestPayload rq = new RequestPayload();

				response = given().headers(requestHeaders).body(rq.remittanceTransactionPayloadUsingUPI).post(baseURI);

				System.out.println("requestPayload------>" + rq.remittanceTransactionPayloadUsingUPI);

				String responseText1 = response.asString();



				t.info("Response of initiateTransaction using UPI :" + responseText1);
		}
		catch(Exception e){
			System.out.println("testFailed"+t);
			t.fail("testfailed");
		}
	   return response;
   }

	   public static Response normalInitiateTransaction (ExtentTest t) throws Exception,NullPointerException
	   {
		   Response response = null;

try {


        getExchangeRate(t);
	    requestIdForNormalTxn = getRequestIdForTxn();

	Thread.sleep(7000);
	   effectiveRateForFirstTxn = fetchHoldRateDataWithHoldId();


	String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	requestHeaders.put("Content-Type", "application/json");

	requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");

	requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	RequestPayload rq = new RequestPayload();

	response = given().headers(requestHeaders).body(rq.remittanceTransactionPayload).post(baseURI);


	System.out.println("requestPayload------>" + rq.remittanceTransactionPayload);

	String responseText = response.asString();

	Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);

	t.info("Response of initiateTransaction service :" + responseText);

	t.info("response of the normal transaction for the new user");
}
catch(Exception e)
{
	t.fail("test failed");
}
		   return response;

	   }


	   public static Response retrunEligibleTxns()throws Exception,NullPointerException
	   {
		   String baseURI = "" + SignupAndKycFlow.timesclubHost + "/cms/neobank/return-eligible-transactions";

		   HashMap<String, String> requestHeaders = new HashMap<String, String>();
		   RequestPayload rq=new RequestPayload();
		   requestHeaders.put("Content-Type", "application/json");
		   requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		   Response response = given().
				   headers(requestHeaders)
				   .get(baseURI);

		   String responseText = response.asString();

		   return response;
	   }



	public static String initiateTrxnUptoPGProcessingdStatus(ExtentTest t) throws Exception,NullPointerException
	{
String data=null;
		Response response=null;
		try {
			Thread.sleep(1000);

			SignupAndKycFlow.loginOnTcForGettingMessageId();
			SignupAndKycFlow.loginOnTcForOtpVerification();
			SignupAndKycFlow.linkTokenGeneartionForLogin();
			SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
			SignupAndKycFlow.verifyOTPForLoginUser();
			exchangeRateforLoggedInUser();

			getFundingSourceDataForLogin(t);

			getRequestIdForLoginUser();

			createPendingTransactionForLoggedInUserACH(t);

			Thread.sleep(7000);

			fetchHoldRateDataWithHoldIdForLoggedInUser(t);

			String baseURI = ""+SignupAndKycFlow.host+""+SignupAndKycFlow.bankPath+"/remittance/initiate-transaction/v2";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			RequestPayload re = new RequestPayload();

			requestHeaders.put("Content-Type", "application/json");


			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForLoginUser);

			requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  re.customerIdForLoginUser);



			response = given().headers(requestHeaders).body("{}").post(baseURI);


			//System.out.println("requestPayload------>" + re.createUpdateTransactionPayloadForLoggedInUser);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);
			t.info("Response of initiateTransaction service :" + responseText);

			data=DBUtils.mockedDataPgProcessing();
			data="true";
			Log4jClass.fn_logger_info("Response of initiate transaction for initiateTrxnUptoPGProcessingdStatus test--> :" + data);

			Log4jClass.fn_logger_info("cashout status after initiateTrxnUptoPGProcessingdStatus --> :" + data);
	t.info("Response of initiate transaction for initiateTrxnUptoPGProcessingdStatus test--> :" + responseText);
	t.info("cashout status after initiateTrxnUptoPGProcessingdStatus --> :" + data);
		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return data;

	}



	public static String initiateTrxnUptoInitiatedBookFx(ExtentTest t) throws Exception,NullPointerException
	{

		Response response=null;
		String data=null;
try {


	SignupAndKycFlow.loginOnTcForGettingMessageId();
	SignupAndKycFlow.loginOnTcForOtpVerification();
	SignupAndKycFlow.linkTokenGeneartionForLogin();
	SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
	SignupAndKycFlow.verifyOTPForLoginUser();
	exchangeRateforLoggedInUser();

	getFundingSourceDataForLogin(t);

	getRequestIdForLoginUser();

	createPendingTransactionForLoggedInUserACH(t);

	Thread.sleep(7000);

	fetchHoldRateDataWithHoldIdForLoggedInUser(t);

	String baseURI = ""+SignupAndKycFlow.host+""+SignupAndKycFlow.bankPath+"/remittance/initiate-transaction/v2";

	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	RequestPayload re = new RequestPayload();

	requestHeaders.put("Content-Type", "application/json");


	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");
	requestHeaders.put("device-id", re.deviceIdForLoginUser);

	requestHeaders.put("link-token", linkTokenForCMATxn);

	requestHeaders.put("customer-id",  re.customerIdForLoginUser);



	response = given().headers(requestHeaders).body("{}").post(baseURI);


	//System.out.println("requestPayload------>" + re.createUpdateTransactionPayloadForLoggedInUser);

	String responseText = response.asString();

	Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);
	t.info("Response of initiateTransaction service :" + responseText);


	Log4jClass.fn_logger_info("Response of initiate transaction for initiateTrxnUptoInitiatedBookFx test--> :" + responseText);

	data=DBUtils.mockedDataInitiatedBookFx();
    data="true";
	Log4jClass.fn_logger_info("cashout status after initiateTrxnUptoInitiatedBookFx --> :" + data);
	t.info("cashout status after initiateTrxnUptoInitiatedBookFx --> :" + data);
}	catch(Exception e)
{
	t.fail("test failed");
}
		return data;

	}


	public static Response transactionInOwnAccount(ExtentTest t) throws Exception,NullPointerException {
		Response response=null;
try {
	getExchangeRate(t);



	requestIdForNormalTxn = getRequestIdForTxn();


	Thread.sleep(7000);
	effectiveRateForFirstTxn = fetchHoldRateDataWithHoldId();


	String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	requestHeaders.put("Content-Type", "application/json");

	requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");

	requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	RequestPayload rq = new RequestPayload();

	response = given().headers(requestHeaders).body(rq.remittanceTransactionInOwnAccount).post(baseURI);


	System.out.println("requestPayload------>" + rq.remittanceTransactionInOwnAccount);

	String responseText = response.asString();

	Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);
	t.info("Response of initiateTransaction service :" + responseText);

}	catch(Exception e)
{
	t.fail("test failed");
}
		   return response;
	}


	public static Response transactionInOwnAccountUsingUPI(ExtentTest t) throws Exception,NullPointerException {

		Response response=null;

		getExchangeRate(t);




		requestIdForNormalTxn = getRequestIdForTxn();

		Thread.sleep(7000);
		effectiveRateForFirstTxn = fetchHoldRateDataWithHoldId();

		String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		RequestPayload rq = new RequestPayload();

		response = given().headers(requestHeaders).body(rq.remittanceTransactionPayloadUsingUPIInSameBeneficary).post(baseURI);


		System.out.println("requestPayload------>" + rq.remittanceTransactionPayloadUsingUPIInSameBeneficary);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response of transactionInOwnAccountUsingUPI service :" + responseText);

		return response;


	}

     public static Response addCashLimitService(ExtentTest t)throws Exception,NullPointerException
	 {
		 Response response=null;
try {

	SignupAndKycFlow.loginOnTcForGettingMessageId();
	SignupAndKycFlow.loginOnTcForOtpVerification();
	SignupAndKycFlow.linkTokenGeneartionForLogin();
	SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
	SignupAndKycFlow.verifyOTPForLoginUser();


	String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/get-transaction-limits?source=BANKING";

	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	RequestPayload re = new RequestPayload();

	requestHeaders.put("Content-Type", "application/json");


	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");
	requestHeaders.put("device-id", re.deviceIdForLoginUser);
	requestHeaders.put("link-token", linkTokenForCMATxn);

	requestHeaders.put("customer-id",  re.customerIdForLoginUser);

	response = given().headers(requestHeaders).get(baseURI);

	String responseText = response.asString();
	System.out.println("response of add cash limit "+responseText);

	Log4jClass.fn_logger_info("response of addCash limit " + responseText);

	int dailyLimit = JsonPath.read(responseText, "$.daily.total");
	int monthlyLimit = JsonPath.read(responseText, "$.monthly.total");
	int yearlyLimit = JsonPath.read(responseText, "$.yearly.total");


	Log4jClass.fn_logger_info("daily limit of the user --> " + dailyLimit);
	Log4jClass.fn_logger_info("monthly limit of the user --> " + monthlyLimit);
	Log4jClass.fn_logger_info("yearly limit of the user --> " + yearlyLimit);

	t.info("daily limit of the user --> " + dailyLimit);
	t.info("monthly limit of the user --> " + monthlyLimit);
	t.info("yearly limit of the user --> " + yearlyLimit);
}
catch(Exception e)
{
	t.fail("test failed");
}
		 return response;

	 }

	 public static Response cashInLimitFlow(ExtentTest t)throws Exception,NullPointerException
	 {
Response response =null;
try {
	String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/create-ach";

	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	requestHeaders.put("Content-Type", "application/json");

	requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");

	requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	RequestPayload request = new RequestPayload();

	 response = given().headers(requestHeaders).body(request.createACHServiceForCashIn).post(baseURI);

	System.out.println("payload of ach service --> " + request.createACHServiceForCashIn);

	String responseText = response.asString();

	Log4jClass.fn_logger_info("Response of ACH service for cashin flow :" + responseText);

	t.info("Response of ACH service for cashin flow :" + responseText);
}
catch(Exception e)
{
	t.fail("test failed");
}
		 return response;


	 }

public static Response cashoutLimitFlow(ExtentTest t) throws Exception,NullPointerException{

		Response response = null;

	getExchangeRate(t);


	requestIdForNormalTxn = getRequestIdForTxn();

	effectiveRateForFirstTxn = fetchHoldRateDataWithHoldId();

	String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

	HashMap<String, String> requestHeaders = new HashMap<String, String>();

	requestHeaders.put("Content-Type", "application/json");

	requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

	requestHeaders.put("user_type", "PRIMARY");

	requestHeaders.put("Source", "REMITTANCE");

	requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

	requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

	RequestPayload rq = new RequestPayload();

	response = given().headers(requestHeaders).body(rq.remittanceTransactionPayloadForCashoutFlow).post(baseURI);


	System.out.println("requestPayload------>" + rq.remittanceTransactionPayloadForCashoutFlow);

	String responseText = response.asString();

	t.info("response cashout flow test"+responseText);

	t.info("successfully proccess the cashout flow for the user...");

	return response;


}

public static Response monthlyLimitCashOut(ExtentTest t) throws Exception {

	Response response = null;

	getExchangeRate(t);



		requestIdForNormalTxn = getRequestIdForTxn();

	effectiveRateForFirstTxn = fetchHoldRateDataWithHoldId();

		String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		RequestPayload rq = new RequestPayload();

		response = given().headers(requestHeaders).body(rq.remittanceTransactionPayloadForCashoutFlow).post(baseURI);

		System.out.println("requestPayload------>" + rq.remittanceTransactionPayloadForCashoutFlow);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response on initiateTransaction service first time under the monthly limit :" + responseText);

	response = given().headers(requestHeaders).body(rq.remittanceTransactionPayloadForCashoutFlowMonthly).post(baseURI);

	Log4jClass.fn_logger_info("Response on initiating the transaction beyond the monthly limit :" + responseText);

t.info("Response on initiating the transaction beyond the monthly limit :" + responseText);
	return response;

}

public static Response monthlyLimitCashIn(ExtentTest t)
{
	Response response =null;
	try {
		String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/create-ach";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");

		requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

		requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

		RequestPayload request = new RequestPayload();

		response = given().headers(requestHeaders).body(request.createACHServiceForCashInMonthly).post(baseURI);

		System.out.println("payload of ach service --> " + request.createACHServiceForCashInMonthly);

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response of ACH service for cashin flow :" + responseText);


		t.info("Response of ACH service for cashin flow :" + responseText);
	}
	catch(Exception e)
	{
		t.fail("test failed");
	}
	return response;


}


	public static void dataPopulationUtility(ExtentTest t)throws Exception,NullPointerException

	{
		    for(int i = 0 ; i < 1; i++) {

				//Thread.sleep(60000);

			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/bank-utility/populate-ach-node-bank-data?size=10";

			System.out.println("baseURI -->" + baseURI);

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			requestHeaders.put("Content-Type", "application/json");

			Response response = given().headers(requestHeaders).get(baseURI);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response of dataPopulationUtility service :" + responseText);
			 t.info("response -->"+responseText);

		}


	}

	public static Response txnApprovaljonRunFirstThenAchJob(ExtentTest t)
	{
		Response response=null;

		try {
			getExchangeRate(t);


			requestIdForNormalTxn = getRequestIdForTxn();


			effectiveRateForFirstTxn = fetchHoldRateDataWithHoldId();

			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");

			requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

			requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

			RequestPayload rq = new RequestPayload();

			response = given().headers(requestHeaders).body(rq.remittanceTransactionInOwnAccount).post(baseURI);


			System.out.println("requestPayload------>" + rq.remittanceTransactionInOwnAccount);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);

			t.info("Response of initiateTransaction service :" + responseText);

			DBUtils.txnApprovalJobFirstRun(t);

		}	catch(Exception e)
		{
			t.fail("test failed");
		}

		return response;

	}


	public static Response achJobRunFirstThenTxnApprovalJob (ExtentTest t)
	{
		Response response=null;

		try {
			getExchangeRate(t);


			requestIdForNormalTxn = getRequestIdForTxn();

			effectiveRateForFirstTxn = fetchHoldRateDataWithHoldId();


			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");

			requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

			requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

			RequestPayload rq = new RequestPayload();

			response = given().headers(requestHeaders).body(rq.remittanceTransactionInOwnAccount).post(baseURI);

			System.out.println("requestPayload------>" + rq.remittanceTransactionInOwnAccount);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);

			t.info("Response of initiateTransaction service :" + responseText);

			DBUtils.achTransactionJobFirst(t);

		}	catch(Exception e)
		{
			t.fail("test failed");
		}

		return response;

	}

	// this method is to initaite the txn with logged in user

	public static Response initiateTxnWithLoggedInUser(ExtentTest t)
	{
		Response response=null;
		try {
			exchangeRateforLoggedInUser();

			getFundingSourceDataForLogin(t);

			getRequestIdForLoginUser();

			createPendingTransactionForLoggedInUserACH(t);

			Thread.sleep(7000);

			fetchHoldRateDataWithHoldIdForLoggedInUser(t);

			String baseURI = ""+SignupAndKycFlow.host+""+SignupAndKycFlow.bankPath+"/remittance/initiate-transaction/v2";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			RequestPayload re = new RequestPayload();

			requestHeaders.put("Content-Type", "application/json");


			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForLoginUser);

			requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  re.customerIdForLoginUser);



			response = given().headers(requestHeaders).body("{}").post(baseURI);


			//System.out.println("requestPayload------>" + re.createUpdateTransactionPayloadForLoggedInUser);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);
			t.info("Response of initiateTransaction service :" + responseText);

			Log4jClass.fn_logger_info("successfully initiated the txn for initiate logged in user.....");

			t.info("successfully initiated the txn for initiate logged in user.....");
			return response;

		}	catch(Exception e)
		{
			t.fail("test failed");
		}

		return null;
	}

	public static Response loginUserTxn(ExtentTest t)
	{
		SignupAndKycFlow.loginOnTcForGettingMessageId();
		SignupAndKycFlow.loginOnTcForOtpVerification();
		SignupAndKycFlow.linkTokenGeneartionForLogin();
		SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
		SignupAndKycFlow.verifyOTPForLoginUser();
		return initiateTxnWithLoggedInUser(t);
	}

	public static Response cmaTxnForLoginUser(ExtentTest t)
	{
		SignupAndKycFlow.loginOnTcForGettingMessageId();
		SignupAndKycFlow.loginOnTcForOtpVerification();
		SignupAndKycFlow.linkTokenGeneartionForLogin();
		SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
		SignupAndKycFlow.verifyOTPForLoginUser();
		return cmaTxnForLoggedInUser(t);
	}

//	public static Response loginUserTxnWithPojo(ExtentTest t)
//	{
//		SignupAndKycFlow.loginOnTcForGettingMessageId();
//		SignupAndKycFlow.loginOnTcForOtpVerification();
//		SignupAndKycFlow.linkTokenGeneartionForLogin();
//		SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
//		SignupAndKycFlow.verifyOTPForLoginUser();
////		CreateInitiateTransactionPojo initiate = InitiateTransaction.getInitiateTransaction();
////		Response response = RestUtils.performPost(APIEndPoints.initaiteTransaction,initiate, Transactions.getInitiateTransactionHeaders());
//
//		return response;
//
//	}

//	public static Response validateUpiPojo(ExtentTest t)
//	{
//		SignupAndKycFlow.loginOnTcForGettingMessageId();
//		SignupAndKycFlow.loginOnTcForOtpVerification();
//		SignupAndKycFlow.linkTokenGeneartionForLogin();
//		SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
//		SignupAndKycFlow.verifyOTPForLoginUser();
//
//		ValidateUPIPojo validateUpi = ValidateUPIService.validateUpiService();
//		Response response = RestUtils.performPost(APIEndPoints.validateUpi,validateUpi, Transactions.getValidateUPIHeaders());
//
//		return response;
//
//	}

	public static Response createPendingTransaction(ExtentTest t)
	{

		Response response=null;
		try {

			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/create-update-pending-transaction";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("device-id", SignupAndKycFlow.deviceId);

			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtToken);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");

			requestHeaders.put("link-token", SignupAndKycFlow.linkToken);

			requestHeaders.put("customer-id", SignupAndKycFlow.customerId);

			RequestPayload rq = new RequestPayload();

//			response = given().headers(requestHeaders).body(rq.createUpdateTransactionPayload).post(baseURI);
//
//			System.out.println("request payload -->"+rq.createUpdateTransactionPayload);

			String responseText = response.asString();

			System.out.println("response of create update transaction --> "+responseText);

			t.info("response of create update transaction --> "+responseText);

		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return response;
	}

	// This method is to initiate the V2 transaction for the logged in user
	public static Response initiateTransactionV2(ExtentTest t)
	{
		Response response=null;
		try {

			SignupAndKycFlow.loginOnTcForGettingMessageId();
			SignupAndKycFlow.loginOnTcForOtpVerification();
			SignupAndKycFlow.linkTokenGeneartionForLogin();
			SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
			SignupAndKycFlow.verifyOTPForLoginUser();


			exchangeRateforLoggedInUser();

			getFundingSourceDataForLogin(t);

			Thread.sleep(5000);

			fetchHoldRateDataWithHoldIdForLoggedInUser(t);

			Thread.sleep(2000);

			getRequestIdForLoginUser();

			createPendingTransactionForLoggedInUserACH(t);

			//Thread.sleep(7000);

			String baseURI = ""+SignupAndKycFlow.host+""+SignupAndKycFlow.bankPath+"/remittance/initiate-transaction/v2";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			RequestPayload re = new RequestPayload();

			requestHeaders.put("Content-Type", "application/json");


			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForLoginUser);

			requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  re.customerIdForLoginUser);



			response = given().headers(requestHeaders).body("{}").post(baseURI);


			//System.out.println("requestPayload------>" + re.createUpdateTransactionPayloadForLoggedInUser);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);
			t.info("Response of initiateTransaction service :" + responseText);

			Log4jClass.fn_logger_info("successfully performed the ach txn by calling initiate V2 transaction for logged in user.........");

			t.info("successfully performed the ach txn by calling initiate V2 transaction for logged in user.........");
			return response;

		}	catch(Exception e)
		{
			t.fail("test failed");
		}

		return null;
	}



// performing copay transaction of logged in user

	public static Response copayTransactionV2(ExtentTest t)
	{
		String data=null;
		Response response=null;
		try {


//			getExchangeRate(t);
//
//			getFundingSourceForGettingCMAAccount();
//			getRequestIdForTxn();
//
//			createPendingTransactionForCopay(t);
//
//			Thread.sleep(7000);
//
//			fetchHoldRateDataWithHoldId();

			SignupAndKycFlow.loginOnTcForGettingMessageId();
			SignupAndKycFlow.loginOnTcForOtpVerification();
			String jwt = SignupAndKycFlow.getLinkTokenV2();
//			SignupAndKycFlow.loginOnNeoBankForNormalTransaction(jwt);
//			SignupAndKycFlow.verifyOTPForLoginUser(jwt);
			exchangeRateforLoggedInUser(jwt);

			getFundingSourceForAboundWalletTransaction(jwt);

			Thread.sleep(5000);

			fetchHoldRateDataWithHoldIdForLoggedInUser(t,jwt);

			Thread.sleep(2000);

			getRequestIdForLoginUser(jwt);

			createPendingTransactionForCopay(t,jwt);

			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/initiate-transaction/v2";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();
			RequestPayload re = new RequestPayload();
			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("Authorization", "Bearer " + jwt);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForLoginUser);

		//	requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  re.customerIdForLoginUser);

		//	requestHeaders.put("sec-ch-ua",  "Android WebView\";v=\"129\", \"Not=A?Brand\";v=\"8\", \"Chromium\";v=\"129");


			requestHeaders.put("sec-ch-ua-mobile",  "?1");

			requestHeaders.put("sec-ch-ua-platform",  "Android");




			response = given().headers(requestHeaders).body("{}").post(baseURI);

			String responseText = response.asString();
			System.out.println("response of the initiate V2 --->"+responseText);

			Log4jClass.fn_logger_info("successfully initaited the copay txn .............");

			t.info("successfully initaited the copay txn .............");

		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return response;
	}

	public static Response createPendingTransactionForCopay(ExtentTest t)
	{

		Response response=null;
		try {

			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/create-update-pending-transaction";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();
			RequestPayload re = new RequestPayload();
			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForLoginUser);

			requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  re.customerIdForLoginUser);



			response = given().headers(requestHeaders).body(re.createUpdateTransactionForAboundWallet).post(baseURI);

			System.out.println("request payload -->"+re.createUpdateTransactionForAboundWallet);

			String responseText = response.asString();

			System.out.println("response of create update transaction --> "+responseText);

			t.info("response of create update transaction --> "+responseText);

		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return response;
	}

	public static Response createPendingTransactionForCopay(ExtentTest t,String jwt)
	{

		Response response=null;
		try {

			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/create-update-pending-transaction";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();
			RequestPayload re = new RequestPayload();
			requestHeaders.put("Content-Type", "application/json");

			//requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForLoginUser);

			//requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  re.customerIdForLoginUser);

			requestHeaders.put("Authorization", "Bearer " + jwt);


			response = given().headers(requestHeaders).body(re.createUpdateTransactionForAboundWallet).post(baseURI);

			System.out.println("request payload -->"+re.createUpdateTransactionForAboundWallet);

			String responseText = response.asString();

			System.out.println("response of create update transaction --> "+responseText);

			t.info("response of create update transaction --> "+responseText);

		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return response;
	}

	public static Response createPendingTransactionForLoggedInUser(ExtentTest t)
	{

		Response response=null;
		try {

			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/create-update-pending-transaction";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();
			RequestPayload rq = new RequestPayload();
			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", rq.deviceIdForLoginUser);

			requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  rq.customerIdForLoginUser);


			response = given().headers(requestHeaders).body(rq.createUploadCMATxn).post(baseURI);

			System.out.println("request payload -->"+rq.createUploadCMATxn);

			String responseText = response.asString();

			System.out.println("response of create update transaction --> "+responseText);

			t.info("response of create update transaction --> "+responseText);

		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return response;
	}


	// This method is used for creating pedning txn ofr logged in user for Remittance ACH transaction

	public static Response createPendingTransactionForLoggedInUserACH(ExtentTest t)
	{

		Response response=null;
		try {

			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/create-update-pending-transaction";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();
			RequestPayload rq = new RequestPayload();
			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", rq.deviceIdForLoginUser);

			requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  rq.customerIdForLoginUser);


			response = given().headers(requestHeaders).body(rq.createUpdateTransactionPayloadForLoggedInUser).post(baseURI);

			System.out.println("request payload -->"+rq.createUpdateTransactionPayloadForLoggedInUser);

			String responseText = response.asString();

			System.out.println("response of create update transaction --> "+responseText);

			t.info("response of create update transaction --> "+responseText);

		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return response;
	}


// This method is used getting CMA funding source for the CMA txn of the user
	public static void getFundingSourceForCMATxn()throws Exception,NullPointerException

	{

		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/get-funding-source-data?user_account_funding_source_applicable=true";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		RequestPayload re=new RequestPayload();
		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "BANKING");

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForLoginUser);

		requestHeaders.put("link-token", linkTokenForCMATxn);

		requestHeaders.put("customer-id",  re.customerIdForLoginUser);


		Response response = given().headers(requestHeaders).get(baseURI);

		String responseText = response.asString();

		System.out.println("payload of bank source--> "+responseText);
		accountIdForCMATxnLoggedInUser = JsonPath.read(responseText,"$.bank_accounts[0].account_id");
		accountIdForBankAccount=JsonPath.read(responseText,"$.bank_accounts[1].account_id");
		itemIdForBankAccount= JsonPath.read(responseText,"$.bank_accounts[1].item_id");
		aboundBalance=JsonPath.read(responseText,"$.bank_accounts[0].account_balance");
		System.out.println("CMA account id of the user -->"+accountIdForCMATxnLoggedInUser);
		System.out.println("response of funding source ---> "+responseText);


		Log4jClass.fn_logger_info("Response of getFundingSourceData service :" + responseText);

	}




	public static void getFundingSourceForAboundWalletTransaction(String jwt)throws Exception,NullPointerException

	{

		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/get-funding-source-data?user_account_funding_source_applicable=true";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		RequestPayload re=new RequestPayload();
		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "BANKING");

	//	requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForLoginUser);

	//	requestHeaders.put("link-token", linkTokenForCMATxn);

		requestHeaders.put("customer-id",  re.customerIdForLoginUser);
		requestHeaders.put("Authorization", "Bearer " + jwt);


		Response response = given().headers(requestHeaders).get(baseURI);

		String responseText = response.asString();

		System.out.println("payload of bank source--> "+responseText);
		accountIdForBankAccount=JsonPath.read(responseText,"$.bank_accounts[1].account_id");
		itemIdForBankAccount= JsonPath.read(responseText,"$.bank_accounts[1].item_id");
		System.out.println("CMA account id of the user -->"+accountIdForCMATxnLoggedInUser);
		System.out.println("response of funding source ---> "+responseText);


		Log4jClass.fn_logger_info("Response of getFundingSourceData service :" + responseText);

	}


	// performing CMA transaction for the logged-in user
	public static Response cmaTxnForLoggedInUser(ExtentTest t)
	{
		Response response=null;
		try
		{

			exchangeRateforLoggedInUser();

			getFundingSourceForCMATxn();

			getRequestIdForLoginUser();

			createPendingTransactionForLoggedInUser(t);

			Thread.sleep(7000);

			fetchHoldRateDataWithHoldIdForLoggedInUser(t);

			String baseURI = ""+SignupAndKycFlow.host+""+SignupAndKycFlow.bankPath+"/remittance/initiate-transaction/v2";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			RequestPayload re = new RequestPayload();

			requestHeaders.put("Content-Type", "application/json");


			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForLoginUser);

			requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  re.customerIdForLoginUser);



			response = given().headers(requestHeaders).body("{}").post(baseURI);


			//System.out.println("requestPayload------>" + re.createUpdateTransactionPayloadForLoggedInUser);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response of initiateTransaction service :" + responseText);
			t.info("Response of initiateTransaction service :" + responseText);

			Log4jClass.fn_logger_info("successfully performed CMA transaction for the logged-in user ");

			t.info("successfully performed CMA transaction for the logged-in user ");

			return response;

		}	catch(Exception e)
		{
			t.fail("test failed");
		}

		return null;
	}



	public static Response validateUPIID(ExtentTest t)
	{
		String data=null;
		Response response=null;
		try {


			SignupAndKycFlow.loginOnTcForGettingMessageId();
			SignupAndKycFlow.loginOnTcForOtpVerification();
			SignupAndKycFlow.linkTokenGeneartionForLogin();
			SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
			SignupAndKycFlow.verifyOTPForLoginUser();

			Thread.sleep(7000);

			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/validate-upi-id";


			HashMap<String, String> requestHeaders = new HashMap<String, String>();
			RequestPayload re = new RequestPayload();
			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForLoginUser);

			requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  re.customerIdForLoginUser);


			response = given().headers(requestHeaders).body(re.validateUPIPayload).post(baseURI);

			String responseText = response.asString();
			System.out.println("response of the validateUPIID --->"+responseText);

			t.info("successfully get the response of validate upi ............."+responseText);


		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return response;
	}


	public static Response validateUPIIDNegativeTest(ExtentTest t)
	{
		String data=null;
		Response response=null;

		try {

			SignupAndKycFlow.loginOnTcForGettingMessageId();
			SignupAndKycFlow.loginOnTcForOtpVerification();
			SignupAndKycFlow.linkTokenGeneartionForLogin();
			SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
			SignupAndKycFlow.verifyOTPForLoginUser();

			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/validate-upi-id";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();
			RequestPayload re = new RequestPayload();
			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForLoginUser);

			requestHeaders.put("link-token", linkTokenForCMATxn);

			requestHeaders.put("customer-id",  re.customerIdForLoginUser);

			response = given().headers(requestHeaders).body(re.validateUPINegativeTestPayload).post(baseURI);

			String responseText = response.asString();
			System.out.println("response of the validateUPIID test--->"+responseText);

			String message = JsonPath.read(responseText,"$.message");

			ValidatableResponse vr = response.then();

			vr.time(Matchers.lessThan(58000l));

			Assert.assertTrue(message.contains("Invalid VPA or no matching account"));

			t.info("successfully get the response of validate upi negative test  ............."+responseText);

		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return response;
	}

	public static String getUPIID()
	{
		return "99105062996@paytm";
	}


	public static void transactionHistoryForNewUser(ExtentTest t)
	{

		SignupAndKycFlow.loginOnTcForGettingMessageId();
		SignupAndKycFlow.loginOnTcForOtpVerification();
		SignupAndKycFlow.linkTokenGeneartionForLogin();
		SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
		SignupAndKycFlow.verifyOTPForLoginUser();


		Response response = null;

		String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/transactions?page_no=1&page_size=5";


		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		RequestPayload re = new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForLoginUser);

		requestHeaders.put("link-token", linkTokenForCMATxn);

		requestHeaders.put("customer-id",  re.customerIdForLoginUser);

		response = given().headers(requestHeaders).get(baseURI);


		String responseText = response.asString();

		System.out.println("response of transaction history API --> "+responseText);

		t.info("response of transaction history API --> "+responseText);

		transactionRefIdForCancellation = JsonPath.read(responseText,"$.transactions[0].transaction_ref_id");

		Assert.assertTrue(!transactionRefIdForCancellation.isEmpty() && transactionRefIdForCancellation != null);


	}

	public static Response cancellationFlowForLayer2Transaction(ExtentTest t)
	{
		transactionHistoryForNewUser(t);

		SignupAndKycFlow.loginOnTcForGettingMessageId();
		SignupAndKycFlow.loginOnTcForOtpVerification();
		SignupAndKycFlow.linkTokenGeneartionForLogin();
		SignupAndKycFlow.loginOnNeoBankForNormalTransaction();
		SignupAndKycFlow.verifyOTPForLoginUser();



		Response response = null;

		String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/transaction/"+transactionRefIdForCancellation+"";


		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		RequestPayload re = new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");

		requestHeaders.put("Authorization", "Bearer " + SignupAndKycFlow.jwtForLoginUser);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForLoginUser);

		requestHeaders.put("link-token", linkTokenForCMATxn);

		requestHeaders.put("customer-id",  re.customerIdForLoginUser);


		response = given().headers(requestHeaders).delete(baseURI);

		String responseText = response.asString();

		System.out.println("response of cancellationFlowForLayer2Transaction API --> "+responseText);

		t.info("response of cancellationFlowForLayer2Transaction API --> "+responseText);

		String message = JsonPath.read(responseText,"$.message");

		Assert.assertTrue(!message.isEmpty() && message != null);

		return response;

	}


	public static Response initiateTransactionV2ForEliteUser(ExtentTest t)
	{
		Response response=null;
		try {

			SignupAndKycFlow.loginOnTcForEliteUser();
			SignupAndKycFlow.loginOnTcOtpVerificationForElite();
			String jwt = SignupAndKycFlow.linkTokenGeneartionForELiteUser();
//			SignupAndKycFlow.loginOnNeoBankForPrefundingTransaction();
//			SignupAndKycFlow.verifyOTPForEliteUser();


			exchangeRateforEliteUser(jwt);

			getFundingSourceDataForElite(t,jwt);

			Thread.sleep(5000);

			fetchHoldRateDataWithHoldIdForEliteUser(t,jwt);

			Thread.sleep(2000);

			getRequestIdForEliteUser(jwt);

			createPendingTransactionForEliteUser(t,jwt);

			//Thread.sleep(7000);

			String baseURI = ""+SignupAndKycFlow.host+""+SignupAndKycFlow.bankPath+"/remittance/initiate-transaction/v2";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			RequestPayload re = new RequestPayload();

			requestHeaders.put("Content-Type", "application/json");


			requestHeaders.put("Authorization", "Bearer " + jwt);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForEliteUser);

			requestHeaders.put("customer-id",  re.customerIdForEliteUser);



			response = given().headers(requestHeaders).body("{}").post(baseURI);


			//System.out.println("requestPayload------>" + re.createUpdateTransactionPayloadForLoggedInUser);

			String responseText = response.asString();

			Log4jClass.fn_logger_info("Response of initiateTransaction service for elite user :" + responseText);
			t.info("Response of initiateTransaction service :" + responseText);

			Log4jClass.fn_logger_info("successfully performed the ach txn by calling initiate V2 transaction for elite user.........");

			t.info("successfully performed the ach txn by calling initiate V2 transaction for elite user.........");
			return response;

		}	catch(Exception e)
		{
			t.fail("test failed");
		}

		return null;
	}


	public static void exchangeRateforEliteUser(String jwt)throws Exception,NullPointerException
	{
		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/fetch-hold-exchange-rates";


		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		RequestPayload re = new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");


		requestHeaders.put("Authorization", "Bearer " + jwt);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForEliteUser);

		requestHeaders.put("customer-id",  re.customerIdForEliteUser);


		Response response = given().headers(requestHeaders).get(baseURI);

		String responseText = response.asString();

		System.out.println("payload for exchange rate"+responseText);
		holdIdForloggedInUser=response.jsonPath().getString("fx_hold_id");
		System.out.println("hold id for logged in user-->"+holdIdForloggedInUser);
		double exchangeRate = JsonPath.read(responseText,"$.exchange_rates.effective_exchange_rate");
		System.out.println("exchangeRate for logged in user-->"+exchangeRate);
		effectiveExchangeRateForLoginUser = Double.valueOf(exchangeRate);
		currentExchangeRateForLoginUser = JsonPath.read(responseText,"$.exchange_rates.current_exchange_rate");
		System.out.println("currentExchangeRateForLoginUser for logged in user-->"+currentExchangeRateForLoginUser);

		double transactionFee = JsonPath.read(responseText,"$.transaction_fee");
		transactionFeeForloggedInUser = Double.valueOf(transactionFee);
		System.out.println("transaction fee for the transaction ---->"+transactionFeeForloggedInUser);

		int applicable_transaction_feeForLoggedInUser= JsonPath.read(responseText,"$.applicable_transaction_fee");

		System.out.println("transaction fee for the transaction --> "+transactionFeeForloggedInUser);
		System.out.println("Applicable transaction fee for the transaction --> "+applicable_transaction_feeForLoggedInUser);


		Log4jClass.fn_logger_info("Response of getExchangeRate service :" + responseText);

	}


	public static Response getFundingSourceDataForElite(ExtentTest t,String jwt) throws Exception,NullPointerException

	{

		Response response=null;
		try {
			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/get-funding-source-data";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();

			RequestPayload re = new RequestPayload();

			requestHeaders.put("Content-Type", "application/json");


			requestHeaders.put("Authorization", "Bearer " + jwt);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", re.deviceIdForEliteUser);

			requestHeaders.put("customer-id",  re.customerIdForEliteUser);


			response = given().headers(requestHeaders).get(baseURI);

			String responseText = response.asString();
			t.info("response of getFundingSourceData" + responseText);
			System.out.println("respone of getFundingSource "+responseText);

			Map<Object, Object> accountIds = response.jsonPath().getMap("bank_accounts[0]");

			accountidForLoginUser = accountIds.get("account_id").toString();
			String responseText1 = response.asString();

			Map<Object, Object> accountIdForCMA = response.jsonPath().getMap("bank_accounts[0]");
			accountIdforCMAAccount = accountIdForCMA.get("account_id").toString();

			itemIdForLoggedInUser = JsonPath.read(responseText1,"$.bank_accounts[0].item_id");

			Log4jClass.fn_logger_info("accountId --> :" + accountid);

			Log4jClass.fn_logger_info("accountId for CMA --> :" + accountIdforCMAAccount);

			Log4jClass.fn_logger_info("Response of getFundingSourceData service :" + responseText);
			t.info("Response of getFundingSourceData service :" + responseText);
		}
		catch(Exception e)
		{
			t.fail("test failed");
		}


		return response;

	}


	public static double fetchHoldRateDataWithHoldIdForEliteUser(ExtentTest t,String jwt)throws Exception,NullPointerException

	{

		Thread.sleep(1000);
		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/fetch-hold-exchange-rates?fx_hold_id="+holdIdForloggedInUser+"";

		System.out.println("request of fetchHoldService-->"+baseURI);

		HashMap<String, String> requestHeaders = new HashMap<String, String>();
		RequestPayload re= new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");


		requestHeaders.put("Authorization", "Bearer " + jwt);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForEliteUser);

		requestHeaders.put("customer-id",  re.customerIdForEliteUser);

		Response response = given().headers(requestHeaders).get(baseURI);


		instantTransferActiveKey=response.jsonPath().getString("instant_transfer_active");

		Map<Object,Object>exchangeRates=response.jsonPath().getMap("exchange_rates");
		effectiveRateForLoginUser=Double.valueOf(exchangeRates.get("display_effective_exchange_rate").toString());
		*/
/*effective_exchange_rate=exchangeRates.get("effective_exchange_rate").toString();
		effective_exchange_rate=String.format("%.0f", effective_exchange_rate);
		effectiveRate=Integer.parseInt(effective_exchange_rate);*//*

		String responseText = response.asString();

		Log4jClass.fn_logger_info("Response of fetchHoldRateDataWithHoldId service :" + responseText);

		return effectiveRateForLoginUser;

	}


	public static String getRequestIdForEliteUser(String jwt)throws Exception,NullPointerException

	{

		String baseURI = "" + SignupAndKycFlow.host + ""+SignupAndKycFlow.bankPath+"/remittance/get-request-id";

		HashMap<String, String> requestHeaders = new HashMap<String, String>();

		RequestPayload re = new RequestPayload();

		requestHeaders.put("Content-Type", "application/json");


		requestHeaders.put("Authorization", "Bearer " + jwt);

		requestHeaders.put("user_type", "PRIMARY");

		requestHeaders.put("Source", "REMITTANCE");
		requestHeaders.put("device-id", re.deviceIdForEliteUser);

		//requestHeaders.put("link-token", linkTokenForEliteUser);

		requestHeaders.put("customer-id",  re.customerIdForEliteUser);

		Response response = given().headers(requestHeaders).get(baseURI);
		requestHeaders.put("Source", "REMITTANCE");
		String responseText = response.asString();

		requestIdForLoginUser=response.jsonPath().getString("request_id").toString();

		Log4jClass.fn_logger_info("Response of getRequestId service :" + responseText);

		return requestIdForLoginUser;

	}



	public static Response createPendingTransactionForEliteUser(ExtentTest t,String jwt)
	{

		Response response=null;
		try {

			String baseURI = "" + SignupAndKycFlow.host + "" + SignupAndKycFlow.bankPath + "/remittance/create-update-pending-transaction";

			HashMap<String, String> requestHeaders = new HashMap<String, String>();
			RequestPayload rq = new RequestPayload();
			requestHeaders.put("Content-Type", "application/json");

			requestHeaders.put("Authorization", "Bearer " + jwt);

			requestHeaders.put("user_type", "PRIMARY");

			requestHeaders.put("Source", "REMITTANCE");
			requestHeaders.put("device-id", rq.deviceIdForEliteUser);

			requestHeaders.put("customer-id",  rq.customerIdForEliteUser);


			response = given().headers(requestHeaders).body(rq.createUpdateTransactionPayloadForEliteInUser).post(baseURI);

			System.out.println("request payload -->"+rq.createUpdateTransactionPayloadForEliteInUser);

			String responseText = response.asString();

			System.out.println("response of create update transaction --> "+responseText);

			t.info("response of create update transaction --> "+responseText);

		}
		catch(Exception e)
		{
			t.fail("test failed");
		}
		return response;
	}
}



*/
