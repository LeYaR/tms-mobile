package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class PricingUnitEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String unit;

    @OneToMany(mappedBy = "pricingUnitEntity")
    private List<TariffPlanEntity> tariffPlanEntities;
}
