package com.example.postgre.repository;

import com.example.postgre.dto.CustomerReport;
import com.example.postgre.entity.Customer;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;

public interface CustomerRepository extends R2dbcRepository<Customer, Long> {

    @Query("SELECT first_name, count(*) FROM customer WHERE last_name = :lastname GROUP BY first_name LIMIT 10")
    Flux<CustomerReport> findTop10(String lastname);
}
