package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subscriber {
    private Long phoneNumber;
    private String lastName;
    private String firstName;
    private String middleName;
    private Passport passport;
    private Address address;
    private Contract contract;
    private MobileOperator mobileOperator;
    private String email;
    private LocalDate birthday;
    private List<Call> incomingCalls;
    private List<Call> outgoingCalls;
}
