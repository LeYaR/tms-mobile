package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "passport")
public class PassportEntity {
    @Id
    @Column(name = "id_number")
    private String idNumber;
    @Column(name = "series_number")
    private String seriesNumber;
    private LocalDate date;
    private String issuer;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "passportEntity")
    private SubscriberEntity subscriberEntity;
}
