package com.example.postgre.dto;

import com.example.postgre.enums.ClickType;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
public final class ClickReport {

    private ClickType clickType;

    private int count;

    private LocalDate date;
}
