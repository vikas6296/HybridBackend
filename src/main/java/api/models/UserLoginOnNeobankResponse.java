package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@ToString
public class UserLoginOnNeobankResponse
{
    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("messageId")
    private String messageId;

    @JsonProperty("userSignUpStatus")
    private String userSignUpStatus;

    @JsonProperty("userType")
    private String userType;

    @JsonProperty("newUserLogin")
    private boolean newUserLogin;

    @JsonProperty("layer2MigrationRequired")
    private boolean layer2MigrationRequired;

    @JsonProperty("success")
    private boolean success;


}
