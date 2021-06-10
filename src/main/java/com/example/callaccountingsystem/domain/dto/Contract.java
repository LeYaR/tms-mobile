package com.example.callaccountingsystem.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Contract {
    private Long id;
    private String number;
    private LocalDate date;
    private ClientType clientType;
    private TariffPlan tariffPlan;
    private Integer discount;
}
