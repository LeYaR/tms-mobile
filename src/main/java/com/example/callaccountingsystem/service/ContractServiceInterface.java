package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Contract;
import org.springframework.data.domain.Page;

public interface ContractServiceInterface {

    Page<Contract> getAllContracts(int currentPage, int pageSize);

    Contract get(Long id);

    void save(Contract contract);

}
