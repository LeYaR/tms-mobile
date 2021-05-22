package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "mobile_operator")
public class MobileOperatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String operator;
    private Integer code;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_id")
    private List<CountryEntity> countryEntities;

    @OneToMany(mappedBy = "mobileOperatorEntity", orphanRemoval = true)
    private List<SubscriberEntity> subscriberEntities;
}
