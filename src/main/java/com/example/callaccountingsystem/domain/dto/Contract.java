package com.example.callaccountingsystem.domain.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class Contract {
    private Long id;
    private String number;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
    private ClientType clientType;
    private TariffPlan tariffPlan;
    private Integer discount;
}
