package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.PricingUnitEntity;
import com.example.callaccountingsystem.domain.dto.PricingUnit;
import com.example.callaccountingsystem.domain.mapping.PricingUnitMapper;
import com.example.callaccountingsystem.repository.PricingUnitRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PricingUnitService implements PricingUnitServiceInterface {

    private final PricingUnitRepository repository;
    private final PricingUnitMapper mapper;

    public PricingUnitService(PricingUnitRepository repository, PricingUnitMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<PricingUnit> getAllPricingUnits(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<PricingUnitEntity> page = repository.findAll(pageable);
        return page.map(pricingUnitEntity -> (mapper.fromDbo(pricingUnitEntity)));
    }

    @Override
    public PricingUnit get(Integer id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(PricingUnit pricingUnit) {
        repository.save(mapper.toDbo(pricingUnit));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
