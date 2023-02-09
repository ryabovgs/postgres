package com.example.postgre.service.customer;

import com.example.postgre.dto.CustomerDto;
import reactor.core.publisher.Flux;

public interface CustomerService {

    Flux<CustomerDto> getAll();

    void save(String firstName, String lastName);
}
