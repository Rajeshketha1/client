package com.example.client.service;


import com.example.client.gateway.AddressService;
import com.example.client.helper.IntegrationHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl implements AddressService {

  @Autowired
  private IntegrationHelper integrationHelper;

  @Override
  public String createAddress() {
    return integrationHelper.getAddress();
  }
}
