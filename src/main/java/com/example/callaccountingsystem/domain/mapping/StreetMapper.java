package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.StreetEntity;
import com.example.callaccountingsystem.domain.dto.Street;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StreetMapper {

    StreetMapper STREET_MAPPER = Mappers.getMapper(StreetMapper.class);

    Street fromDbo(StreetEntity entity);

    StreetEntity toDbo(Street dto);

    List<Street> listFromDbo(List<StreetEntity> streets);
}
