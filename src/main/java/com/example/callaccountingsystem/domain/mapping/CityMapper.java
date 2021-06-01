package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CityEntity;
import com.example.callaccountingsystem.domain.dto.City;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    City fromDbo(CityEntity entity);

    CityEntity toDbo(City dto);

    List<City> listFromDbo(List<CityEntity> cityEntities);
}
