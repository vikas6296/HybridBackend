package abound.adapters.http;

import abound.clients.NeobankUserClient;
import abound.clients.UserClient;
import java.util.HashMap;
import java.util.Map;

import static abound.adapters.http.AdapterType.*;

public class AdapterRegistry
{
    private static final Map<AdapterType, HttpClientAdapter<?>> registry = new HashMap<>();

    static {
        UserClient userClient = new UserClient();
        NeobankUserClient neobankUserClient = new NeobankUserClient();

        register(USER_SIGNUP, new UserSignupAdapter(userClient));
        register(USER_OTP, new UserOtpAdapter(userClient));
        register(GET_PUBLIC_TOKEN,new CreateTokenAdapter(userClient));
        register(GET_LINK_TOKEN,new GetLinkTokenAdapter(neobankUserClient));


        // Add more here as needed
    }

    public static <T> void register(AdapterType a, HttpClientAdapter<T> adapter) {
        registry.put(a, adapter);
    }

    @SuppressWarnings("unchecked")
    public static <T> HttpClientAdapter<T> getAdapter(AdapterType a) {
        HttpClientAdapter<T> adapter = (HttpClientAdapter<T>) registry.get(a);
        if (adapter == null) {
            throw new IllegalArgumentException("No adapter registered for: " + a.name());
        }
        return adapter;
    }

}
