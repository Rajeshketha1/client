package com.example.client.util;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;

@Configuration
public class RestTemplateClient {
  @Bean
  @Qualifier("proxyDisabled")
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @Bean
  @Qualifier("proxyEnabled")
  public RestTemplate restTemplateWithProxy() {
    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

    Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress("my.host.com", 8080));
    requestFactory.setProxy(proxy);

    return new RestTemplate(requestFactory);
  }
}
