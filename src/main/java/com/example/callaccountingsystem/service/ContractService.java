package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.ContractEntity;
import com.example.callaccountingsystem.domain.dto.Contract;
import com.example.callaccountingsystem.domain.mapping.ContractMapper;
import com.example.callaccountingsystem.repository.ContractRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService implements ContractServiceInterface {

    private final ContractRepository repository;
    private final ContractMapper mapper;

    public ContractService(ContractRepository repository, ContractMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Contract> getAllContracts() {
        final List<ContractEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
