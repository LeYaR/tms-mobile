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

    public MobileOperatorService(MobileOperatorRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<MobileOperator> getAllMobileOperators() {
        final List<MobileOperatorEntity> list = repository.findAll();
        return MobileOperatorMapper.MOBILE_OPERATOR_MAPPER.listFromDbo(list);
    }

}
