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
public class UserOtpTcResponse
{
   @JsonProperty("message")
    String message;

   @JsonProperty("user")
    UserRequest user;

   @JsonProperty("remittance_redemption_enabled")
    String remittanceRedemptionEnabled;

   @JsonProperty("token")
    String token;




    @Override
    public String toString()
    {
        return "UserOtpTcResponse{" +
                "message= '" + message+"' ,  token = '" +token +"' "+"customerId"+user.getCustomerId()+"}";
    }

}
