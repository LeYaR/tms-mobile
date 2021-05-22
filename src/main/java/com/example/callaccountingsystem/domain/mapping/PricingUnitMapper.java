package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.PricingUnitEntity;
import com.example.callaccountingsystem.domain.dto.PricingUnit;
import org.springframework.stereotype.Component;

@Component
public class PricingUnitMapper {

    public PricingUnit fromDbo(PricingUnitEntity entity) {
        final PricingUnit dto = new PricingUnit();
        dto.setUnit(entity.getUnit());
        entity.getTariffPlanEntities().forEach(tariffPlan -> dto.getTariffPlanList().add(new TariffPlanMapper().fromDbo(tariffPlan)));
        return dto;
    }

    public PricingUnitEntity toDbo(PricingUnit dto) {
        final PricingUnitEntity entity = new PricingUnitEntity();
        entity.setUnit(dto.getUnit());
        dto.getTariffPlanList().forEach(tariffPlan -> entity.getTariffPlanEntities().add(new TariffPlanMapper().toDbo(tariffPlan)));
        return entity;
    }
}
