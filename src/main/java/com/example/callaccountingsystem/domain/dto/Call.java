package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Call {
    private Long id;
    private LocalDateTime date;
    private List<Subscriber> incomingSubscribers;
    private List<Subscriber> outgoingSubscribers;
    private LocalTime duration;
    private Tower tower;
    private Status status;
}
