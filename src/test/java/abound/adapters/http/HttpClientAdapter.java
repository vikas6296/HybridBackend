package abound.adapters.http;


import api.models.UserOtpTcRequest;
import io.restassured.response.Response;

public interface HttpClientAdapter<W> {
    Response execute(W requestObject);


}
