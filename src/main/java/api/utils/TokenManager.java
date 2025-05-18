package api.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class TokenManager
{
  private static final ThreadLocal<String> threadLocalToken = new ThreadLocal<>();

  public static String getToken() {
    String token = threadLocalToken.get();

    if (token == null || isExpired(token)) {
      token = generateNewToken();
      threadLocalToken.set(token);
    }

    return token;
  }

  private static String generateNewToken() {
    // Replace this logic with actual token generation (login API, static key, etc.)
    String token = "<your_jwt_here>"; // without "Bearer " prefix
    return "Bearer " + token;
  }

  private static boolean isExpired(String tokenWithBearer) {
    try {
      String token = tokenWithBearer.replace("Bearer ", "");
      DecodedJWT jwt = JWT.decode(token);
      Date expiresAt = jwt.getExpiresAt();
      return expiresAt == null || expiresAt.before(new Date());
    } catch (Exception e) {
      return true; // Assume expired if any error occurs
    }
  }

  public static void clearToken() {
    threadLocalToken.remove(); // optional, use in @AfterMethod
  }

}
