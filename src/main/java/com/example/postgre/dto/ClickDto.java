package com.example.postgre.dto;

import com.example.postgre.enums.ClickType;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class ClickDto {

    private Long id;
    private ClickType clickType;
}
