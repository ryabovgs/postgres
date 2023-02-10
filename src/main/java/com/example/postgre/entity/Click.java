package com.example.postgre.entity;

import com.example.postgre.enums.ClickType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Table(name = "click")
public final class Click {

    @Id
    private Long id;

    @Column("click_type")
    private ClickType clickType;

    @Column("creation_date")
    private LocalDateTime creationDate;
}
