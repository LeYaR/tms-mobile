package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Contract {
    private String number;
    private LocalDate date;
    private ClientType clientType;
    private TariffPlan tariffPlan;
    private Integer discount;
    private Subscriber subscriber;
}
