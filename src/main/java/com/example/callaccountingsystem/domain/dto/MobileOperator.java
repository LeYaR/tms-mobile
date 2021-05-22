package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileOperator {
    private String operator;
    private Integer code;
    private List<Country> countryList;
    private List<Subscriber> subscriberList;
}
