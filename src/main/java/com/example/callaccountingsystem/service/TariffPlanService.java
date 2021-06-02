package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import com.example.callaccountingsystem.domain.dto.TariffPlan;
import com.example.callaccountingsystem.domain.mapping.TariffPlanMapper;
import com.example.callaccountingsystem.repository.TariffPlanRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TariffPlanService implements TariffPlanServiceInterface {

    private final TariffPlanRepository repository;
    private final TariffPlanMapper mapper;

    public TariffPlanService(TariffPlanRepository repository, TariffPlanMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<TariffPlan> getAllTariffPlans() {
        final List<TariffPlanEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
