package com.example.callaccountingsystem.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Passport {
    private String idNumber;
    private String seriesNumber;
    private LocalDate date;
    private String issuer;
}
