package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false,fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "street_id")
    private StreetEntity street;

    private String house;
    private String flat;

    @OneToMany(mappedBy = "addressEntity", orphanRemoval = true)
    private List<SubscriberEntity> subscribers;
}
