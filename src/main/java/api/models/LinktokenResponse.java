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
public class LinktokenResponse
{

    @JsonProperty("linkToken")
    private String linkToken;

    @JsonProperty("expiration")
    private String expiration;

    @JsonProperty("requestId")
    private String requestId;

    @JsonProperty("bankAddType")
    private String bankAddType;

    @JsonProperty("accountsPending")
    private boolean accountsPending;

    @JsonProperty("pendingBanks")
    private String pendingBanks;

    @JsonProperty("jwt_token")
    private String jwtToken;

    @JsonProperty("sso_token")
    private String ssoToken;

    @JsonProperty("is_user_signed_up")
    private boolean isUserSignedUp;

    @JsonProperty("user_opted_in_remittance")
    private boolean userOptedInRemittance;

    @JsonProperty("user_opted_in_banking")
    private boolean userOptedInBanking;

    @JsonProperty("kyc_approved")
    private boolean kycApproved;

    @JsonProperty("success")
    private boolean success;

    @Override
    public String toString() {
        return "LinkTokenResponse{" +
                "linkToken='" + linkToken + '\'' +
                ", expiration='" + expiration + '\'' +
                ", requestId='" + requestId + '\'' +
                ", bankAddType='" + bankAddType + '\'' +
                ", accountsPending=" + accountsPending +
                ", pendingBanks='" + pendingBanks + '\'' +
                ", jwtToken='" + jwtToken + '\'' +
                ", ssoToken='" + ssoToken + '\'' +
                ", isUserSignedUp=" + isUserSignedUp +
                ", userOptedInRemittance=" + userOptedInRemittance +
                ", userOptedInBanking=" + userOptedInBanking +
                ", kycApproved=" + kycApproved +
                ", success=" + success +
                '}';
    }
}
