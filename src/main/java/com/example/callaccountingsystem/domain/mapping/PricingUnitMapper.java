package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.PricingUnitEntity;
import com.example.callaccountingsystem.domain.dto.PricingUnit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {TariffPlanMapper.class})
public interface PricingUnitMapper {

    PricingUnitMapper PRICING_UNIT_MAPPER = Mappers.getMapper(PricingUnitMapper.class);

    PricingUnit fromDbo(PricingUnitEntity entity);

    PricingUnitEntity toDbo(PricingUnit dto);
}
