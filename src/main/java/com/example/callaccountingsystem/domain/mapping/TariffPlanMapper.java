package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import com.example.callaccountingsystem.domain.dto.TariffPlan;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TariffPlanMapper {

    TariffPlan fromDbo(TariffPlanEntity entity);

    TariffPlanEntity toDbo(TariffPlan dto);

    List<TariffPlan> listFromDbo(List<TariffPlanEntity> tariffPlanEntities);
}
