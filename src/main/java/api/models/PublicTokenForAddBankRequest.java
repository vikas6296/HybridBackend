package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class PublicTokenForAddBankRequest
{
    @JsonProperty("client_id")
    private String clientId;

    @JsonProperty("secret")
    private String secret;

    @JsonProperty("institution_id")
    private String institutionId;

    @JsonProperty("initial_products")
    private List<String> initialProducts;

    @JsonProperty("options")
    private Options options;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Options {
        @JsonProperty("override_username")
        private String overrideUsername;

        @JsonProperty("override_password")
        private String overridePassword;
    }

}
