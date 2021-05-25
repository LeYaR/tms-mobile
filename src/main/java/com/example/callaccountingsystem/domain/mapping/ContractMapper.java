package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.ContractEntity;
import com.example.callaccountingsystem.domain.dto.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ContractMapper {

    ContractMapper CONTRACT_MAPPER = Mappers.getMapper(ContractMapper.class);

    Contract fromDbo(ContractEntity entity);

    ContractEntity toDbo(Contract dto);
}
