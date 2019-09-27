package com.example.client.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client-service")
public class ClientController {

  private final Logger LOGGER = LoggerFactory.getLogger(ClientController.class);

  @GetMapping(value = "/{clientId}")
  public String clientCreation(@PathVariable String clientId) {
    LOGGER.info("checking clientId::::{}", clientId);

    return "Hello client service";
  }
}
