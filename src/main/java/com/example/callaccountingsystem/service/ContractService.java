package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.ContractEntity;
import com.example.callaccountingsystem.domain.dto.Contract;
import com.example.callaccountingsystem.domain.mapping.ContractMapper;
import com.example.callaccountingsystem.repository.IContractRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContractService implements IContract{

    private final IContractRepo repository;

    public ContractService(IContractRepo repository){this.repository=repository;}

    @Override
    public List<Contract> getAllContracts(){
        final List<ContractEntity> list = repository.findAll();
        List<Contract> contracts = new ArrayList<>();
        list.forEach((contractEntity -> contracts.add(ContractMapper.CONTRACT_MAPPER.fromDbo(contractEntity))));
        return contracts;
    }

}
