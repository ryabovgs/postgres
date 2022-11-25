package com.example.postgre.controller;

import com.example.postgre.dto.CustomerDto;
import com.example.postgre.entity.Customer;
import com.example.postgre.service.CustomerService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/customers", produces = APPLICATION_JSON_VALUE)
public class CustomerController {

    CustomerService customerService;

    @GetMapping
    public List<CustomerDto> getAll(){
        return customerService.getAll();
    }

    @GetMapping("/{id}")
    public CustomerDto getById(@PathVariable Long id) {
        return customerService.getByIdWithPlainQuery(id);
    }
}
