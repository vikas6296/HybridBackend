package abound.apitests;

import abound.clients.UserClient;
import api.builders.PublicTokenRequestBuilder;
import api.models.AddBankRequest;
import api.models.AddBankResponse;
import api.models.PublicTokenForAddBankRequest;
import api.models.PublicTokenForAddBankResponse;
import api.utils.TestContext;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utils.PrintUtil;

public class TokenCreateAndBankAdd {

    @Test
    public void createPublicTokenTest() {


    PublicTokenForAddBankRequest publicToken = PublicTokenRequestBuilder.defaultRequest();

    UserClient uc = new UserClient();
    Response response = uc.createPublicTokenForBankAdd(publicToken);

    PublicTokenForAddBankResponse publicTokenResponse = response.as(PublicTokenForAddBankResponse.class);
    System.out.println(publicTokenResponse.toString());

    TestContext.setPublicTokenContextRequest(publicToken);
    TestContext.publicTokenForAddBankResponse(publicTokenResponse);

}

@Test(dependsOnMethods = "createPublicTokenTest" )
    public void addBankForUser() throws JsonProcessingException {
    AddBankRequest addBank = new AddBankRequest();
    addBank.setPublicToken(TestContext.publicTokenResponse().getPublicToken());

    UserClient uc = new UserClient();
    Response response = uc.addBankForUser(addBank);
    System.out.println("response-->" +response.asString());

   /* ObjectMapper mapper = new ObjectMapper();
    AddBankResponse adbResponse = mapper.readValue(response.getBody().asString(), AddBankResponse.class);*/


    AddBankResponse adbResponse = response.as(AddBankResponse.class);
    System.out.println(adbResponse.toString());
    PrintUtil.printOperation(adbResponse);

    TestContext.setAddBankRequestContext(addBank);
    TestContext.setAddBankResponseContext(adbResponse);

}




}
