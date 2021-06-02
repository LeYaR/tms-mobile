package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.PricingUnitEntity;
import com.example.callaccountingsystem.domain.dto.PricingUnit;
import com.example.callaccountingsystem.domain.mapping.PricingUnitMapper;
import com.example.callaccountingsystem.repository.PricingUnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingUnitService implements PricingUnitServiceInterface {

    private final PricingUnitRepository repository;
    private final PricingUnitMapper mapper;

    public PricingUnitService(PricingUnitRepository repository, PricingUnitMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<PricingUnit> getAllPricingUnits() {
        final List<PricingUnitEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
