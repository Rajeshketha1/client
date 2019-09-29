package com.example.client.util;


import com.example.client.model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateUtil {

  private RestTemplateUtil() {}

  public static ResponseEntity getRestTemplate(String url, Customer customer) {
    RestTemplate rs = new RestTemplate();
    return rs.postForEntity(url, customer, Customer.class);
  }

  public static RestTemplate restTemplate() {
    return new RestTemplate();
  }
}
