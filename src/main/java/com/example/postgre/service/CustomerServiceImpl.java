package com.example.postgre.service;

import com.example.postgre.dto.CustomerDto;
import com.example.postgre.mapper.CustomerMapper;
import com.example.postgre.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
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
    public void save(String firstName, String lastName) {
        var customerDto = CustomerDto.builder().firstName(firstName).lastName(lastName).build();
        customerRepository.save(customerMapper.mapFromDto(customerDto))
                .subscribe(System.out::println);
    }
}
