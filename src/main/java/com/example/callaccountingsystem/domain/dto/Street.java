package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Street {
    private Long id;
    private String street;
    private City city;
}
