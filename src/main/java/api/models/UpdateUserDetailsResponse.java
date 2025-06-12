package api.models;

import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@ToString
public class UpdateUserDetailsResponse
{
    private Map<String, Object> unknownFields = new HashMap<>();

    @JsonAnySetter
    public void handleUnknown(String key, Object value) {
        unknownFields.put(key, value);
    }

    public Map<String, Object> getUnknownFields() {
        return unknownFields;
    }
}
