package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name="tariff_plan")
public class TariffPlanEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;

    @Column(name = "abonent_payment")
    private Integer abonentPayment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pricing_unit_id")
    private PricingUnitEntity pricingUnitEntity;

    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "currency_numerical_code")
    private CurrencyEntity currencyEntity;

    @OneToMany(mappedBy = "tariffPlanEntity", orphanRemoval = true)
    private List<ContractEntity> contractEntities;
}
