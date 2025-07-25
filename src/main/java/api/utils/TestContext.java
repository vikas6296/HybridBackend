package api.utils;

import api.models.*;

public class TestContext
{
    private static final ThreadLocal<UserSignupTcRequest> userRequest = new ThreadLocal<UserSignupTcRequest>();

    private static final ThreadLocal<String> deviceId = new ThreadLocal<>();

    private static final ThreadLocal<UserSignupTcResponse> userResponse = new ThreadLocal<UserSignupTcResponse>();

    private static final ThreadLocal<UserOtpTcRequest> userOtpRequest = new ThreadLocal<UserOtpTcRequest>();

    private static final ThreadLocal<UserOtpTcResponse> userOtpResponse = new ThreadLocal<>();

    private static final ThreadLocal<AddBankRequest> addBankRequestContext = new ThreadLocal<>();

    private static final ThreadLocal<AddBankResponse> addBankResponseContext = new ThreadLocal<>();

    private static final ThreadLocal<PublicTokenForAddBankRequest> PublicTokenForAddBankRequestContext = new ThreadLocal<>();

    private static final ThreadLocal<PublicTokenForAddBankResponse> PublicTokenForAddBankResponseContext = new ThreadLocal<>();

    private static final ThreadLocal<LinktokenResponse> linktokenContext = new ThreadLocal<>();

    private static final ThreadLocal<UserLoginOnNeobankRequest> neobankUserLoginRequest = new ThreadLocal<>();

    private static final ThreadLocal<UserLoginOnNeobankResponse> neobankUserLoginResponse = new ThreadLocal<UserLoginOnNeobankResponse>();

    private static final ThreadLocal<UpdateUserDetailsRequest> updateUserRequest = new ThreadLocal<>();

    private static final ThreadLocal<UpdateUserDetailsResponse> updateUserResponse1 = new ThreadLocal<>();




    public static UserSignupTcRequest getUserRequest()
    {
        return userRequest.get();
    }

    public static UserSignupTcResponse getUserResponse()
    {
        return userResponse.get();
    }

    public static void setUserRequest(UserSignupTcRequest req)
    {
         userRequest.set(req);
    }

    public static void setUserResponse(UserSignupTcResponse res)
    {
         userResponse.set(res);
    }


    public static UserOtpTcRequest getUserOtpRequest()
    {
        return userOtpRequest.get();
    }

    public static UserOtpTcResponse getUserOtpResponse()
    {
        return userOtpResponse.get();
    }

    public static void setUserOtpRequest(UserOtpTcRequest userOtp)
    {
        userOtpRequest.set(userOtp);
    }


    public static void setUserOtpResponse(UserOtpTcResponse userOtp)
    {
        userOtpResponse.set(userOtp);
    }


    public static AddBankRequest getAddBankRequestContext()
    {
        return addBankRequestContext.get();
    }

    public static void setAddBankRequestContext(AddBankRequest adb)
    {
         addBankRequestContext.set(adb);
    }

    public static AddBankResponse getAddBankResponeContext()
    {
        return addBankResponseContext.get();
    }

    public static void setAddBankResponseContext(AddBankResponse adbRes)
    {
        addBankResponseContext.set(adbRes);
    }

    public static PublicTokenForAddBankRequest getpublicTokentContext()
    {
        return PublicTokenForAddBankRequestContext.get();
    }

    public static void setPublicTokenContextRequest( PublicTokenForAddBankRequest publicToken)
    {
         PublicTokenForAddBankRequestContext.set(publicToken);
    }

    public static PublicTokenForAddBankResponse publicTokenResponse ()
    {
        return PublicTokenForAddBankResponseContext.get();

    }

    public static void publicTokenForAddBankResponse (PublicTokenForAddBankResponse pubResponse)
    {
         PublicTokenForAddBankResponseContext.set(pubResponse);

    }

    public static void setDeviceId(String device)
    {
        deviceId.set(device);
    }

    public static String getDeviceId()
    {
        return deviceId.get();
    }


    public static LinktokenResponse getLinktoken()
    {
        return linktokenContext.get();

    }

    public static void setLinktoken(LinktokenResponse lt)
    {
        linktokenContext.set(lt);
    }

    public static UserLoginOnNeobankRequest getUserLoginRequest()
    {
        return neobankUserLoginRequest.get();
    }

    public static void setUserNeobankLoginRequest(UserLoginOnNeobankRequest userLogin)
    {
        neobankUserLoginRequest.set(userLogin);
    }
    public static UserLoginOnNeobankResponse getUserLoginResponse()
    {
        return neobankUserLoginResponse.get();
    }

    public static void setNeobankUserLoginResponse(UserLoginOnNeobankResponse userLoginResponse)
    {
        neobankUserLoginResponse.set(userLoginResponse);
    }

    public static void setUpdateUserRequest(UpdateUserDetailsRequest updateUserDetailsRequest)
    {
        updateUserRequest.set(updateUserDetailsRequest);
    }

    public static UpdateUserDetailsRequest getUpdateUserRequest()
    {
        return updateUserRequest.get();
    }

    public static void setUpdateUserResponse(UpdateUserDetailsResponse updateUserResponse)
    {
        updateUserResponse1.set(updateUserResponse);
    }

    public static UpdateUserDetailsResponse getUpdateUserResponse()
    {
        return updateUserResponse1.get();
    }

    public static void clear()
    {
        userRequest.remove();
        userResponse.remove();
        userOtpRequest.remove();
        userOtpResponse.remove();

    }




}
