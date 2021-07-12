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
@Table(name = "mobile_operator")
public class MobileOperatorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String operator;
    private Integer code;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "mobile_operator_country", joinColumns = @JoinColumn(name = "mobile_operator_id"),
            inverseJoinColumns = @JoinColumn(name = "country_id"))
    private List<CountryEntity> countries;

    @OneToMany(mappedBy = "mobileOperator")
    private List<SubscriberEntity> subscribers;
}
