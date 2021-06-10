package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Status;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StatusServiceInterface {

    Page<Status> getAllStatuses(int currentPage, int pageSize);

    List<Integer> getAllListStatusCode();

    Status get(Integer code);

    void save(Status status);

}
