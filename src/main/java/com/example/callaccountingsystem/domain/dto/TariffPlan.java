package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffPlan {
    private String name;
    private String description;
    private Integer abonentPayment;
    private PricingUnit pricingUnit;
    private BigDecimal price;
    private Currency currency;
    private List<Contract> contractList;
}
