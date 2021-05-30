package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import com.example.callaccountingsystem.domain.dto.TariffPlan;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface TariffPlanMapper {

    TariffPlanMapper TARIFF_PLAN_MAPPER = Mappers.getMapper(TariffPlanMapper.class);

    TariffPlan fromDbo(TariffPlanEntity entity);

    TariffPlanEntity toDbo(TariffPlan dto);

    List<TariffPlan> listFromDbo(List<TariffPlanEntity> streets);
}
