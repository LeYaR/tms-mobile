package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.time.LocalDate;

@Getter
@Setter
@Entity
public class PassportEntity {
    @Id
    private String idNumber;
    private String seriesNumber;
    private LocalDate date;
    private String issuer;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passportEntity")
    private SubscriberEntity subscriberEntity;
}
