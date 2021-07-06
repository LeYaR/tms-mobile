package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import com.example.callaccountingsystem.domain.dto.Currency;
import com.example.callaccountingsystem.domain.dto.PricingUnit;
import com.example.callaccountingsystem.domain.dto.TariffPlan;
import com.example.callaccountingsystem.domain.mapping.TariffPlanMapper;
import com.example.callaccountingsystem.exception.FieldAlreadyExistException;
import com.example.callaccountingsystem.repository.CurrencyRepository;
import com.example.callaccountingsystem.repository.PricingUnitRepository;
import com.example.callaccountingsystem.repository.TariffPlanRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class TariffPlanService implements TariffPlanServiceInterface {

    private final TariffPlanRepository repository;
    private final CurrencyRepository currencyRepository;
    private final PricingUnitRepository pricingUnitRepository;
    private final TariffPlanMapper mapper;

    public TariffPlanService(TariffPlanRepository repository,
                             CurrencyRepository currencyRepository,
                             PricingUnitRepository pricingUnitRepository,
                             TariffPlanMapper mapper) {
        this.repository = repository;
        this.currencyRepository = currencyRepository;
        this.pricingUnitRepository = pricingUnitRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<TariffPlan> getAllTariffPlans(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<TariffPlanEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public int getQuantityPages(int pageSize) {
        return repository.findAll().size() / pageSize + 1;
    }

    @Override
    public TariffPlan get(Integer id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(TariffPlan tariffPlan) {
        final Currency currency = tariffPlan.getCurrency();
        final PricingUnit pricingUnit = tariffPlan.getPricingUnit();
        if (repository.findFirstByNameAndIdIsNot(tariffPlan.getName().trim(), tariffPlan.getId()).isPresent()) {
            throw new FieldAlreadyExistException("Tariff plan \"" + tariffPlan.getName() + "\" already exists!");
        }
        final TariffPlanEntity tariffPlanEntity = mapper.toDbo(tariffPlan);
        currencyRepository.findFirstByCodeAndAndNumericalCodeAndName(currency.getCode().trim(),
                currency.getNumericalCode(),
                currency.getName().trim())
                .ifPresent(tariffPlanEntity::setCurrency);
        pricingUnitRepository.findFirstByUnit(pricingUnit.getUnit().trim())
                .ifPresent(tariffPlanEntity::setPricingUnit);
        repository.save(tariffPlanEntity);
    }

}
