package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Status;
import org.springframework.data.domain.Page;

public interface StatusServiceInterface {

    Page<Status> getAllStatuses(int currentPage, int pageSize);

}
