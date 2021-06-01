package com.example.callaccountingsystem.domain.dto;

import lombok.Data;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class Call {
    private Long id;
    private LocalDateTime date;
    private Subscriber incomingSubscriber;
    private Subscriber outgoingSubscriber;
    private LocalTime duration;
    private Tower tower;
    private Status status;
}
