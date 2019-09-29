package com.example.client.gateway;



import com.example.client.model.Customer;
import org.springframework.http.ResponseEntity;

public interface ClientService {

  ResponseEntity clientCreation(String ClientId);

    ResponseEntity insertAddress(Customer address);
}
