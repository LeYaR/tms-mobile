package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.PricingUnitEntity;
import com.example.callaccountingsystem.domain.dto.PricingUnit;
import com.example.callaccountingsystem.domain.mapping.PricingUnitMapper;
import com.example.callaccountingsystem.repository.IPricingUnitRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PricingUnitService implements IPricingUnitService {

    private final IPricingUnitRepo repository;

    public PricingUnitService(IPricingUnitRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<PricingUnit> getAllPricingUnits() {
        final List<PricingUnitEntity> list = repository.findAll();
        return PricingUnitMapper.PRICING_UNIT_MAPPER.listFromDbo(list);
    }

}
