package com.example.postgre.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

//@Entity
@Getter
@Setter
@Table(name = "role")
public class Role {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_seq")
//    @SequenceGenerator(name = "role_seq")
    @Column("id")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "customer_id")
    private Customer customer;
}