package com.example.client.helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class IntegrationHelper {

  @Autowired
  private RestTemplate restTemplate;

  public String getAddress() {

    return restTemplate.getForObject("http://localhost:8080/client-service/12345", String.class);
  }
}
