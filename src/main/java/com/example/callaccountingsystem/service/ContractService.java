package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.ContractEntity;
import com.example.callaccountingsystem.domain.dto.Contract;
import com.example.callaccountingsystem.domain.mapping.ContractMapper;
import com.example.callaccountingsystem.repository.ContractRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ContractService implements ContractServiceInterface {

    private final ContractRepository repository;
    private final ContractMapper mapper;

    public ContractService(ContractRepository repository, ContractMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<Contract> getAllContracts(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<ContractEntity> page = repository.findAll(pageable);
        return page.map(contractEntity -> (mapper.fromDbo(contractEntity)));
    }

}
