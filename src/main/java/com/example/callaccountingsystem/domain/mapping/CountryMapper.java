package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CountryEntity;
import com.example.callaccountingsystem.domain.dto.Country;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public Country fromDbo(CountryEntity entity) {
        final Country dto = new Country();
        dto.setCountry(entity.getCountry());
        entity.getCityEntities().forEach(city -> dto.getCityList().add(new CityMapper().fromDbo(city)));
        entity.getCurrencyEntities().forEach(currency -> dto.getCurrencyList().add(new CurrencyMapper().fromDbo(currency)));
        return dto;
    }

    public CountryEntity toDbo(Country dto) {
        final CountryEntity entity = new CountryEntity();
        entity.setCountry(dto.getCountry());
        dto.getCityList().forEach(city -> entity.getCityEntities().add(new CityMapper().toDbo(city)));
        dto.getCurrencyList().forEach(currency -> entity.getCurrencyEntities().add(new CurrencyMapper().toDbo(currency)));
        return entity;
    }
}
