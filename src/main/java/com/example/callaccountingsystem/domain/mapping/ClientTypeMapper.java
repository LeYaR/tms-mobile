package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.ClientTypeEntity;
import com.example.callaccountingsystem.domain.dto.ClientType;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ClientTypeMapper {

    ClientTypeMapper CLIENT_TYPE_MAPPER = Mappers.getMapper(ClientTypeMapper.class);

    ClientType fromDbo(ClientTypeEntity entity);

    ClientTypeEntity toDbo(ClientType dto);

    List<ClientType> listFromDbo(List<ClientTypeEntity> streets);
}
