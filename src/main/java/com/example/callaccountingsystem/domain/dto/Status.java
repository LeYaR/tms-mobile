package com.example.callaccountingsystem.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Status {
    private Integer code;
    private String status;
    private List<Call> calls;
}
