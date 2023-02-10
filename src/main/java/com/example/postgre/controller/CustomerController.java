package com.example.postgre.controller;

import com.example.postgre.dto.CustomerDto;
import com.example.postgre.entity.Customer;
import com.example.postgre.service.customer.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/customers", produces = APPLICATION_JSON_VALUE)
public class CustomerController {

    CustomerService customerService;

    @GetMapping
    public Flux<CustomerDto> getAll() {
        return customerService.getAll();
    }

    @PostMapping
    public Mono<Customer> save(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName) {
        return customerService.add(firstName, lastName);
    }
}
