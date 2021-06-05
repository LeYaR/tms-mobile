package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Call;
import org.springframework.data.domain.Page;

public interface CallServiceInterface {

    Page<Call> getAllCalls(int currentPage, int pageSize);

}
