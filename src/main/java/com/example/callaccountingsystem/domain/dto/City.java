package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class City {
    private String city;
    private Country country;
    private List<Tower> towerList;
    private List<Street> streetList;
}
