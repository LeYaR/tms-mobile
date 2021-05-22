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
    private LocalDateTime date;
    private List<Subscriber> incomingSubscriberList;
    private List<Subscriber> outgoingSubscriberList;
    private LocalTime duration;
    private Tower tower;
    private Status status;
}
