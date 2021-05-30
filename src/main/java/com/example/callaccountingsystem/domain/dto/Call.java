package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Call {
    private Long id;
    private LocalDateTime date;
    private Subscriber incomingSubscriber;
    private Subscriber outgoingSubscriber;
    private LocalTime duration;
    private Tower tower;
    private Status status;
}
