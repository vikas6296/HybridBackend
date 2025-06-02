package abound.factories;

import abound.adapters.http.HttpClientAdapter;
import api.models.UserSignupTcRequest;

public interface AutomationComponentFactory
{
    HttpClientAdapter<UserSignupTcRequest> UserClientAdapter();




}
