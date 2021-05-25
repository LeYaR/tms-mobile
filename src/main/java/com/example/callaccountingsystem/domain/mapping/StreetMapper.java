package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.StreetEntity;
import com.example.callaccountingsystem.domain.dto.Street;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {AddressMapper.class})
public interface StreetMapper {

    StreetMapper STREET_MAPPER = Mappers.getMapper(StreetMapper.class);

    Street fromDbo(StreetEntity entity);

    StreetEntity toDbo(Street dto);
}
