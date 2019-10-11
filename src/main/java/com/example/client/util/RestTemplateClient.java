package com.example.client.util;

import com.example.client.filter.JwtFilter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
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

  @Bean
  public FilterRegistrationBean<JwtFilter> loggingFilter() {
    FilterRegistrationBean<JwtFilter> registrationBean = new FilterRegistrationBean<>();

    registrationBean.setFilter(new JwtFilter());
    registrationBean.addUrlPatterns("/address/*");
    registrationBean.addUrlPatterns("/client-service/*");

    return registrationBean;
  }
}
