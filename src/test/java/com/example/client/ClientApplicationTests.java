package com.example.client;

import com.example.client.model.Personal;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientApplicationTests {
  @Autowired TestRestTemplate testRestTemplate;

  @MockBean
  @Qualifier("proxyDisabled")
  RestTemplate restTemplate;

  @MockBean FilterRegistrationBean filterRegistrationBean;

  @Test
  public void clientCreation() {

    Mockito.when(
            restTemplate.getForObject("http://localhost:8080/client-service/12345", String.class))
        .thenReturn("Helloworld");

    ResponseEntity<String> rm = testRestTemplate.getForEntity("/address/12345", String.class);
    Assert.assertEquals("Helloworld", rm.getBody());
  }
}
