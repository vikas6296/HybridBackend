/*
package abound.neobank.TestCases;

import abound.neobank.services.SignupAndKycFlow;
import abound.neobank.utilities.DBUtils;
import abound.neobank.utilities.SparkHTML;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.configuration.Theme;

import org.apache.commons.configuration.CompositeConfiguration;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.SystemConfiguration;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import abound.neobank.services.Remittance;
import abound.neobank.utilities.Log4jClass;
import io.restassured.response.Response;

import java.sql.SQLException;

public class RemittanceFlowTest

{
	//ThreadLocal<ExtentTest> threadLocal = new ThreadLocal<ExtentTest>();
	@BeforeTest(groups = { "sanity" ,"Elite","smoke","LoginUser","Webhook","eliteTxn"})
	public void sparkSetup()
	{
		SparkHTML.spark.config().setTheme(Theme.DARK);
		SparkHTML.spark.config().setDocumentTitle("Neobank Automation report");
		SparkHTML.extent.attachReporter(SparkHTML.spark);

	}
	@BeforeSuite(groups = { "sanity" ,"Elite","smoke","utility","LoginUser","CMATxnWithLoggedInUser","addcash","Webhook","eliteTxn"})
	public void propertyCheck() throws Throwable, ConfigurationException {

		System.out.println("configuration stated ....................................");
		CompositeConfiguration config = new CompositeConfiguration();
		config.addConfiguration(new SystemConfiguration());
		config.addConfiguration(new PropertiesConfiguration("Host.properties"));



		SignupAndKycFlow.host = config.getString("neobankEnvironment");

		SignupAndKycFlow.timesclubHost = config.getString("timesClubEnvironment");

		SignupAndKycFlow.usersPath=config.getString("users");
		SignupAndKycFlow.bankPath=config.getString("bank");



	}

    @AfterTest(groups = { "sanity" ,"eliteTxn","smoke","LoginUser"})
	public void tearDown()
	{
		SparkHTML.extent.flush();

}

	@Test(priority=43,groups = { "sanity","failure" })

	public void getFxHoldRateData() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("fetching the fx hold rate for initiate transaction").assignCategory("functionalUseCase");
		test.info("fetching the fx hold rate for initiate transaction");

		Response response=Remittance.getExchangeRate(test);

		Log4jClass.fn_logger_info("Status code of the getFxHoldRateData is : "+response.statusCode());


		 if(response.statusCode()==200) {

			 test.info("response---->"+response.asPrettyString());
			 Assert.assertTrue(true);


		 }
		 else {
			 test.fail("failed");
			 Assert.assertTrue(false);

		 }

	}
	
	@Test(priority=44,groups = { "sanity" ,"failure"})
	public void addBeneficiaryTest() throws Exception
	{		ExtentTest test=SparkHTML.extent.createTest(" Validation of addBeneficiaryTest").assignCategory("functionalUseCase");

		Response response=Remittance.addBeneficiary(test);
		
		Log4jClass.fn_logger_info("Status code of the addBeneficiaryTest is : "+response.statusCode());

		test.info("Validation of addBeneficiaryTest");
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
	
	
	@Test(priority=44,groups = { "sanity","failure" })
	public void getUserBeneficiaryListTest() throws Exception

	{
		ExtentTest test=SparkHTML.extent.createTest(" Validation of getUserBeneficiaryListTest").assignCategory("functionalUseCase");

		Response response=Remittance.getUserBeneficiaryList(test);
		
		Log4jClass.fn_logger_info("Status code of the getUserBeneficiaryListTest is : "+response.statusCode());

		test.info("Validation of getUserBeneficiaryListTest");
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

	
	@Test(priority=45,groups = { "sanity" ,"failure"})
	public void getPaymentReasonsDataTest() throws Exception

	{

		Response response=Remittance.getPaymentReasonsData();
		
		Log4jClass.fn_logger_info("Status code of the getPaymentReasonsDataTest is : "+response.statusCode());
		ExtentTest test=SparkHTML.extent.createTest(" Validation of getPaymentReasonsDataTest").assignCategory("functionalUseCase");
		test.info("Validation of getPaymentReasonsDataTest");
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
	
	@Test(priority=46,groups = { "sanity","failure" })
	public void getFundingSourceDataTest() throws Exception

	{
		ExtentTest test=SparkHTML.extent.createTest("Validation of getFundingSourceDataTest").assignCategory("functionalUseCase");
		test.info("Validation of getFundingSourceDataTest");
		Response response=Remittance.getFundingSourceData(test);
		
		Log4jClass.fn_logger_info("Status code of the getFundingSourceDataTest is : "+response.statusCode());

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
	
	@Test(priority=48,groups = { "sanity","failure" },enabled = false)
	public void initiateTransactionTest() throws Exception

	{
		ExtentTest test=SparkHTML.extent.createTest(" Validation of NormalinitiateTransactionTest").assignCategory("functionalUseCase");

		Response response=Remittance.normalInitiateTransaction(test);
		
		Log4jClass.fn_logger_info("Status code of the initiateTransactionTest is : "+response.statusCode());

		test.info("Validation of initiateTransactionTest");
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

	
	@Test(priority=47,groups = { "sanity","failure" })
	public void getRequestIdTest() throws Exception

	{
		Response response=Remittance.getRequestId();
		
		Log4jClass.fn_logger_info("Status code of the getRequestId Test is : "+response.statusCode());
		ExtentTest test=SparkHTML.extent.createTest("Validation of getRequestIdTest").assignCategory("functionalUseCase");
		test.info("Validation of getRequestIdTest");
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

	@Test(priority=45,enabled=false,groups = { "sanity","failure" })
	public void hGetFetchHoldRateDataForTxn() throws Exception


	{

		double effectiveRate=Remittance.fetchHoldRateDataWithHoldId();

		Log4jClass.fn_logger_info("effective rate before transaction: "+effectiveRate);

		ExtentTest test=SparkHTML.extent.createTest(" hGetFetchHoldRateDataForTxn").assignCategory("functionalUseCase");
		test.info("Validation of hGetFetchHoldRateDataForTxn");
		test.info("effective rate before txn  --> "+effectiveRate);
		if(effectiveRate==0)

		{

			test.fail("failed");
			Assert.assertTrue(false);

		}
		else {
			test.info("effective rate---->"+effectiveRate);
			Assert.assertTrue(true);

		}

	}




	@Test(priority=45,enabled=false,groups = { "sanity","failure" })
	public void checkEligibilityForInstantACH() throws Exception

	{
		Response response=Remittance.checkEligibilityScore();

		Log4jClass.fn_logger_info("Status code of the checkEligibility Test is : "+response.statusCode());

		ExtentTest test=SparkHTML.extent.createTest(" checkEligibilityForInstantACH").assignCategory("functionalUseCase");
		test.info("Validation of checkEligibilityForInstantACH");
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


	@Test(priority=49,enabled = false)
	public void getExchangeRates() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("getExchangeRates").assignCategory("functionalUseCase");
		test.info("Validation of getExchangeRates");

		Response response=Remittance.compareRemit();

		Log4jClass.fn_logger_info("Status code of the getExchangeRates Test is : "+response.statusCode());

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

	@Test(priority=56,enabled = false,groups = { "failure" })
	public void unableToBookFx() throws InterruptedException, SQLException {

		ExtentTest testUnableToBookFx=SparkHTML.extent.createTest(" unableToBookFx").assignCategory("functionalUseCase");

		String data=Remittance.unableToBookFx(testUnableToBookFx);


		testUnableToBookFx.info("Validation of unable to book fx exception on mocking the initiatl fx rate in remittance transaction step status table");


		if(data!=null)
		{
			testUnableToBookFx.info("status fetched from database --> "+data);
			Assert.assertTrue(true);

		}

		else {
			testUnableToBookFx.fail("failed");
			Assert.assertTrue(false);

		}

	}



	@Test(priority=56,enabled = false,groups = { "failure" })
	public void failDueToIncorrectValueTest() throws Exception {


		ExtentTest test=SparkHTML.extent.createTest(" failDueToIncorrectValue").assignCategory("functionalUseCase");

		String data=Remittance.failDueToIncorrectValue(test);


		if(data!=null)
		{
			test.info("status fetched from database --> "+data);
			Assert.assertTrue(true);

		}

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}
	}


	@Test(priority=57,enabled = false,groups = { "failure" })
	public void bankRelinkTest() throws Exception {
		Response response=Remittance.bankRelink();

		Log4jClass.fn_logger_info("Status code of the bankRelink Test is : "+response.statusCode());

		ExtentTest test=SparkHTML.extent.createTest(" bankRelink").assignCategory("functionalUseCase");
		test.info("Validation of bankRelink functionality and then initiate the transaction");
		test.info("status code --> "+response.statusCode());

		if(response.statusCode()==400||response.statusCode()==401||response.statusCode()==404||response.statusCode()==500||response.statusCode()==409) {
			test.fail("failed");
			Assert.assertTrue(false);
		}



	}

	@Test(priority=58,groups = { "sanity" },enabled = false)
	public void initiateTransactionTestForInstantACH() throws Exception

	{

		Response response=Remittance.initiateTransactionForInstantACH();

		Log4jClass.fn_logger_info("Status code of the initiateTransactionTest for instant ACHis : "+response);

		ExtentTest test=SparkHTML.extent.createTest(" initiateTransactionTestForInstantACH").assignCategory("functionalUseCase");
		test.info("Validation of initiateTransactionTest");
		test.info("status code --> "+response);

		if(response.statusCode()==200)
		{

			Assert.assertTrue(true);

		}

		else
		{
			test.fail("failed");
			Assert.assertTrue(false);
		}



	}




	@Test(priority=56,enabled = true,groups = { "failure" })
	public void failDuetoLimitExceeded() throws Exception {
		ExtentTest test=SparkHTML.extent.createTest(" Validation of failDueToLostLimitExceededTest").assignCategory("functionalUseCase");
		String data=Remittance.failDueToLossLimitExceeded(test);


		test.info("Validation of failDuetoLimitExceeded exception on mocking the destination amount in DB");

		if(data!=null)
		{
			test.info("status fetched from database --> "+data);
			Assert.assertTrue(true);

		}

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}


	}


	@Test(priority=50,enabled = false,groups = { "sanity" })
	public void instantACHWithoutTransferFeeAndApplicableFee() throws Exception {
		Response instantTransferFee = Remittance.instantACHWithoutTransferFee();

		Log4jClass.fn_logger_info("Status code of the instantACHWithoutTransferFeeAndApplicableFee Test is : " + instantTransferFee);
		ExtentTest test = SparkHTML.extent.createTest(" instantACHWithoutTransferFeeAndApplicableFee").assignCategory("functionalUseCase");
		test.info("status code --> " + instantTransferFee);

		if (instantTransferFee.statusCode()==200) {
			Assert.assertTrue(true);
		}
		else
		{
			test.fail("failed");
			Assert.assertTrue(false);
		}

	}




	@Test(priority=53,enabled = true,groups = { "sanity" })
	public void transactionHistoryCheckingTest() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("Validation of transactionHistoryCheckingTest").assignCategory("functionalUseCase");
		test.info("Validation of transactionHistoryCheckingTest");

		Response response=Remittance.transactionHistoryChecking(test);

		Log4jClass.fn_logger_info("Status code of the transactionHistoryCheckingTest Test is : "+response.statusCode());

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

	@Test(priority=52,enabled = true,groups = { "sanity" })
	public void transactionForAbountAccountTest() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("Validation of transactionForAbountAccountTest").assignCategory("functionalUseCase");
		test.info("Validation of transactionForAbountAccountTest");

		Response response=Remittance.transactionCheckingInAbountAccount(test);

		Log4jClass.fn_logger_info("Status code of the transactionForAbountAccountTest Test is : "+response.statusCode());

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

	@Test(priority=54,enabled = false,groups = { "sanity" })
	public void addBeneficiaryForUPIAndSecondTransactionWithUPITest() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("addBeneficiaryForUPIAndSecondTransactionWithUPITest").assignCategory("functionalUseCase");
		test.info("Validation of getExchangeRates");

		Response response=Remittance.addBeneficiaryForUPIAndSecondTransactionWithUPI(test);

try {
	Log4jClass.fn_logger_info("Status code of the addBeneficiaryForUPIAndSecondTransactionWithUPITest Test is : " + response.statusCode());

	test.info("status code --> " + response.statusCode());
	if (response.statusCode() == 200) {

		test.info("response---->" + response.asPrettyString());
		Assert.assertTrue(true);

	}
}
catch(Exception e) {

	{
		test.fail("failed");
		Assert.assertTrue(false);

	}
}
	}


	@Test(priority=65,enabled = false,groups = { "sanity" })
	public void returnEligibleTxnTest() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("returnEligibleTxnTest").assignCategory("functionalUseCase");
		test.info("Validation of returnEligibleTxnTest");

		Response response=Remittance.retrunEligibleTxns();

		Log4jClass.fn_logger_info("Status code of the returnEligibleTxnTest Test is : "+response.statusCode());

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


	@Test(priority=55,enabled = true,groups="failed")
	public void initiateTxnUptoPGprocessingTest() throws Exception {
		ExtentTest test=SparkHTML.extent.createTest("Validation of initiateTxnUptoPGprocessingTest").assignCategory("functionalUseCase");
		test.info("Validation of initiateTxnUptoPGprocessingTest");
		String data=Remittance.initiateTrxnUptoPGProcessingdStatus(test);


		if(data!=null)
		{
			test.info("status fetched from database --> "+data);
			Assert.assertTrue(true);

		}

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}


	}

	@Test(priority=56,enabled = true)
	public void initiateTxnUptoInitiatedBookFxTest() throws Exception {

		ExtentTest test=SparkHTML.extent.createTest("Validation of initiateTxnUptoInitiatedBookFxTest").assignCategory("functionalUseCase");
		test.info("Validation of initiateTxnUptoInitiatedBookFxTest");
		String data=Remittance.initiateTrxnUptoInitiatedBookFx(test);

		if(data!=null)
		{
			test.info("status fetched from database --> "+data);
			Assert.assertTrue(true);

		}

		else {
			test.fail("failed");
			Assert.assertTrue(false);

		}

	}
	@Test(priority=56,enabled = false)
	public void transactionOnPassingFundingIdoFUserInBeneficary() throws Exception {
		ExtentTest test=SparkHTML.extent.createTest(" transactionOnPassingFundingIdoFUserInBeneficary").assignCategory("functionalUseCase");
		test.info("Validation of transactionOnPassingFundingIdoFUserInBeneficary");
		Response response= Remittance.transactionInOwnAccount(test);

		Log4jClass.fn_logger_info("Status code of the transactionOnPassingFundingIdoFUserInBeneficary Test is : "+response.statusCode());

		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
			Assert.assertTrue(true);

		else
		{
			test.fail("testcase failed user is able to do the transaction on his own account");
			Assert.assertTrue(false);
		}
	}


	@Test(priority=56,enabled = false)
  public void txnWithUpiOnSameBeneficiaryAsSameFundingId() throws Exception {
	  ExtentTest test=SparkHTML.extent.createTest(" txnWithUpiOnSameBeneficiaryAsSameFundingId").assignCategory("functionalUseCase");
	  test.info("Validation of txnWithUpiOnSameBeneficiaryAsSameFundingId");
	  Response response= Remittance.transactionInOwnAccountUsingUPI(test);

	  Log4jClass.fn_logger_info("Status code of the txnWithUpiOnSameBeneficiaryAsSameFundingId Test is : "+response.statusCode());

	  if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
		  Assert.assertTrue(true);

	  else
	  {
		  test.fail("testcase failed user is able to do the transaction on his own account using upi option");
		  Assert.assertTrue(false);
	  }

	}

	@Test(priority=56,enabled = true,groups = { "addcash" })
	public void addCashLimitTest() throws Exception {
		ExtentTest test=SparkHTML.extent.createTest("Validation of addCashLimitTest").assignCategory("functionalUseCase");
		test.info("Validation of addCashLimitTest");
		Response response= Remittance.addCashLimitService(test);

		Log4jClass.fn_logger_info("Status code of the addCashLimit Test is : "+response.statusCode());
		if(response.statusCode()==200)
		{

			Assert.assertTrue(true);

		}

		else
		{
			test.fail("failed");
			Assert.assertTrue(false);
		}
	}

	@Test(priority=56,enabled = true)
	public void cashInLimitFlowTest() throws Exception {
		ExtentTest test=SparkHTML.extent.createTest("Validation of cashInLimitFlowTestforAddCash" +
				"").assignCategory("functionalUseCase");
		test.info("Validation of cashInLimitFlowTest");
		Response response= Remittance.cashInLimitFlow(test);

		Log4jClass.fn_logger_info("Status code of the cashInLimitFlowTest Test is : "+response.statusCode());
		if(response.statusCode()==200)
		{

			Assert.assertTrue(true);

		}

		else
		{
			test.fail("failed");
			Assert.assertTrue(false);
		}
	}

	@Test(priority=65,enabled = false)
	public void cashOutLimitFlowTest() throws Exception {
		ExtentTest test=SparkHTML.extent.createTest(" ACHcashOutLimitFlowTest").assignCategory("functionalUseCase");
		test.info("Validation of cashOutLimitFlowTest");
		Response response= Remittance.cashoutLimitFlow(test);

		Log4jClass.fn_logger_info("Status code of the ACHcashOutLimitFlowTest Test is : "+response.statusCode());
		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
			Assert.assertTrue(true);

		else
		{
			test.fail("testcase failed , cashout limit functionality not working properly");
			Assert.assertTrue(false);
		}
	}


	@Test(priority=65,enabled = false)
	public void cashOutLimitFlowTestMonthly() throws Exception {
		ExtentTest test=SparkHTML.extent.createTest(" cashOutLimitFlowTestMonthly").assignCategory("functionalUseCase");
		test.info("Validation of cashOutLimitFlowTestMonthly");
		Response response= Remittance.monthlyLimitCashOut(test);

		Log4jClass.fn_logger_info("Status code of the cashOutLimitFlowTest Test is : "+response.statusCode());
		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
			Assert.assertTrue(true);

		else
		{
			test.fail("testcase failed , cashout limit functionality not working properly");
			Assert.assertTrue(false);
		}
	}


	@Test(priority=56,enabled = true)
	public void cashInLimitFlowTestMonthly() throws Exception
	{
		ExtentTest test=SparkHTML.extent.createTest("Validation of cashInLimitFlowTestMonthly").assignCategory("functionalUseCase");
		test.info("Validation of cashInLimitFlowTestMonthly");
		Response response= Remittance.monthlyLimitCashIn(test);

		Log4jClass.fn_logger_info("Status code of the cashInLimitFlowTest Test is : "+response.statusCode());
		if(response.statusCode()==401||response.statusCode()==400||response.statusCode()==404||response.statusCode()==500)
			Assert.assertTrue(true);

		else
		{
			test.fail("testcase failed , cashIn limit functionality not working properly");
			Assert.assertTrue(false);
		}
	}

    @Test(priority=70,enabled = false,groups = { "sanity" })
    public void transactionWithCMAFundingSource() throws Exception

    {
        Thread.sleep(10000);

        ExtentTest test=SparkHTML.extent.createTest("transactionWithCMAFundingSource").assignCategory("functionalUseCase");
        test.info("Validation of transactionWithCMAFundingSource");

        Response response= Remittance.transactionWithCMAAccount(test);

        Log4jClass.fn_logger_info("Status code of the transactionWithCMAFundingSource Test is : "+response.statusCode());

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

	@Test(priority=80,enabled = true,groups = { "sanity" })
	public void deletebeneficiaryTest() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("Validation of deletebeneficiaryTest").assignCategory("functionalUseCase");
		test.info("Validation of deletebeneficiaryTest");

		Response response=Remittance.deleteBeneficiary();

		Log4jClass.fn_logger_info("Status code of the deletebeneficiaryTest Test is : "+response.statusCode());

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




	@Test(priority=70,enabled = true,groups = { "LoginUse","sanity","Webhook"})
	public void initaiteTransactionV2Test() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("Validation of initaiteTransactionV2Test").assignCategory("functionalUseCase");
		test.info("Validation of transactionWithCMAFundingSource");

		Response response= Remittance.initiateTransactionV2(test);
		DBUtils.mockTheTransactionToConfirmByProvider();
		DBUtils.initiateFundingWebhook();
		String cashOutStatus = DBUtils.markingTxnToPaid();

		Log4jClass.fn_logger_info("Status code of the initaiteTransactionV2Test Test is : "+response.statusCode());

		test.info("status code --> "+response.statusCode());
		if(cashOutStatus.equals("PAID")) {

			test.info("transaction cashout status is ................>"+cashOutStatus);
			Assert.assertTrue(true);

		}
		else
		{
			test.fail("Exception occured while payout....................");
			Assert.assertTrue(false);

		}

	}

	@Test(priority=71,enabled = true,groups = { "sanity"})
	public void copayTransaction() throws Exception

	{


		ExtentTest test=SparkHTML.extent.createTest("Validation of copayTransaction").assignCategory("functionalUseCase");
		test.info("Validation of copayTransaction");

		Response response= Remittance.copayTransactionV2(test);

		Log4jClass.fn_logger_info("Status code of the copayTransaction Test is : "+response.statusCode());

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

	@Test(priority=78,enabled = true,groups = { "loginUserTxn" })
	public void initiateTxnWithLoginUserUsingPojo() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("Validaton of initiateTxnWithLoggedInUser").assignCategory("functionalUseCase");
		test.info("Validation of initiateTxnWithLoggedInUser");

		Response response = Remittance.loginUserTxnWithPojo(test);

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



	@Test(priority=71,enabled = true,groups = { "sanity" })
	public void getValidateUPITest() throws Exception

	{


		ExtentTest test=SparkHTML.extent.createTest("Validation of getValidateUPITest").assignCategory("functionalUseCase");
		test.info("Validation of getValidateUPITest");

		Response response= Remittance.validateUPIID(test);

		Log4jClass.fn_logger_info("Status code of the getValidateUPITest Test is : "+response.statusCode());

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

	@Test(priority=71,enabled = true,groups = { "sanity" })
	public void getValidateUPIPojoTest() throws Exception

	{


		ExtentTest test=SparkHTML.extent.createTest("Validation of getValidateUPITest").assignCategory("functionalUseCase");
		test.info("Validation of getValidateUPITest");

		Response response= Remittance.validateUpiPojo(test);

		Log4jClass.fn_logger_info("Status code of the getValidateUPITest Test is : "+response.statusCode());

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

	@Test(priority=72,enabled = true,groups = { "sanity" })
	public void getValidateUPITestNegative() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("Validation of getValidateUPITestNegative").assignCategory("functionalUseCase");
		test.info("Validation of getValidateUPITest");

		Response response= Remittance.validateUPIIDNegativeTest(test);

		Log4jClass.fn_logger_info("Status code of the getValidateUPITestNegative Test is : "+response.statusCode());

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



//	@Test(priority=72,enabled = true,groups = { "Webhook" })
//	public void initiateFundingWebhookForNium() throws Exception
//
//	{
//
//		ExtentTest test=SparkHTML.extent.createTest("Initiating funding webhook for NIUM").assignCategory("functionalUseCase");
//		test.info("Initiating funding webhook for NIUM....................");
//
//		String response= DBUtils.mockTheTransactionToConfirmByProvider();
//
//		System.out.println("Response from DB...........->"+response);
//	}

	@Test(priority=71,enabled = true,groups = { "sanity" })
	public void validateCancellationOfTransactionFlow() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("Validation of cancelling of transaction").assignCategory("functionalUseCase");
		test.info("Validation of cancelling of transaction");

		Response response= Remittance.cancellationFlowForLayer2Transaction(test);

		Log4jClass.fn_logger_info("Status code of the validateCancellationOfTransactionFlow Test is : "+response.statusCode());

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



//	@Test(priority=72,enabled = true,groups = { "Webhook" })
//	public void initiateFundingWebhookForNiumOnServer() throws Exception
//
//	{
//
//		ExtentTest test=SparkHTML.extent.createTest("Initiating funding webhook for NIUM").assignCategory("functionalUseCase");
//		test.info("Initiating funding webhook for NIUM....................");
//		DBUtils.initiateFundingWebhook();
//		DBUtils.markingTxnToPaid();
//
//
//	}

	@Test(priority=70,enabled = true,groups = { "sanity","eliteTxn"})
	public void initaiteTransactionV2ForEliteUser() throws Exception

	{

		ExtentTest test=SparkHTML.extent.createTest("Validation of initaiteTransactionV2ForEliteUser").assignCategory("functionalUseCase");
		test.info("Validation of transactionWithCMAFundingSource");

		Response response= Remittance.initiateTransactionV2ForEliteUser(test);
		DBUtils.mockThePrefundingTransaction();
		String cashOutStatus = DBUtils.initiatePrefundingWebhook();

		Log4jClass.fn_logger_info("Status code of the initaiteTransactionV2ForEliteUser Test is : "+response.statusCode());

		test.info("status code --> "+response.statusCode());
		if(cashOutStatus.equals("PAID") || cashOutStatus.equals("INITIATE_WITHDRAWAL") || cashOutStatus.equals("PG_PROCESSING")) {

			test.info("transaction cashout status is ................>"+cashOutStatus);
			Assert.assertTrue(true);

		}
		else
		{
			test.fail("Exception occured while payout....................");
			Assert.assertTrue(false);

		}

	}





}
*/
