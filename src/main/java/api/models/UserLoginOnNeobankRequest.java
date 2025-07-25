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
@AllArgsConstructor
@ToString
public class UserLoginOnNeobankRequest
{
    @JsonProperty("loginType")
    private String loginType;

    @JsonProperty("token")
    private String token ;


}
