package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PublicTokenForAddBankResponse
{

    @JsonProperty("public_token")
    private String publicToken;

    @JsonProperty("request_id")
    private String requestId;

    @Override
    public String toString() {
        return "PublicTokenCreateResponse{" +
                "publicToken='" + publicToken + '\'' +
                ", requestId='" + requestId + '\'' +
                '}';
    }

}
