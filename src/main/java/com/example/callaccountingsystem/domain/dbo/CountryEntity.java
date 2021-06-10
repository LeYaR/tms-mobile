package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "country")
public class CountryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String country;

    @OneToMany(mappedBy = "country")
    private List<CityEntity> cities;

    @ManyToMany(mappedBy = "countryList")
    private List<CurrencyEntity> currencies;

    @ManyToMany(mappedBy = "countries")
    private List<MobileOperatorEntity> mobileOperators;
}
