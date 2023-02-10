package com.example.postgre.mapper;

import com.example.postgre.dto.ClickDto;
import com.example.postgre.entity.Click;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClickMapper {

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "clickType")
    Click fromDto(ClickDto clickDto);
}
