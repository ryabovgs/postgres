package com.example.postgre.service.customer;

import com.example.postgre.dto.CustomerDto;
import com.example.postgre.entity.Customer;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CustomerService {

    Flux<CustomerDto> getAll();

    Mono<Customer> add(String firstName, String lastName);
}
