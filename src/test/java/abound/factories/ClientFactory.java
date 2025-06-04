package abound.factories;

import abound.adapters.http.HttpClientAdapter;
import abound.adapters.http.UserClientAdapter;
import abound.clients.ClientType;
import abound.clients.UserClient;

import static abound.clients.ClientType.USER;

public class ClientFactory
{
  public static HttpClientAdapter<?> getClient(ClientType type)
  {
      switch(type)
      {
          case USER : return  new UserClientAdapter(new UserClient());
          default : throw new IllegalArgumentException("Unknown client type: " + type);
      }

  }

}
