package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TariffPlan {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal abonentPayment;
    private PricingUnit pricingUnit;
    private BigDecimal price;
    private Currency currency;
}
