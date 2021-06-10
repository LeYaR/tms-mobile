package com.example.callaccountingsystem.domain.dto;

import lombok.Data;

@Data
public class Street {
    private Long id;
    private String street;
    private City city;
}
