package core;

public class Constants
{

    public static final String BASE_URI = "https://api.example.com";
    public static final String DEFAULT_CONTENT_TYPE = "application/json";

    // File paths

    public static final String userCreation = "https://dev.timesclub.co/times/users/signup-with-mobile";

    public static final String userVerifyOtp = "https://dev.timesclub.co/times/users/verify-otp-login";

    public static final String addBank = "https://dev.timesclub.co/times/plaid/additem/v1/";

    public static final String createPublicLinkToken ="https://sandbox.plaid.com/sandbox/public_token/create";

    public static final String createLinkTokenForNeobank = "https://dev.timesclub.co/times/plaid/neo-bank/token/v2?request_type=GET_USER&source=REMITTANCE";

    public static final String createUserOnNeobank = "https://devneobank.timesclub.co/times/users/signup/v1";



    public static final String updateUserDetails = "https://devneobank.timesclub.co/times/users//update/v1";

    public static final String HEADER_CONTENT_TYPE = "Content-Type";
    public static final String HEADER_AUTH = "Authorization";

    public static final String otp = "123456";

    public static final String verifyOtpLoginType = "LOGIN";

    // Timeout
    public static final int TIMEOUT = 5000;

}
