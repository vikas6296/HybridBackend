package abound.core;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class Helpers
{

    public static Map<String, Object> convertPojoToMap(Object pojo) {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(pojo, Map.class);
    }
}
