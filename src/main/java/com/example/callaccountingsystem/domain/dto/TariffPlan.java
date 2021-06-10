package com.example.callaccountingsystem.domain.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TariffPlan {
    private Integer id;
    private String name;
    private String description;
    private BigDecimal abonentPayment;
    private PricingUnit pricingUnit;
    private BigDecimal price;
    private Currency currency;
}
