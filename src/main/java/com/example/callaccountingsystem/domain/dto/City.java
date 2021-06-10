package com.example.callaccountingsystem.domain.dto;

import lombok.Data;

@Data
public class City {
    private Long id;
    private String city;
    private Country country;
}
