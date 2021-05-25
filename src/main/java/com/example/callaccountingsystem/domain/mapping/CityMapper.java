package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CityEntity;
import com.example.callaccountingsystem.domain.dto.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {TowerMapper.class, StreetMapper.class})
public interface CityMapper {

    CityMapper CITY_MAPPER = Mappers.getMapper(CityMapper.class);

    City fromDbo(CityEntity entity);

    CityEntity toDbo(City dto);
}
