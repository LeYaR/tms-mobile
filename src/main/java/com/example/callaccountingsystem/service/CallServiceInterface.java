package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Call;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface CallServiceInterface {

    Page<Call> getAllCalls(int currentPage, int pageSize);

    void saveListCalls(List<Call> list);

    Page<Call> getAllFilterCalls(int currentPage, int pageSize, LocalDate date1, LocalDate date2, long incomingNumber,
                                 long outgoingNumber, String tower, String status);

}