package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
public class SubscriberEntity {
    @Id
    private Integer phoneNumber;
    private String lastName;
    private String firstName;
    private String middleName;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "passport_id")
    private PassportEntity passportEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private AddressEntity addressEntity;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "contract_id")
    private ContractEntity contractEntity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "mobile_operator_id")
    private MobileOperatorEntity mobileOperatorEntity;

    private String email;
    private LocalDate birthday;

    @ManyToMany(mappedBy = "incomingSubscriberEntities")
    private List<CallEntity> incomingCallEntity;

    @ManyToMany(mappedBy = "outgoingSubscriberEntities")
    private List<CallEntity> outgoingCallEntity;
}
