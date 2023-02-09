package com.example.postgre.service;

import com.example.postgre.dto.CustomerDto;
import reactor.core.publisher.Flux;

public interface CustomerService {
    Flux<CustomerDto> getAll();

    CustomerDto getByIdWithPlainQuery(Long id);
}
