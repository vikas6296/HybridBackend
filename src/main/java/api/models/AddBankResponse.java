package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
@Data
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@ToString
public class AddBankResponse
{

    private String message;

    private List<Object> details;

    @JsonProperty("is_rewarded")
    private boolean isRewarded;

    @JsonProperty("isPending")
    private boolean isPending;

    @JsonProperty("bank_add_request_id")
    private String bankAddRequestId;

    private boolean success;

    @Override
    public String toString() {
        return "BankAddConflictResponse{" +
                "message='" + message + '\'' +
                ", details=" + details +
                ", isRewarded=" + isRewarded +
                ", isPending=" + isPending +
                ", bankAddRequestId='" + bankAddRequestId + '\'' +
                ", success=" + success +
                '}';
    }

}
