package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.ContractEntity;
import com.example.callaccountingsystem.domain.dto.Contract;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    Contract fromDbo(ContractEntity entity);

    ContractEntity toDbo(Contract dto);

    List<Contract> listFromDbo(List<ContractEntity> contractEntities);
}
