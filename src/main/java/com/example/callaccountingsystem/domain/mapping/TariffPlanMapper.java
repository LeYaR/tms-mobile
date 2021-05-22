package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import com.example.callaccountingsystem.domain.dto.TariffPlan;
import org.springframework.stereotype.Component;

@Component
public class TariffPlanMapper {

    public TariffPlan fromDbo(TariffPlanEntity entity) {
        final TariffPlan dto = new TariffPlan();
        dto.setAbonentPayment(entity.getAbonentPayment());
        dto.setCurrency(new CurrencyMapper().fromDbo(entity.getCurrencyEntity()));
        dto.setDescription(entity.getDescription());
        dto.setPrice(entity.getPrice());
        dto.setName(entity.getName());
        dto.setPricingUnit(new PricingUnitMapper().fromDbo(entity.getPricingUnitEntity()));
        entity.getContractEntities().forEach(contract -> dto.getContractList().add(new ContractMapper().fromDbo(contract)));
        return dto;
    }

    public TariffPlanEntity toDbo(TariffPlan dto) {
        final TariffPlanEntity entity = new TariffPlanEntity();
        entity.setAbonentPayment(dto.getAbonentPayment());
        entity.setCurrencyEntity(new CurrencyMapper().toDbo(dto.getCurrency()));
        entity.setDescription(dto.getDescription());
        entity.setPrice(dto.getPrice());
        entity.setName(dto.getName());
        entity.setPricingUnitEntity(new PricingUnitMapper().toDbo(dto.getPricingUnit()));
        dto.getContractList().forEach(contract -> entity.getContractEntities().add(new ContractMapper().toDbo(contract)));
        return entity;
    }
}
