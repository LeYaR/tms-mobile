package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import com.example.callaccountingsystem.domain.dto.TariffPlan;
import com.example.callaccountingsystem.domain.mapping.TariffPlanMapper;
import com.example.callaccountingsystem.repository.ITariffPlanRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TariffPlanService implements ITariffPlanService{

    private final ITariffPlanRepo repository;

    public TariffPlanService(ITariffPlanRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<TariffPlan> getAllTariffPlans() {
        final List<TariffPlanEntity> list = repository.findAll();
        List<TariffPlan> tariffPlans = new ArrayList<>();
        list.forEach((tariffPlanEntity -> tariffPlans.add(TariffPlanMapper.TARIFF_PLAN_MAPPER.fromDbo(tariffPlanEntity))));
        return tariffPlans;
    }

}
