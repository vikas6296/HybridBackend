package abound.factories;

import abound.adapters.http.AdapterRegistry;
import abound.adapters.http.AdapterType;
import abound.adapters.http.HttpClientAdapter;
import abound.clients.ClientType;
import abound.clients.UserClient;

public class ClientFactory
{
  public static  <T> HttpClientAdapter <T> getClient(ClientType type , AdapterType a)
  {
      switch(type)
      {
          case USER :
          case BANK:
              return  AdapterRegistry.getAdapter(a);
          default : throw new IllegalArgumentException("Unknown client type: " + type);
      }


  }


}
