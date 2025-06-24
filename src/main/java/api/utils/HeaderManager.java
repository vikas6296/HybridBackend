package api.utils;

import utils.DataGenerator;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class HeaderManager {

    static {

        TestContext.setDeviceId(DataGenerator.randomDeviceId());
    }
    public static Map<String,String> getDefaultHeadersForRemittance()
    {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("user_type", "PRIMARY");
        headers.put("Source", "REMITTANCE");
        headers.put("customer-id",TestContext.getUserOtpResponse().getUser().getCustomerId());
        headers.put("isTokenRotationON","true");
        headers.put("Nb-Sso-Enabled","true");
        headers.put("User-Agent", "IOS Darwin");
        headers.put("link-token",TestContext.getLinktoken().getLinkToken());
        return  headers;

    }





    public static Map<String,String> getDefaultHeadersForTimesclubForNewUser()
    {

        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("User-Agent", "IOS Darwin");
        requestHeaders.put("device-id", TestContext.getDeviceId());


        return  requestHeaders;

    }


    public static Map<String,String> getDefaultHeadersForTimesclub()
    {
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        requestHeaders.put("User-Agent", "IOS Darwin");
        requestHeaders.put("device-id", TestContext.getDeviceId());
        requestHeaders.put("isTokenRotationON","true");
        requestHeaders.put("Nb-Sso-Enabled", "true");
        requestHeaders.put("Authorization", "Bearer "+TestContext.getUserOtpResponse().getToken());

        return  requestHeaders;

    }


    public static Map<String,String> getDefaultHeadersForPublicApi()
    {
        Map<String, String> requestHeaders = new HashMap<>();
        requestHeaders.put("Content-Type", "application/json");
        return  requestHeaders;

    }


    public static Map<String,String> getDefaultHeadersForRemittanceWithBearerToken()
    {
        Map<String, String> headers = new HashMap<>();
        headers.put("content-type", "application/json");
        headers.put("user_type", "PRIMARY");
        headers.put("source", "REMITTANCE");
        headers.put("customer-id",TestContext.getUserOtpResponse().getUser().getCustomerId());
        headers.put("isTokenRotationON","true");
        headers.put("Nb-Sso-Enabled","true");
        headers.put("User-Agent", "IOS Darwin");
        headers.put("authorization","Bearer "+TestContext.getLinktoken().getJwtToken());
        headers.put("device-id", TestContext.getDeviceId());
        return  headers;

    }


}
