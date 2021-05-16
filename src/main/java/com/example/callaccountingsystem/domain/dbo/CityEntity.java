package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class CityEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private CountryEntity countryEntity;

    @OneToMany(mappedBy = "locationCity")
    private List<TowerEntity> towerEntities;

    @OneToMany(mappedBy = "cityEntity")
    private List<StreetEntity> streetEntities;
}