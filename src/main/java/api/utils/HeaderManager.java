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




}
