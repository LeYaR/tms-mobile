package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.AddressEntity;
import com.example.callaccountingsystem.domain.dto.Address;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AddressMapper {

    public Address fromDbo(AddressEntity entity) {
        final Address dto = new Address();
        dto.setStreet(new StreetMapper().fromDbo(entity.getStreetEntity()));
        dto.setFlat(entity.getFlat());
        dto.setHouse(entity.getHouse());
        entity.getSubscriberEntities().forEach(subscriber -> dto.getSubscriberList().add(new SubscriberMapper().fromDbo(subscriber)));
        return dto;
    }

    public AddressEntity toDbo(Address dto) {
        final AddressEntity entity = new AddressEntity();
        entity.setStreetEntity(new StreetMapper().toDbo(dto.getStreet()));
        entity.setFlat(dto.getFlat());
        entity.setHouse(dto.getHouse());
        dto.getSubscriberList().forEach(subscriber -> entity.getSubscriberEntities().add(new SubscriberMapper().toDbo(subscriber)));
        return entity;
    }
}
