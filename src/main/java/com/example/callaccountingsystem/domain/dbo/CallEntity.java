package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Getter
@Setter
@Entity
public class CallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;

    @ManyToMany
    @JoinColumn(name = "incoming_phone_number")
    private List<SubscriberEntity> incomingSubscriberEntities;

    @ManyToMany
    @JoinColumn(name = "outgoing_phone_number")
    private List<SubscriberEntity> outgoingSubscriberEntities;

    private LocalTime duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tower_id")
    private TowerEntity towerEntity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_code")
    private StatusEntity statusEntity;
}
