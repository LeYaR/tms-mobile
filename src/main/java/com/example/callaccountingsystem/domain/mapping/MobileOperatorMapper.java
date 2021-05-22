package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.MobileOperatorEntity;
import com.example.callaccountingsystem.domain.dto.MobileOperator;
import org.springframework.stereotype.Component;

@Component
public class MobileOperatorMapper {

    public MobileOperator fromDbo(MobileOperatorEntity entity) {
        final MobileOperator dto = new MobileOperator();
        dto.setOperator(entity.getOperator());
        dto.setCode(entity.getCode());
        entity.getSubscriberEntities().forEach(subscriber -> dto.getSubscriberList().add(new SubscriberMapper().fromDbo(subscriber)));
        entity.getCountryEntities().forEach(country -> dto.getCountryList().add(new CountryMapper().fromDbo(country)));
        return dto;
    }

    public MobileOperatorEntity toDbo(MobileOperator dto) {
        final MobileOperatorEntity entity = new MobileOperatorEntity();
        entity.setOperator(dto.getOperator());
        entity.setCode(dto.getCode());
        dto.getSubscriberList().forEach(subscriber -> entity.getSubscriberEntities().add(new SubscriberMapper().toDbo(subscriber)));
        dto.getCountryList().forEach(country -> entity.getCountryEntities().add(new CountryMapper().toDbo(country)));
        return entity;
    }
}
