package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Data
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@ToString
public class UserSignupTcResponse
{
    @JsonProperty("message_id")
    private String messageId;
    private String success;

    @Override
    public String toString()
    {
        return "UserSignupTcResponse{" +
                "messageId= '" + messageId+"' ,  success = '" +success +"'}";
    }

}
