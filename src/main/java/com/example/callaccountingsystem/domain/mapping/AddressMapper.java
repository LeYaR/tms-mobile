package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.AddressEntity;
import com.example.callaccountingsystem.domain.dto.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AddressMapper {

    AddressMapper ADDRESS_MAPPER = Mappers.getMapper(AddressMapper.class);

    Address fromDbo(AddressEntity entity);

    AddressEntity toDbo(Address dto);
}
