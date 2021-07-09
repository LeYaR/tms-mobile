package com.example.callaccountingsystem.domain.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

}
