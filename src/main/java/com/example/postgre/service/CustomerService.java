package com.example.postgre.service;

import com.example.postgre.dto.CustomerDto;
import com.example.postgre.entity.Customer;
import com.example.postgre.mapper.CustomerMapper;
import com.example.postgre.repository.CustomerRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;

@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Service
public class CustomerService {

    CustomerRepository customerRepository;
    EntityManagerFactory entityManagerFactory;
    CustomerMapper customerMapper;


    public List<CustomerDto> getAll() {
        return customerRepository.findAll().stream()
                .peek(customer -> {
                    System.out.println(customer);
                })
                .map(customerMapper::map)
                .toList();
    }

    public CustomerDto getByIdWithPlainQuery(Long id) {
        Query jpqlQuery = getEntityManager().createQuery("SELECT c FROM Customer c WHERE c.id=:id");
        jpqlQuery.setParameter("id", id);
        var customer = (Customer) jpqlQuery.getSingleResult();
        return customerMapper.map(customer);
    }

    private EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
