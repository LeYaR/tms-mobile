package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String country;

    @OneToMany(mappedBy = "countryEntity")
    private List<CityEntity> cityEntities;

    @ManyToMany(mappedBy = "countryEntityList")
    private List<CurrencyEntity> currencyEntities;
}
