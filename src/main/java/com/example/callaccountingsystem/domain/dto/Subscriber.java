package com.example.callaccountingsystem.domain.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Subscriber {
    private Long phoneNumber;
    private String lastName;
    private String firstName;
    private Passport passport;
    private Address address;
    private Contract contract;
    private MobileOperator mobileOperator;
    private String email;
    private LocalDate birthday;

}
