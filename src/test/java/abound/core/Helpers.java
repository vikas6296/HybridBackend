package abound.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.config.HttpClientConfig;
import io.restassured.config.RestAssuredConfig;

import java.util.Map;

public class Helpers {

    public static Map<String, Object> convertPojoToMap(Object pojo) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(pojo, Map.class);
    }

    public static void configureTimeouts() {
        RestAssured.config = RestAssuredConfig.config().httpClient(
                HttpClientConfig.httpClientConfig()
                        .setParam("http.connection.timeout", 5000)        // Time to establish connection
                        .setParam("http.socket.timeout", 5000)            // Time waiting for data
                        .setParam("http.connection.request.timeout", 5000) // Time to get connection from pool
        );

    }
}
