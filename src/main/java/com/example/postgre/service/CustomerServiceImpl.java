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
//    EntityManagerFactory entityManagerFactory;
    CustomerMapper customerMapper;


    @Override
    public Flux<CustomerDto> getAll() {
        return customerRepository.findAll()
                .map(customerMapper::map);
    }

//    @Override
//    public Mono<List<CustomerDto>> getAll() {
//        return customerRepository.findAll()
//                .map(customerMapper::map)
//                .collectList();
//    }

    @Override
    public CustomerDto getByIdWithPlainQuery(Long id) {
        return null;
//        Query jpqlQuery = getEntityManager().createQuery("SELECT c FROM Customer c WHERE c.id=:id");
//        jpqlQuery.setParameter("id", id);
//        var customer = (Customer) jpqlQuery.getSingleResult();
//        return customerMapper.map(customer);
    }

//    private EntityManager getEntityManager() {
//        return entityManagerFactory.createEntityManager();
//    }
}
