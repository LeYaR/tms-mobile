package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.ClientTypeEntity;
import com.example.callaccountingsystem.domain.dto.ClientType;
import org.springframework.stereotype.Component;

@Component
public class ClientTypeMapper {

    public ClientType fromDbo(ClientTypeEntity entity) {
        final ClientType dto = new ClientType();
        dto.setType(entity.getType());
        entity.getContractEntities().forEach(contract -> dto.getContractList().add(new ContractMapper().fromDbo(contract)));
        return dto;
    }

    public ClientTypeEntity toDbo(ClientType dto) {
        final ClientTypeEntity entity = new ClientTypeEntity();
        entity.setType(dto.getType());
        dto.getContractList().forEach(contract -> entity.getContractEntities().add(new ContractMapper().toDbo(contract)));
        return entity;
    }
}
