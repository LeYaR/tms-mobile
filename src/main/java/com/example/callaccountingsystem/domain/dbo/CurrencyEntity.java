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
@Table(name = "currency")
public class CurrencyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "numerical_code")
    private Integer numericalCode;
    private String name;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "currency_country", joinColumns = @JoinColumn(name = "currency_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private List<CountryEntity> countryList;

    private String code;
}
