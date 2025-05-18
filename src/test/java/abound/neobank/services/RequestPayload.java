/*
package abound.neobank.services;


import net.datafaker.Faker;

public class RequestPayload {

	public String userSignUpService = "{\r\n" +
			"  \"phoneNumber\": \"" + SignupAndKycFlow.phoneNumber + "\"\r\n" +
			"}";


	public String verifyOTPService = "{\r\n" +
			"  \"messageId\": \"" + SignupAndKycFlow.messageId + "\",\r\n" +
			"  \"otp\": \"" + SignupAndKycFlow.otp + "\"\r\n" +
			"}";

	public static Faker faker = new Faker();
	public String addressService = "{\"address_street\":\"2443 Sierra Nevada Road "+faker.name()+"\",\"address_city\":\"Mammoth Lakes\",\"address_subdivision\":\"California\",\"address_subdivision_code\":\"CA\",\"address_postal_code\":\"93546\",\"address_country_code\":\"US\"}";


	public String sendOTPService = "{\r\n" +
			"  \"messageId\": \"" + SignupAndKycFlow.messageId + "\"\r\n" +
			"}";


	public String synapseService = "{}";


	public String timesClubUserSignupService = "{\n" +
			"\"mobile_number\" : \""+SignupAndKycFlow.phoneNumber+"\"\n" +
			"}";

	public String verifyOtpServicePayload="{\n" +
			"  \"message_id\": \""+SignupAndKycFlow.verifyOtpForSignupWithMobileno+"\",\n" +
			"  \"mobile_number\": \""+SignupAndKycFlow.phoneNumber+"\",\n" +
			"  \"otp\": \"123456\", \"verify_otp_type\":\"LOGIN\"  }";

	public String createNewService = "{\r\n" +
			"	\"email\":\"" + SignupAndKycFlow.validEmail + "\",\r\n" +
			"     \"password\": \"Vtest@9910\"\r\n" +
			"	\r\n" +
			"}";

	public String updateUserService = "{\"email\": \"" + SignupAndKycFlow.validEmail + "\",\r\n" +
			"  \"firstName\": \"" + SignupAndKycFlow.firstName + "\",\r\n" +
			"  \"lastName\": \"" + SignupAndKycFlow.lastName + "\",\r\n" +
			"  \"dateOfBirth\": \"15/10/1988\"\r\n" +
			"}";

	public String updateUserServiceForIndian = "{\"email\": \"" + IndianUserFlow.randomGenerator() + "\",\r\n" +
			"  \"firstName\": \"" + IndianUserFlow.firstName + "\",\r\n" +
			"  \"lastName\": \"" + IndianUserFlow.lastName + "\",\r\n" +
			"  \"dateOfBirth\": \"15/10/1988\"\r\n" +
			"}";

	public String signUpWithoutJWT = "{\r\n" +
			"  \"email\": \"" + SignupAndKycFlow.validEmail + "\",\r\n" +
			"  \"phoneNumber\": \"" + SignupAndKycFlow.phoneNumber + "\",\r\n" +
			"  \"linkToken\":\"\",\r\n" +
			"  \"jwtToken\": \"\"\r\n" +
			"}";
	public String otpServicesWithoutJWT = "{\r\n" +
			"  \"messageId\": \"" + SignupAndKycFlow.messageId + "\",\r\n" +
			"  \"otp\": \"397038\"\r\n" +
			"}";


	public String otpServiceInvalidEmailidAndAuthorizatiosn = "{\r\n" +
			"  \"messageId\": \"" + SignupAndKycFlow.messageId + "\"\r\n" +
			"}";


	public String validteAdressServiceOnWrongAddress = "{\r\n" +
			"    \"address_street\": \"\",\r\n" +
			"    \"address_city\": \"\",\r\n" +
			"    \"address_subdivision\": \"\",\r\n" +
			"    \"address_postal_code\": \"\",\r\n" +
			"    \"address_country_code\": \"\"\r\n" +
			"}";

	public String validateUpdateServiceByPassingInvalidToken = "{\r\n" +
			"  \"email\": \"" + SignupAndKycFlow.validEmail + "\",\r\n" +
			"  \"phoneNumber\": \"" + SignupAndKycFlow.phoneNumber + "\",\r\n" +
			"  \"firstName\": \"vikas\",\r\n" +
			"  \"lastName\": \"kumar\"\r\n" +
			"}";

	public String validateWhenLongitudeAndlongitudeIsNotPassedInSignUpService = "{\r\n" +
			"  \"email\": \"" + SignupAndKycFlow.validEmail + "\",\r\n" +
			"  \"phoneNumber\": \"" + SignupAndKycFlow.phoneNumber + "\",\r\n" +
			"  \"linkToken\":\"" + SignupAndKycFlow.linkToken + "\",\r\n" +
			"  \"jwtToken\": \"" + SignupAndKycFlow.jwtToken + "\"\r\n" +
			"}";

	public String updateUserServiceNegative = "{\r\n" +
			"  \"email\": \"" + SignupAndKycFlow.validEmail + "\",\r\n" +
			"  \"phoneNumber\": \"" + SignupAndKycFlow.phoneNumber + "\",\r\n" +
			"  \"firstName\": \"vikas\",\r\n" +
			"  \"lastName\": \"kumar\"\r\n" +
			"}";


	public String verifyOTPPayload = "{\r\n" +
			"    \"message_id\":\"" + USUserFlow.messageId + "\",\r\n" +
			"    \"otp\":\"123456\"\r\n" +
			"}";

	public String publicTokenForBank = "{\"client_id\":\"5d02356c84b198001367525a\",\"secret\":\"937a0063d953f9539c20afe0f7df3f\",\"institution_id\":\"ins_33\",\"initial_products\":[\"transactions\"],\"options\":{\"override_username\":\"custom_test31\",\"override_password\":\"pass_good\"}}";

	public String bankLink = "{\r\n" +
			"    \"public-token\": \"" + SignupAndKycFlow.publicLinkToken + "\"\r\n" +
			"}";

	public String getUserSharingTokenPayload = "{\"first_name\":\"" + IndianUserFlow.firstName + "\",\"last_name\":\"" + IndianUserFlow.lastName + "\"}";

	public String mobileVerifyPayload = "{\r\n" +
			"    \"phone_number\":\"" + SignupAndKycFlow.phoneNumberForGetToken + "\"\r\n" +
			"}";


	public String setPin = "{\r\n" +
			"    \"pin\":\"9971\",\r\n" +
			"    \"subnet_id\":\"" + NewUSUserFlow.externalsubnetid + "\"\r\n" +
			"}";

	public String accountsData = "{\r\n" +
			"  \"funding_source\": \"" + USUserFlow.accountIdForCMA + "\",\r\n" +
			"  \"frequency\": 30,\r\n" +
			"  \"opted_limit\": 500,\r\n" +
			"  \"opted_account_type\": \"JOINT\",\r\n" +
			"  \"first_name\": \"Vikas\",\r\n" +
			"  \"last_name\": \"Kumar\"\r\n" +
			"}";

	public String profileData = "{\r\n" +
			"      \"first_name\":\"Vikas\",\r\n" +
			"    	    \"last_name\":\"Kumar\",\r\n" +
			"    	    \"mobile_number\":\"\"\r\n" +
			"    	}";

	public String loginDetails = "{\"token\":\"" + USUserFlow.ssoToken + "\"}";

	public String otpDetails = "{\r\n" +
			"\"messageId\":\"" + USUserFlow.messageId + "\",\r\n" +
			"\"otp\":\"" + IndianUserFlow.otp + "\"\r\n" +
			"}";

	public String createACHService = "{\r\n" +
			"\"accountId\":\"" + Remittance.accountid  + "\",\r\n" +
			"\"amount\":100,\r\n" +
			"\"node_id\":\"" + SignupAndKycFlow.nodeId + "\"\r\n" +
			"\r\n" +
			"}";

	public String createACHServiceForUSCard = "{\r\n" +
			"\"accountId\":\"" + NewUSUserFlow.accountIdForAch  + "\",\r\n" +
			"\"amount\":50,\r\n" +
			"\"node_id\":\"" + SignupAndKycFlow.nodeId + "\"\r\n" +
			"\r\n" +
			"}";

	public String docUpload = "{\"front_document_url\":\"neoBank/7fc7bcc7-644f-4253-91d6-f008c3bca7f8-1676302828174/GOVT_ID\",\"back_document_url\":\"neoBank/7fc7bcc7-644f-4253-91d6-f008c3bca7f8-1676302828174/GOVT_ID_BACK\",\"document_type\":\"GOVT_ID\",\"user_type\":\"JOINT\"}";

	public String videoUpload = "{\"front_document_url\":\"neoBank/7fc7bcc7-644f-4253-91d6-f008c3bca7f8-1676302828174/VIDEO_AUTHORIZATION\",\"document_type\":\"VIDEO_AUTHORIZATION\",\"user_type\":\"JOINT\"}";

	public String cardActivate = "{\"status\":\"ACTIVE\",\"subnet_id\":\"" + NewUSUserFlow.externalsubnetid + "\"}";

	public String amzonTransaction = "{\"authentication\":{\"account_number\":\"" + IndianUserFlow.cardNumberMasked + "\",\"accountholder_billing_address\":\"\",\"accountholder_billing_zipcode\":\"92345\",\"cvv\":\"\",\"expiration_date\":\"02/27\",\"merchant_security_code\":\"12345\",\"authorization_code\":\"123456\"},\"amount\":{\"debit\":true,\"transaction_currency\":\"USD\",\"transaction_value\":10,\"settlement_currency\":\"USD\",\"settlement_currency_conversion_rate\":\"1\",\"settlement_value\":10},\"meta\":{\"card_acceptor\":{\"acquirer_id\":\"8764083531\",\"mcc\":\"5968\",\"address\":{\"street\":\"Amazon Video\",\"city\":\"amazon.com\",\"state\":\"CA\",\"country\":\"US\"},\"name\":\"Amazon\",\"terminal_id\":\"100\",\"merchant_number\":\"123456\"},\"is_force_post\":false,\"is_recurring\":true,\"merchant_name\":\"Amazon\",\"partial_approval_allowed\":false,\"point_of_service\":{\"condition_code\":\"\",\"pan_entry_mode\":\"MANUAL\",\"pin_entry_mode\":\"UNSPECIFIED\",\"presentment\":{\"card_presence\":\"CARD_NOT_PRESENT\",\"cardholder_presence\":\"RECURRING_PAYMENT\",\"security_concern\":\"NO_SECURITY_CONCERN\",\"type\":\"ORIGINAL_PRESENTMENT\"},\"terminal\":{\"attendance\":\"ATTENDED\",\"card_input_capability\":\"KEY_ENTERED\",\"card_retention_capability\":\"DEVICE_CANNOT_RETAIN_CARD\",\"location\":\"ON_PREMISE\",\"operator\":\"CUSTOMER_OPERATED\",\"type\":\"DIAL_TERMINAL\"}},\"type\":\"PURCHASE\"}}";

	public String blockCard = "{\"status\":\"TERMINATED\",\"subnet_id\":\"" + NewUSUserFlow.externalsubnetid + "\"}";

	public String addbeneficiaryForUPI = "{\"name\":\"Vikas\",\"email\":\"\",\"account_type\":\"UPI_ID\",\"upi_id\":\"8447232897@ybl\",\"address\":{\"address_country_code\":\"IN\",\"address_city\":\"\",\"address_street\":\"\",\"address_pincode\":\"\"}}";
	public String addbeneficiary = "{\"relationship_type\":\"SELF\",\"payment_reason_code\":\"IR007\",\"email\":\"\",\"name\":\"Vikas KUMAR\",\"account_type\":\"ACCOUNT_DETAILS\",\"address\":{\"address_country_code\":\"IN\",\"address_city\":\"\",\"address_street\":\"\",\"address_pincode\":\"\"},\"pan_no\":\"\",\"account_number\":\"4053000100175349\",\"ifsc_code\":\"PUNB0405300\"}";

	public String remittanceTransactionPayload = "{\"beneficiary_ref_id\":\"" + Remittance.benficiaryId + "\",\"payment_initiate_identifier\":\"" + Remittance.accountid + "\",\"payment_reason_code\":\"IR002\",\"payment_instrument\":\"ACH\",\"request_id\":\"" + Remittance.requestIdForNormalTxn + "\",\"destination_amount\":\""+3*Remittance.effectiveRate+"\",\"source_amount\":\"3\",\"opted_transaction_delivery\":\"NORMAL\",\"opted_transaction_fee\":\"0\",\"transfer_fee\":\"0\"}";

	public String remittanceTransactionPayloadForFailDueToIncorrectValue = "{\"beneficiary_ref_id\":\"" + Remittance.benficiaryId + "\",\"payment_initiate_identifier\":\"" + Remittance.accountid + "\",\"payment_reason_code\":\"IR002\",\"payment_instrument\":\"ACH\",\"request_id\":\"" + Remittance.requestId + "\",\"destination_amount\":\""+1*Remittance.effectiveRate+"\",\"source_amount\":\"1\",\"opted_transaction_delivery\":\"NORMAL\",\"opted_transaction_fee\":\"0\",\"transfer_fee\":\"0\"}";
	public String remittanceTransactionPayloadForInstantAch = "{\"beneficiary_ref_id\":\"" + Remittance.benficiaryId + "\",\"payment_initiate_identifier\":\"" + Remittance.accountid + "\",\"payment_reason_code\":\"IR004\",\"payment_instrument\":\"ACH\",\"request_id\":\"" + Remittance.requestIdForInstantACH + "\",\"destination_amount\":\""+3*Remittance.effectiveRate+"\",\"source_amount\":\"3\",\"opted_transaction_delivery_type\":\"INSTANT\",\"opted_transaction_fee\":\"1.99\",\"transfer_fee\":\"1\"}";
	public String remittanceTransactionPayloadForInstantAchWithoutTransferFees = "{\"beneficiary_ref_id\":\"" + Remittance.benficiaryId + "\",\"payment_initiate_identifier\":\"" + Remittance.accountid + "\",\"payment_reason_code\":\"IR004\",\"payment_instrument\":\"ACH\",\"request_id\":\"" + Remittance.requestIdForInstantACH + "\",\"destination_amount\":\""+3*Remittance.effectiveRate+"\",\"source_amount\":\"3\",\"opted_transaction_delivery_type\":\"INSTANT\",\"opted_transaction_fee\":\"0\",\"transfer_fee\":\"0\"}";

	public String remittanceTransactionPayloadFroCMAAddition = "{\"beneficiary_ref_id\":\"" + Remittance.benficiaryId + "\",\"payment_initiate_identifier\":\"" + Remittance.accIdForCmaAccount + "\",\"payment_reason_code\":\"IR004\",\"payment_instrument\":\"BANK_ACCOUNT\",\"request_id\":\"" + Remittance.requestIdForNormalTxn + "\",\"destination_amount\":\""+1*Remittance.effectiveRateForFirstTxn+"\",\"source_amount\":\"1\",\"opted_transaction_delivery\":\"NORMAL\",\"opted_transaction_fee\":\"0\",\"transfer_fee\":\"0\"}";

	public String remittanceTransactionPayloadUsingUPI = "{\"beneficiary_ref_id\":\"" + Remittance.beneficiaryForUPI + "\",\"payment_initiate_identifier\":\"" + Remittance.accountid + "\",\"payment_reason_code\":\"IR002\",\"payment_instrument\":\"ACH\",\"request_id\":\"" + Remittance.requestIdForUPI + "\",\"destination_amount\":\""+3*Remittance.effectiveRateForTxnUsingUPI+"\",\"source_amount\":\"3\",\"opted_transaction_delivery\":\"NORMAL\",\"opted_transaction_fee\":\"0\",\"transfer_fee\":\"0\"}";

     public String loginPayloadForExistingUser=" {\"mobile_number\":\"+19955887673\"}";

	 public String verifYOTPPayloadForTc = "{\"message_id\":\""+SignupAndKycFlow.messageIdForTc+"\",\"otp\":\"123456\",\"verify_otp_type\":\"LOGIN\",\"mobile_number\":\"+19955887673\"}";
	 public String deviceIdForLoginUser="1f228955629174ed";

	 public String customerIdForLoginUser="df3f633d-2bc7-4c0f-b129-5e6fd90747d1-1717747543364";

     public String verifyOtpForLoginUser="{\n" +
			 "  \"messageId\": \""+SignupAndKycFlow.messageIdForLogin+"\",\n" +
			 "  \"otp\": \"123456\",\n" +
			 "  \"linkToken\":\""+SignupAndKycFlow.linkTokenForCMATxn+"\"\n" +
			 "}";

	 public String loginPayloadForExistingUserOnNeobank="{\"loginType\": \"OTP\", \"token\": null}";

	public String loginPayloadForNormalUserOnNeobank="{\"loginType\": \"OTP\", \"token\": null}";



	 public String cashoutPayload="{\"amount\":\"1\",\"external_ref_id\":\"eoZvNrwXoQcjvwZpp9aec35A8qg7pbsreZPzJ\"}";

	 public String ssnPayload="{\"ssn_number\": \""+SignupAndKycFlow.randomSSN()+"\"}";
	 public String remittanceTransactionPayloadForTransaction = "{\"beneficiary_ref_id\":\"" + Remittance.benficiaryId + "\",\"payment_initiate_identifier\":\"" + Remittance.accountIdforLoggedInUser + "\",\"payment_reason_code\":\"IR004\",\"payment_instrument\":\"BANK_ACCOUNT\",\"request_id\":\"" + Remittance.requestIdForNormalTxn + "\",\"destination_amount\":\""+0.1*Remittance.effectiveRateForFirstTxn+"\",\"source_amount\":\"0.1\",\"opted_transaction_delivery\":\"NORMAL\",\"opted_transaction_fee\":\"0\",\"transfer_fee\":\"0\"}";

	//public String cashoutPayloadForMultileHits="{\"amount\":\"0.1\",\"external_ref_id\":\""+NewUSUserFlow.nodeIdForCashout+"\"}";

	public String remittanceTransactionInOwnAccount = "{\"beneficiary_ref_id\":\"" + Remittance.accountid + "\",\"payment_initiate_identifier\":\"" + Remittance.accountid + "\",\"payment_reason_code\":\"IR002\",\"payment_instrument\":\"ACH\",\"request_id\":\"" + Remittance.requestIdForNormalTxn + "\",\"destination_amount\":\""+3*Remittance.effectiveRate+"\",\"source_amount\":\"1\",\"opted_transaction_delivery\":\"NORMAL\",\"opted_transaction_fee\":\"0\",\"transfer_fee\":\"0\"}";

	public String remittanceTransactionPayloadUsingUPIInSameBeneficary = "{\"beneficiary_ref_id\":\"" + Remittance.beneficiaryForUPI + "\",\"payment_initiate_identifier\":\"" + Remittance.beneficiaryForUPI + "\",\"payment_reason_code\":\"IR002\",\"payment_instrument\":\"ACH\",\"request_id\":\"" + Remittance.requestIdForUPI + "\",\"destination_amount\":\""+3*Remittance.effectiveRateForTxnUsingUPI+"\",\"source_amount\":\"3\",\"opted_transaction_delivery\":\"NORMAL\",\"opted_transaction_fee\":\"0\",\"transfer_fee\":\"0\"}";

	public String cashoutPayloadOnPassingSameNodeIdInExternalNodeId="{\"amount\":\"0.1\",\"external_ref_id\":\""+SignupAndKycFlow.nodeId+"\"}";


	//public String cashoutPayloadOnHavingLowBalance="{\"amount\":\"200000\",\"external_ref_id\":\""+NewUSUserFlow.nodeIdForCashout+"\"}";

	public String createACHServiceForCashIn = "{\r\n" +
			"\"accountId\":\"" + Remittance.accountid  + "\",\r\n" +
			"\"amount\":200,\r\n" +
			"\"node_id\":\"" + SignupAndKycFlow.nodeId + "\"\r\n" +
			"\r\n" +
			"}";
	public String remittanceTransactionPayloadForCashoutFlow = "{\"beneficiary_ref_id\":\"" + Remittance.benficiaryId + "\",\"payment_initiate_identifier\":\"" + Remittance.accountid + "\",\"payment_reason_code\":\"IR002\",\"payment_instrument\":\"ACH\",\"request_id\":\"" + Remittance.requestIdForNormalTxn + "\",\"destination_amount\":\""+11000*Remittance.effectiveRate+"\",\"source_amount\":\"11000\",\"opted_transaction_delivery\":\"NORMAL\",\"opted_transaction_fee\":\"0\",\"transfer_fee\":\"0\"}";

	public String remittanceTransactionPayloadForCashoutFlowMonthly = "{\"beneficiary_ref_id\":\"" + Remittance.benficiaryId + "\",\"payment_initiate_identifier\":\"" + Remittance.accountid + "\",\"payment_reason_code\":\"IR002\",\"payment_instrument\":\"ACH\",\"request_id\":\"" + Remittance.requestIdForNormalTxn + "\",\"destination_amount\":\""+21000*Remittance.effectiveRate+"\",\"source_amount\":\"21000\",\"opted_transaction_delivery\":\"NORMAL\",\"opted_transaction_fee\":\"0\",\"transfer_fee\":\"0\"}";

	public String createACHServiceForCashInMonthly = "{\r\n" +
			"\"accountId\":\"" + Remittance.accountid  + "\",\r\n" +
			"\"amount\":11000,\r\n" +
			"\"node_id\":\"" + SignupAndKycFlow.nodeId + "\"\r\n" +
			"\r\n" +
			"}";

	public String exchangeTokenForJwt="{\"access_token\":\""+SignupAndKycFlow.jwtToken+"\"}";




	public String createUpdateTransactionPayloadForLoggedInUser= "{\"beneficiary_ref_id\":\"9aab1a46-d36d-44bd-9593-019be4531efb\",\"funding_source\":{\"name\":\"Checking\",\"selected\":false,\"image\":\"/images/discover.png\",\"official_name\":\"Plaid checking\",\"account_id\":\""+Remittance.accountidForLoginUser+"\",\"is_invalid\":false,\"ins_name\":\"Discover\",\"auth_supported\":true,\"display_account_balance\":\"\",\"account_balance\":0,\"payment_instrument_type\":\"ACH\",\"item_id\":\""+Remittance.itemIdForLoggedInUser+"\",\"mask\":\"0013\",\"account_subtype\":\"checking\"},\"cma_funding_source\":{\"name\":null,\"selected\":false,\"image\":null,\"official_name\":null,\"account_id\":null,\"is_invalid\":false,\"ins_name\":null,\"auth_supported\":false,\"display_account_balance\":\"\",\"account_balance\":0,\"payment_instrument_type\":null,\"item_id\":null,\"mask\":null,\"account_subtype\":null},\"current_step_name\":\"FUNDING_SOURCE_SELECTED\",\"beneficiary_details\":{\"name\":\"VIKAS KUMAR\",\"email\":\"\",\"account_identifier\":\"******7284\",\"beneficiary_ref_id\":\"9aab1a46-d36d-44bd-9593-019be4531efb\",\"recipient_transfer_type\":\"ACCOUNT_DETAILS\",\"pan_card_applicable\":false,\"layer2_migration_flow\":false,\"payment_reason_code\":null,\"ifsc\":null},\"source_amount\":2,\"destination_amount\":"+2*Remittance.effectiveExchangeRateForLoginUser+",\"payment_reason_code\":\"IR007\",\"opted_transaction_fee\":0,\"opted_transaction_delivery_type\":\"NORMAL\",\"transfer_fee\":"+Remittance.transactionFeeForloggedInUser+",\"opted_abound_balance\":0,\"status\":\"PENDING\",\"fx_hold_id\":\""+Remittance.holdIdForloggedInUser+"\",\"effective_exchange_rate\":"+Remittance.effectiveExchangeRateForLoginUser+",\"initiation_time\":1709796560340,\"campaign_id\":\"46\",\"fx_rate_details\":{\"maxUsersAllowed\":10000,\"campaignActive\":true,\"campaign_id\":\"46\",\"exchange_rates\":{\"current_exchange_rate_data\":{\"value\":82.92,\"display_value\":\"₹82.92\",\"currency\":\"₹\"},\"effective_exchange_rate_data\":{\"value\":83.32,\"display_value\":\"₹83.32\",\"currency\":\"₹\"},\"display_current_exchange_rate\":\"82.92\",\"display_effective_exchange_rate\":\"83.32\",\"exchange_rate_currency\":\"₹\",\"min_amount_transaction\":null,\"max_amount_transaction\":null,\"campaign_id\":\"46\",\"promotional_applicable\":false},\"promotional_exchange_rate_applicable\":true,\"min_amount_transaction\":0,\"min_amount_transaction_data\":{\"value\":0,\"display_value\":\"$0\",\"currency\":\"$\"},\"max_amount_transaction\":3000.00,\"max_amount_transaction_data\":{\"value\":3000.00,\"display_value\":\"$3,000\",\"currency\":\"$\"},\"transaction_default_value\":1000,\"transaction_default_value_data\":{\"value\":1000,\"display_value\":\"$1,000\",\"currency\":\"$\"},\"display_min_amount_transaction\":\"0\",\"display_max_amount_transaction\":\"3,000\",\"display_transaction_default_value\":\"1,000\",\"transaction_fee\":"+Remittance.transactionFeeForloggedInUser+",\"transaction_fee_data\":{\"value\":0.0,\"display_value\":\"₹0\",\"currency\":\"₹\"},\"applicable_transaction_fee\":"+Remittance.applicable_transaction_feeForLoggedInUser+",\"applicable_transaction_fee_data\":{\"value\":0.0,\"display_value\":\"₹0\",\"currency\":\"₹\"},\"display_transaction_fee\":\"0\",\"display_applicable_transaction_fee\":\"0\",\"instant_transfer_active\":false,\"fx_hold_id\":\""+Remittance.holdIdForloggedInUser+"\",\"currency\":\"$\"},\"amount_breakup\":[{\"source_amount\":2,\"destination_amount\":"+2*Remittance.effectiveExchangeRateForLoginUser+",\"effective_fx_rate\":"+Remittance.effectiveExchangeRateForLoginUser+",\"campaign\":\"Best FX Guaranteed\",\"campaign_id\":\"46\",\"display_effective_rate\":\"83.32\",\"display_source_amount\":\"10\"}],\"success\":true,\"request_id\":\""+Remittance.requestIdForLoginUser+"\"}";
   public String createUpdateTransactionForCopayPayload= "{\"beneficiary_ref_id\":\"9aab1a46-d36d-44bd-9593-019be4531efb\",\"funding_source\":{\"name\":\"Checking\",\"selected\":false,\"image\":\"/images/discover.png\",\"official_name\":\"Plaid checking\",\"account_id\":\""+Remittance.accountIdForBankAccount+"\",\"is_invalid\":false,\"ins_name\":\"Discover\",\"auth_supported\":true,\"display_account_balance\":\"\",\"account_balance\":0,\"payment_instrument_type\":\"ACH\",\"item_id\":\""+Remittance.itemIdForBankAccount+"\",\"mask\":\"0013\",\"account_subtype\":\"checking\"},\"cma_funding_source\":{\"name\":\"Atish Maria\",\"selected\":true,\"image\":\"/images/abound.png\",\"official_name\":\"Atish Maria\",\"account_id\":\"3a596176-4065-4933-918d-164a39525f79\",\"is_invalid\":false,\"ins_name\":\"Abound Balance\",\"auth_supported\":true,\"display_account_balance\":\"$5000\",\"account_balance\":"+Remittance.aboundBalance+",\"payment_instrument_type\":\"BANK_ACCOUNT\",\"item_id\":null,\"mask\":null,\"account_subtype\":null},\"current_step_name\":\"FUNDING_SOURCE_SELECTED\",\"beneficiary_details\":{\"name\":\"Vikas\",\"email\":\"\",\"account_identifier\":\"************5349\",\"beneficiary_ref_id\":\"9aab1a46-d36d-44bd-9593-019be4531efb\",\"recipient_transfer_type\":\"ACCOUNT_DETAILS\",\"pan_card_applicable\":false},\"source_amount\":500,\"destination_amount\":\""+500*Remittance.effectiveExchangeRateForLoginUser+"\",\"payment_reason_code\":\"IR004\",\"opted_transaction_fee\":0,\"opted_transaction_delivery_type\":\"NORMAL\",\"transfer_fee\":0,\"opted_abound_balance\":1,\"status\":\"PENDING\",\"fx_hold_id\":\""+Remittance.holdIdForloggedInUser+"\",\"effective_exchange_rate\":\""+Remittance.effectiveExchangeRateForLoginUser+"\",\"initiation_time\":1709796560340,\"campaign_id\":\"46\",\"fx_rate_details\":{\"maxUsersAllowed\":10000,\"campaignActive\":false,\"campaign_id\":\"46\",\"exchange_rates\":{\"current_exchange_rate\":\""+Remittance.currentExchangeRateForLoginUser+"\",\"effective_exchange_rate\":\""+Remittance.effectiveExchangeRateForLoginUser+"\",\"display_current_exchange_rate\":\"81.94\",\"display_effective_exchange_rate\":\"81.94\",\"exchange_rate_currency\":\"₹\"},\"promotional_exchange_rate_applicable\":false,\"min_amount_transaction\":0,\"max_amount_transaction\":1700,\"transaction_default_value\":100,\"display_min_amount_transaction\":\"0\",\"display_max_amount_transaction\":\"1700\",\"display_transaction_default_value\":\"100\",\"transaction_fee\":1,\"applicable_transaction_fee\":0,\"display_transaction_fee\":\"1\",\"display_applicable_transaction_fee\":\"0\",\"instant_transfer_active\":true,\"fx_hold_id\":\""+Remittance.holdIdForloggedInUser+"\",\"currency\":\"$\"},\"success\":true,\"request_id\":\""+Remittance.requestIdForLoginUser+"\"}";

   public String createUpdateTransactionForAboundWallet="{\"beneficiary_ref_id\":\"9aab1a46-d36d-44bd-9593-019be4531efb\",\"funding_source\":{\"name\":\"checking\",\"selected\":false,\"image\":\"/images/citizens-bank.png\",\"official_name\":\"Plaid checking\",\"account_id\":\""+Remittance.accountIdForBankAccount+"\",\"is_invalid\":false,\"ins_name\":\"Citizens Bank\",\"auth_supported\":true,\"display_account_balance\":\"\",\"account_balance\":0,\"payment_instrument_type\":\"ACH\",\"item_id\":\""+Remittance.itemIdForBankAccount+"\",\"mask\":\"0013\",\"account_subtype\":\"checking\"},\"cma_funding_source\":{\"name\":null,\"selected\":true,\"image\":\"/images/abound.png\",\"official_name\":null,\"account_id\":\"df3f633d-2bc7-4c0f-b129-5e6fd90747d1-1717747543364\",\"is_invalid\":false,\"ins_name\":\"Abound Balance\",\"auth_supported\":true,\"display_account_balance\":\"$1,000\",\"account_balance\":1000,\"payment_instrument_type\":\"ABOUND_WALLET\",\"item_id\":null,\"mask\":null,\"account_subtype\":null},\"current_step_name\":\"FUNDING_SOURCE_SELECTED\",\"beneficiary_details\":{\"name\":\"VIKAS KUMAR\",\"email\":\"\",\"account_identifier\":\"******7284\",\"beneficiary_ref_id\":\"9aab1a46-d36d-44bd-9593-019be4531efb\",\"recipient_transfer_type\":\"ACCOUNT_DETAILS\",\"pan_card_applicable\":false,\"layer2_migration_flow\":false,\"payment_reason_code\":null,\"ifsc\":null},\"source_amount\":5,\"destination_amount\":"+5*Remittance.effectiveExchangeRateForLoginUser+",\"payment_reason_code\":\"IR007\",\"opted_transaction_fee\":0,\"opted_transaction_delivery_type\":\"NORMAL\",\"transfer_fee\":"+Remittance.transactionFeeForloggedInUser+",\"opted_abound_balance\":1,\"status\":\"PENDING\",\"fx_hold_id\":\""+Remittance.holdIdForloggedInUser+"\",\"effective_exchange_rate\":"+Remittance.effectiveExchangeRateForLoginUser+",\"campaign_id\":\"46\",\"fx_rate_details\":{\"maxUsersAllowed\":10000,\"campaignActive\":true,\"campaign_id\":\"46\",\"exchange_rates\":{\"current_exchange_rate\":"+Remittance.currentExchangeRateForLoginUser+",\"current_exchange_rate_data\":{\"value\":82.94,\"display_value\":\"₹82.94\",\"currency\":\"₹\"},\"effective_exchange_rate\":"+Remittance.effectiveExchangeRateForLoginUser+",\"effective_exchange_rate_data\":{\"value\":83.34,\"display_value\":\"₹83.34\",\"currency\":\"₹\"},\"display_current_exchange_rate\":\"82.94\",\"display_effective_exchange_rate\":\"83.34\",\"exchange_rate_currency\":\"₹\",\"min_amount_transaction\":null,\"max_amount_transaction\":null,\"campaign_id\":\"46\",\"promotional_applicable\":false},\"promotional_exchange_rate_applicable\":true,\"min_amount_transaction\":0,\"min_amount_transaction_data\":{\"value\":0,\"display_value\":\"$0\",\"currency\":\"$\"},\"max_amount_transaction\":3000,\"max_amount_transaction_data\":{\"value\":3000,\"display_value\":\"$3,000\",\"currency\":\"$\"},\"transaction_default_value\":1000,\"transaction_default_value_data\":{\"value\":1000,\"display_value\":\"$1,000\",\"currency\":\"$\"},\"display_min_amount_transaction\":\"0\",\"display_max_amount_transaction\":\"3,000\",\"display_transaction_default_value\":\"1,000\",\"transaction_fee\":"+Remittance.transactionFeeForloggedInUser+",\"transaction_fee_data\":{\"value\":2,\"display_value\":\"₹2\",\"currency\":\"₹\"},\"applicable_transaction_fee\":"+Remittance.applicable_transaction_feeForLoggedInUser+",\"applicable_transaction_fee_data\":{\"value\":2,\"display_value\":\"₹2\",\"currency\":\"₹\"},\"display_transaction_fee\":\"2\",\"display_applicable_transaction_fee\":\"2\",\"instant_transfer_active\":false,\"fx_hold_id\":\""+Remittance.holdIdForloggedInUser+"\",\"currency\":\"$\"},\"offer_campaign_id\":\"760\",\"amount_breakup\":[{\"source_amount\":5,\"destination_amount\":"+5*Remittance.effectiveExchangeRateForLoginUser+",\"effective_fx_rate\":"+Remittance.effectiveExchangeRateForLoginUser+",\"campaign\":\"Best FX Guaranteed\",\"campaign_id\":\"46\",\"display_effective_rate\":\"83.34\",\"display_source_amount\":\"1,100\"}],\"success\":true,\"request_id\":\""+Remittance.requestIdForLoginUser+"\"}";

    public String createUploadCMATxn="{\"beneficiary_ref_id\":\"d85f476e-ce87-4d83-9777-90ad287c8c67\",\"funding_source\":{\"name\":null,\"selected\":false,\"image\":null,\"official_name\":null,\"account_id\":null,\"is_invalid\":false,\"ins_name\":null,\"auth_supported\":false,\"display_account_balance\":\"\",\"account_balance\":0,\"payment_instrument_type\":null,\"item_id\":null,\"mask\":null,\"account_subtype\":null},\"cma_funding_source\":{\"name\":\"Vikas Kumar\",\"selected\":true,\"image\":\"/images/abound.png\",\"official_name\":\"Vikas Kumar\",\"account_id\":\"5ca8ec9f-6d60-4bfc-a7d2-a3a93daa2172\",\"is_invalid\":false,\"ins_name\":\"Abound Balance\",\"auth_supported\":true,\"display_account_balance\":\"$5000\",\"account_balance\":5000,\"payment_instrument_type\":\"BANK_ACCOUNT\",\"item_id\":null,\"mask\":null,\"account_subtype\":null},\"current_step_name\":\"FUNDING_SOURCE_SELECTED\",\"beneficiary_details\":{\"name\":\"Vikas\",\"email\":\"\",\"account_identifier\":\"************5349\",\"beneficiary_ref_id\":\"348c1786-a8d8-4901-a41d-ad993b7a7796\",\"recipient_transfer_type\":\"ACCOUNT_DETAILS\",\"pan_card_applicable\":false},\"source_amount\":1,\"destination_amount\":\""+1*Remittance.effectiveExchangeRateForLoginUser+"\",\"payment_reason_code\":\"IR004\",\"opted_transaction_fee\":0,\"opted_transaction_delivery_type\":\"NORMAL\",\"transfer_fee\":0,\"opted_abound_balance\":5000,\"status\":\"PENDING\",\"fx_hold_id\":\""+Remittance.holdIdForloggedInUser+"\",\"effective_exchange_rate\":\""+Remittance.effectiveExchangeRateForLoginUser+"\",\"initiation_time\":1709796560340,\"campaign_id\":\"46\",\"fx_rate_details\":{\"maxUsersAllowed\":10000,\"campaignActive\":false,\"campaign_id\":\"46\",\"exchange_rates\":{\"current_exchange_rate\":\""+Remittance.currentExchangeRateForLoginUser+"\",\"effective_exchange_rate\":\""+Remittance.effectiveExchangeRateForLoginUser+"\",\"display_current_exchange_rate\":\"81.94\",\"display_effective_exchange_rate\":\"81.94\",\"exchange_rate_currency\":\"₹\"},\"promotional_exchange_rate_applicable\":false,\"min_amount_transaction\":0,\"max_amount_transaction\":1700,\"transaction_default_value\":100,\"display_min_amount_transaction\":\"0\",\"display_max_amount_transaction\":\"1700\",\"display_transaction_default_value\":\"100\",\"transaction_fee\":1,\"applicable_transaction_fee\":0,\"display_transaction_fee\":\"1\",\"display_applicable_transaction_fee\":\"0\",\"instant_transfer_active\":true,\"fx_hold_id\":\""+Remittance.holdIdForloggedInUser+"\",\"currency\":\"$\"},\"success\":true,\"request_id\":\""+Remittance.requestIdForLoginUser+"\"}";

	public String validateUPIPayload="{\"vpa\":\"8447232897@kotak\"}";

	public String validateUPINegativeTestPayload="{\"vpa\":\""+Remittance.getUPIID()+"\"}";

	public String documentValidate= "{\"front_document_url\":\"06f5fc74-c7bb-492b-8c91-0c54b0b336f8-1730095806069/PASSPORT/PASSPORT_BIODATA\",\"document_type\":\"PASSPORT\",\"user_type\":\"PRIMARY\",\"meta\":{}}";


	public  String deviceIdForEliteUser="1f228955629174vk";

	public String verifYOTPPayloadForTcForElite = "{\"message_id\":\""+SignupAndKycFlow.messageIdForTcForElite+"\",\"otp\":\"123456\",\"verify_otp_type\":\"LOGIN\",\"mobile_number\":\"+19955889548\"}";

	public String customerIdForEliteUser="6f0bbb61-715a-4217-a322-ff26df8d3d68-1720437958284";

	public String loginPayloadForEliteUser="{\"loginType\": \"OTP\", \"token\": null}";

	public String verifyOtpForEliteUser="{\n" +
			"  \"messageId\": \""+SignupAndKycFlow.messageIdForNeobankForElite+"\",\n" +
			"  \"otp\": \"123456\",\n" +
			"  \"linkToken\":\""+SignupAndKycFlow.linkTokenForEliteUser+"\"\n" +
			"}";

	public String createUpdateTransactionPayloadForEliteInUser= "{\"beneficiary_ref_id\":\"f2068519-34a6-4eb8-b849-b1a0210bc583\",\"funding_source\":{\"name\":\"Checking\",\"selected\":false,\"image\":\"/images/discover.png\",\"official_name\":\"Plaid checking\",\"account_id\":\""+Remittance.accountidForLoginUser+"\",\"is_invalid\":false,\"ins_name\":\"Discover\",\"auth_supported\":true,\"display_account_balance\":\"\",\"account_balance\":0,\"payment_instrument_type\":\"ACH\",\"item_id\":\""+Remittance.itemIdForLoggedInUser+"\",\"mask\":\"0013\",\"account_subtype\":\"checking\"},\"cma_funding_source\":{\"name\":null,\"selected\":false,\"image\":null,\"official_name\":null,\"account_id\":null,\"is_invalid\":false,\"ins_name\":null,\"auth_supported\":false,\"display_account_balance\":\"\",\"account_balance\":0,\"payment_instrument_type\":null,\"item_id\":null,\"mask\":null,\"account_subtype\":null},\"current_step_name\":\"FUNDING_SOURCE_SELECTED\",\"beneficiary_details\":{\"name\":\"VIKAS KUMAR\",\"email\":\"\",\"account_identifier\":\"******7284\",\"beneficiary_ref_id\":\"f2068519-34a6-4eb8-b849-b1a0210bc583\",\"recipient_transfer_type\":\"ACCOUNT_DETAILS\",\"pan_card_applicable\":false,\"layer2_migration_flow\":false,\"payment_reason_code\":null,\"ifsc\":null},\"source_amount\":2,\"destination_amount\":"+2*Remittance.effectiveExchangeRateForLoginUser+",\"payment_reason_code\":\"IR007\",\"opted_transaction_fee\":0,\"opted_transaction_delivery_type\":\"NORMAL\",\"transfer_fee\":\"0\",\"opted_abound_balance\":0,\"status\":\"PENDING\",\"fx_hold_id\":\""+Remittance.holdIdForloggedInUser+"\",\"effective_exchange_rate\":"+Remittance.effectiveExchangeRateForLoginUser+",\"initiation_time\":1709796560340,\"campaign_id\":\"46\",\"fx_rate_details\":{\"maxUsersAllowed\":10000,\"campaignActive\":true,\"campaign_id\":\"46\",\"exchange_rates\":{\"current_exchange_rate\":"+Remittance.currentExchangeRateForLoginUser+",\"current_exchange_rate_data\":{\"value\":82.92,\"display_value\":\"₹82.92\",\"currency\":\"₹\"},\"effective_exchange_rate\":"+Remittance.effectiveExchangeRateForLoginUser+",\"effective_exchange_rate_data\":{\"value\":83.32,\"display_value\":\"₹83.32\",\"currency\":\"₹\"},\"display_current_exchange_rate\":\"82.92\",\"display_effective_exchange_rate\":\"83.32\",\"exchange_rate_currency\":\"₹\",\"min_amount_transaction\":null,\"max_amount_transaction\":null,\"campaign_id\":\"46\",\"promotional_applicable\":false},\"promotional_exchange_rate_applicable\":true,\"min_amount_transaction\":0,\"min_amount_transaction_data\":{\"value\":0,\"display_value\":\"$0\",\"currency\":\"$\"},\"max_amount_transaction\":3000.00,\"max_amount_transaction_data\":{\"value\":3000.00,\"display_value\":\"$3,000\",\"currency\":\"$\"},\"transaction_default_value\":1000,\"transaction_default_value_data\":{\"value\":1000,\"display_value\":\"$1,000\",\"currency\":\"$\"},\"display_min_amount_transaction\":\"0\",\"display_max_amount_transaction\":\"3,000\",\"display_transaction_default_value\":\"1,000\",\"transaction_fee\":\"0\",\"transaction_fee_data\":{\"value\":0.0,\"display_value\":\"₹0\",\"currency\":\"₹\"},\"applicable_transaction_fee\":\"0\",\"applicable_transaction_fee_data\":{\"value\":0.0,\"display_value\":\"₹0\",\"currency\":\"₹\"},\"display_transaction_fee\":\"0\",\"display_applicable_transaction_fee\":\"0\",\"instant_transfer_active\":false,\"fx_hold_id\":\""+Remittance.holdIdForloggedInUser+"\",\"currency\":\"$\"},\"amount_breakup\":[{\"source_amount\":2,\"destination_amount\":"+2*Remittance.effectiveExchangeRateForLoginUser+",\"effective_fx_rate\":"+Remittance.effectiveExchangeRateForLoginUser+",\"campaign\":\"Best FX Guaranteed\",\"campaign_id\":\"46\",\"display_effective_rate\":\"83.32\",\"display_source_amount\":\"10\"}],\"success\":true,\"request_id\":\""+Remittance.requestIdForLoginUser+"\"}";


	public String loginMobileNoForEliteUser=" {\"mobile_number\":\"+19955889548\"}";
}
*/
