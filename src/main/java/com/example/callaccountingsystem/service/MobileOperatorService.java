package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.MobileOperatorEntity;
import com.example.callaccountingsystem.domain.dto.MobileOperator;
import com.example.callaccountingsystem.domain.mapping.MobileOperatorMapper;
import com.example.callaccountingsystem.repository.MobileOperatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileOperatorService implements MobileOperatorServiceInterface {
    private final MobileOperatorRepository repository;
    private final MobileOperatorMapper mapper;

    public MobileOperatorService(MobileOperatorRepository repository, MobileOperatorMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<MobileOperator> getAllMobileOperators() {
        final List<MobileOperatorEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
