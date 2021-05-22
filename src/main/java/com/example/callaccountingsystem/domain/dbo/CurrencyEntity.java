package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "currency")
public class CurrencyEntity {
    @Id
    @Column(name = "numerical_code")
    private Integer numericalCode;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private List<CountryEntity> countryEntityList;

    private String code;
}
