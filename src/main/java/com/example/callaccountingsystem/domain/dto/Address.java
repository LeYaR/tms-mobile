package com.example.callaccountingsystem.domain.dto;

import lombok.Data;

@Data
public class Address {
    private Long id;
    private Street street;
    private String house;
    private String flat;
}
