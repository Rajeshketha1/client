package com.example.client.controller;


import com.example.client.gateway.AddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController {
  private final Logger LOGGER = LoggerFactory.getLogger(AddressController.class);

  @Autowired
  private AddressService addressService;

  @GetMapping(value = "/{clientId}")
  public Object clientCreation(@PathVariable String clientId) {
    LOGGER.info("checking clientId::::" + clientId);

    return addressService.createAddress();
  }
}
