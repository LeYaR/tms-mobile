package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CityEntity;
import com.example.callaccountingsystem.domain.dto.City;
import org.springframework.stereotype.Component;

@Component
public class CityMapper {

    public City fromDbo(CityEntity entity) {
        final City dto = new City();
        dto.setCity(entity.getCity());
        dto.setCountry(new CountryMapper().fromDbo(entity.getCountryEntity()));
        entity.getStreetEntities().forEach(street -> dto.getStreetList().add(new StreetMapper().fromDbo(street)));
        entity.getTowerEntities().forEach(tower -> dto.getTowerList().add(new TowerMapper().fromDbo(tower)));
        return dto;
    }

    public CityEntity toDbo(City dto) {
        final CityEntity entity = new CityEntity();
        entity.setCity(dto.getCity());
        entity.setCountryEntity(new CountryMapper().toDbo(dto.getCountry()));
        dto.getStreetList().forEach(street -> entity.getStreetEntities().add(new StreetMapper().toDbo(street)));
        dto.getTowerList().forEach(tower -> entity.getTowerEntities().add(new TowerMapper().toDbo(tower)));
        return entity;
    }
}
