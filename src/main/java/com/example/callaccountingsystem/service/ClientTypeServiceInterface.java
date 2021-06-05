package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.ClientType;
import org.springframework.data.domain.Page;

public interface ClientTypeServiceInterface {

    Page<ClientType> getAllClients(int currentPage, int pageSize);

}
