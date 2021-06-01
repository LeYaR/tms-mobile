package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.PricingUnitEntity;
import com.example.callaccountingsystem.domain.dto.PricingUnit;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PricingUnitMapper {

    PricingUnit fromDbo(PricingUnitEntity entity);

    PricingUnitEntity toDbo(PricingUnit dto);

    List<PricingUnit> listFromDbo(List<PricingUnitEntity> pricingUnitEntities);
}
