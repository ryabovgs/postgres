package com.example.postgre.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "role")
public class Role {

    @Id
    @Column("id")
    private Long id;

    private Customer customer;
}