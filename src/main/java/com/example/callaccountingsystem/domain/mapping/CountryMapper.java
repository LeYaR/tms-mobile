package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CountryEntity;
import com.example.callaccountingsystem.domain.dto.Country;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CountryMapper {

    CountryMapper COUNTRY_MAPPER = Mappers.getMapper(CountryMapper.class);

    Country fromDbo(CountryEntity entity);

    CountryEntity toDbo(Country dto);
}
