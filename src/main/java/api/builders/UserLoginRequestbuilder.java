package api.builders;

import api.models.UserLoginOnNeobankRequest;

public class UserLoginRequestbuilder
{
    private String loginType = "OTP";

    private String token = "NULL";

    public UserLoginRequestbuilder withLoginType(String otp)
    {
        this.loginType = otp;
        return this;
    }

    public UserLoginRequestbuilder withToken(String token)
    {
        this.token = token;
        return this;
    }

    public UserLoginOnNeobankRequest build()
    {

        return new UserLoginOnNeobankRequest(loginType,token);

    }



}
