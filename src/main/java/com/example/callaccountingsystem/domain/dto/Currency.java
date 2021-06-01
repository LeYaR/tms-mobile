package com.example.callaccountingsystem.domain.dto;

import lombok.Data;

@Data
public class Currency {
    private Long id;
    private Integer numericalCode;
    private String name;
    private String code;
}
