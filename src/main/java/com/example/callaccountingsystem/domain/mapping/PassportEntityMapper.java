package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.PassportEntity;
import com.example.callaccountingsystem.domain.dto.Passport;
import org.springframework.stereotype.Component;

@Component
public class PassportEntityMapper {

    public Passport fromDbo(PassportEntity entity) {
        final Passport dto = new Passport();
        dto.setDate(entity.getDate());
        dto.setIdNumber(entity.getIdNumber());
        dto.setIssuer(entity.getIssuer());
        dto.setSubscriber(new SubscriberMapper().fromDbo(entity.getSubscriberEntity()));
        dto.setSeriesNumber(entity.getSeriesNumber());
        return dto;
    }

    public PassportEntity toDbo(Passport dto) {
        final PassportEntity entity = new PassportEntity();
        entity.setDate(dto.getDate());
        entity.setIdNumber(dto.getIdNumber());
        entity.setIssuer(dto.getIssuer());
        entity.setSubscriberEntity(new SubscriberMapper().toDbo(dto.getSubscriber()));
        entity.setSeriesNumber(dto.getSeriesNumber());
        return entity;
    }
}
