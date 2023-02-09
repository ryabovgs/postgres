package com.example.postgre.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CustomerDto {

    private Long id;
    private String firstName;
    private String lastName;
}
