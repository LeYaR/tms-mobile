package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileOperator {
    private Long id;
    private String operator;
    private Integer code;
}
