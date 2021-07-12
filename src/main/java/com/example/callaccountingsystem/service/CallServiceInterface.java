package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Call;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CallServiceInterface {

    Page<Call> getAllCalls(int currentPage, int pageSize);

    int getQuantityPages(int pageSize);

    void saveListCalls(List<Call> list);

}