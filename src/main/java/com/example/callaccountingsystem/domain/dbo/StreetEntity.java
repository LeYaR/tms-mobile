package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class StreetEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String street;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "city_id")
    private CityEntity cityEntity;

    @OneToMany(mappedBy = "streetEntity", orphanRemoval = true)
    private List<AddressEntity> addressEntities;
}
