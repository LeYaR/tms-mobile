package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CountryEntity;
import com.example.callaccountingsystem.domain.dto.Country;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    Country fromDbo(CountryEntity entity);

    CountryEntity toDbo(Country dto);

    List<Country> listFromDbo(List<CountryEntity> countryEntities);
}
