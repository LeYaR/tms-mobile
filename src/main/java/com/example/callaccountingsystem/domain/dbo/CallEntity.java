package com.example.callaccountingsystem.domain.dbo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "calls")
public class CallEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "incoming_phone_number")
    private SubscriberEntity incomingSubscriber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "outgoing_phone_number")
    private SubscriberEntity outgoingSubscriber;

    private LocalTime duration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tower_id")
    private TowerEntity tower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_code")
    private StatusEntity status;
}
