package abound.clients;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class BaseClient
{

    private static RequestSpecification getRequestSpecification(String endPoint, Object requestPayload, Map<String,String> headers) {
        return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON)
                .body(requestPayload);
    }

    private static RequestSpecification getRequestSpecification(String endPoint, Map<String,String> headers) {
        return RestAssured.given()
                .baseUri(endPoint)
                .headers(headers)
                .contentType(ContentType.JSON);

    }

    public static Response performPost(String endPoint, Object requestPayloadAsPojo, Map<String,String>headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayloadAsPojo, headers);
        Response response =  requestSpecification.post();

        return response;
    }


    public static Response performPost(String endPoint, String requestPayload, Map<String,String>headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint, requestPayload, headers);
        Response response =  requestSpecification.post();

        return response;
    }


    public static Response performDelete(String endPoint, Map<String,String>headers) {
        RequestSpecification requestSpecification = getRequestSpecification(endPoint,headers);
        Response response =  requestSpecification.delete();

        return response;
    }

}
