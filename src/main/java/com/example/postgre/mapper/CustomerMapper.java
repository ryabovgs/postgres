package com.example.postgre.mapper;

import com.example.postgre.dto.CustomerDto;
import com.example.postgre.entity.Customer;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id")
    CustomerDto map(Customer customer);
}
