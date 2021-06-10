package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.ClientTypeEntity;
import com.example.callaccountingsystem.domain.dto.ClientType;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientTypeMapper {

    ClientType fromDbo(ClientTypeEntity entity);

    ClientTypeEntity toDbo(ClientType dto);

    List<ClientType> listFromDbo(List<ClientTypeEntity> clientTypeEntities);
}
