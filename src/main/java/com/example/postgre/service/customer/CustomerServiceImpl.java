package com.example.postgre.service.customer;

import com.example.postgre.dto.CustomerDto;
import com.example.postgre.entity.Customer;
import com.example.postgre.mapper.CustomerMapper;
import com.example.postgre.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    CustomerRepository customerRepository;
    CustomerMapper customerMapper;


    @Override
    public Flux<CustomerDto> getAll() {
        return customerRepository.findAll()
                .map(customerMapper::mapToDto);
    }

    @Override
    public Mono<Customer> add(String firstName, String lastName) {
        var customerDto = CustomerDto.builder().firstName(firstName).lastName(lastName).build();
        return customerRepository.save(customerMapper.mapFromDto(customerDto));
    }
}
