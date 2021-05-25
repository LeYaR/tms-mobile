package com.example.callaccountingsystem.domain.dto;

import com.example.callaccountingsystem.domain.dbo.CountryEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {
    private Integer numericalCode;
    private String name;
    private List<Country> countries;
    private String code;
}
