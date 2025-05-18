package api.builders;

import api.models.PublicTokenForAddBankRequest;

import java.util.Collections;
import java.util.List;

public class PublicTokenRequestBuilder
{

    private String clientId = "5d02356c84b198001367525a";
    private String secret = "937a0063d953f9539c20afe0f7df3f";
    private String institutionId = "ins_33";
    private List<String> initialProducts = Collections.singletonList("transactions");
    private String overrideUsername = "custom_test31";
    private String overridePassword = "pass_good";

    public PublicTokenRequestBuilder withClientId(String clientId) {
        this.clientId = clientId;
        return this;
    }

    public PublicTokenRequestBuilder withSecret(String secret) {
        this.secret = secret;
        return this;
    }

    public PublicTokenRequestBuilder withInstitutionId(String institutionId) {
        this.institutionId = institutionId;
        return this;
    }

    public PublicTokenRequestBuilder withInitialProducts(List<String> products) {
        this.initialProducts = products;
        return this;
    }

    public PublicTokenRequestBuilder withOverrideUsername(String username) {
        this.overrideUsername = username;
        return this;
    }

    public PublicTokenRequestBuilder withOverridePassword(String password) {
        this.overridePassword = password;
        return this;
    }

    public PublicTokenForAddBankRequest build() {
        PublicTokenForAddBankRequest.Options options = new PublicTokenForAddBankRequest.Options(overrideUsername, overridePassword);
        return new PublicTokenForAddBankRequest(clientId, secret, institutionId, initialProducts, options);
    }


    public static PublicTokenForAddBankRequest defaultRequest() {
        return new PublicTokenRequestBuilder().build();
    }
}
