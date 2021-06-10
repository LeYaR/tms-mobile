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
@Table(name = "address")
public class AddressEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "street_id")
    private StreetEntity street;

    private String house;
    private String flat;

    @OneToMany(mappedBy = "address", orphanRemoval = true)
    private List<SubscriberEntity> subscribers;
}
