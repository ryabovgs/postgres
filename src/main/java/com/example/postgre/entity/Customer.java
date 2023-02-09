package com.example.postgre.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.LinkedHashSet;
import java.util.Set;

//@Entity
@Getter
@Setter
@ToString
@Table(name = "customer")
public final class Customer {

    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column("first_name")
    private String firstName;

    @Column("last_name")
    private String lastName;

//    @OneToMany(mappedBy = "customer", orphanRemoval = true, fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SUBSELECT)
    private Set<Role> roles = new LinkedHashSet<>();

}
