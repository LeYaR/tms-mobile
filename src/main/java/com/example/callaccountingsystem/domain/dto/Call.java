package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
@AllArgsConstructor
public class Call {
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime date;
    private Subscriber incomingSubscriber;
    private Subscriber outgoingSubscriber;
    private LocalTime duration;
    private Tower tower;
    private Status status;
}
