package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileOperator {
    private Integer id;
    private String operator;
    private Integer code;
    private List<Country> countries;
    private List<Subscriber> subscribers;
}
