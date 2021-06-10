package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import com.example.callaccountingsystem.domain.dto.TariffPlan;
import com.example.callaccountingsystem.domain.mapping.TariffPlanMapper;
import com.example.callaccountingsystem.repository.TariffPlanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TariffPlanService implements TariffPlanServiceInterface {

    private final TariffPlanRepository repository;
    private final TariffPlanMapper mapper;

    public TariffPlanService(TariffPlanRepository repository, TariffPlanMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<TariffPlan> getAllTariffPlans(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<TariffPlanEntity> page = repository.findAll(pageable);
        return page.map(tariffPlanEntity -> (mapper.fromDbo(tariffPlanEntity)));
    }

    @Override
    public TariffPlan get(Integer id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(TariffPlan tariffPlan) {
        repository.save(mapper.toDbo(tariffPlan));
    }

}
