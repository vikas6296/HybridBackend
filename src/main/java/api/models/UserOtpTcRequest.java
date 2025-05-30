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
public class UserOtpTcRequest
{
    @JsonProperty("message_id")
    String messageId;
    @JsonProperty("mobile_number")
    String mobileNumber;
    @JsonProperty("otp")
    String otp;
    @JsonProperty("verify_otp_type")
    String verifyOtpLogin;

}
