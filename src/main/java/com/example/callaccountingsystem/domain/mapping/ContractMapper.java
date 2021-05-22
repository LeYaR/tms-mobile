package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.ContractEntity;
import com.example.callaccountingsystem.domain.dto.Contract;
import org.springframework.stereotype.Component;

@Component
public class ContractMapper {

    public Contract fromDbo(ContractEntity entity) {
        final Contract dto = new Contract();
        dto.setDate(entity.getDate());
        dto.setClientType(new ClientTypeMapper().fromDbo(entity.getClientTypeEntity()));
        dto.setDiscount(entity.getDiscount());
        dto.setNumber(entity.getNumber());
        dto.setSubscriber(new SubscriberMapper().fromDbo(entity.getSubscriberEntity()));
        dto.setTariffPlan(new TariffPlanMapper().fromDbo(entity.getTariffPlanEntity()));
        return dto;
    }

    public ContractEntity toDbo(Contract dto) {
        final ContractEntity entity = new ContractEntity();
        entity.setDate(dto.getDate());
        entity.setClientTypeEntity(new ClientTypeMapper().toDbo(dto.getClientType()));
        entity.setDiscount(dto.getDiscount());
        entity.setNumber(dto.getNumber());
        entity.setSubscriberEntity(new SubscriberMapper().toDbo(dto.getSubscriber()));
        entity.setTariffPlanEntity(new TariffPlanMapper().toDbo(dto.getTariffPlan()));
        return entity;
    }
}
