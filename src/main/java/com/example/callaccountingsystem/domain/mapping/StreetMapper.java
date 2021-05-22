package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.StreetEntity;
import com.example.callaccountingsystem.domain.dto.Street;
import org.springframework.stereotype.Component;

@Component
public class StreetMapper {

    public Street fromDbo(StreetEntity entity) {
        final Street dto = new Street();
        dto.setStreet(entity.getStreet());
        dto.setCity(new CityMapper().fromDbo(entity.getCityEntity()));
        entity.getAddressEntities().forEach(address -> dto.getAddressList().add(new AddressMapper().fromDbo(address)));
        return dto;
    }

    public StreetEntity toDbo(Street dto) {
        final StreetEntity entity = new StreetEntity();
        entity.setStreet(dto.getStreet());
        entity.setCityEntity(new CityMapper().toDbo(dto.getCity()));
        dto.getAddressList().forEach(address -> entity.getAddressEntities().add(new AddressMapper().toDbo(address)));
        return entity;
    }
}
