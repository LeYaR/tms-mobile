package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CallEntity;
import com.example.callaccountingsystem.domain.dto.Call;
import org.springframework.stereotype.Component;

@Component
public class CallMapper {

    public Call fromDbo(CallEntity entity) {
        final Call dto = new Call();
        dto.setDate(entity.getDate());
        dto.setDuration(entity.getDuration());
        dto.setStatus(new StatusMapper().fromDbo(entity.getStatusEntity()));
        dto.setTower(new TowerMapper().fromDbo(entity.getTowerEntity()));
        entity.getOutgoingSubscriberEntities().forEach(subscriber -> dto.getOutgoingSubscriberList().add(new SubscriberMapper().fromDbo(subscriber)));
        entity.getIncomingSubscriberEntities().forEach(subscriber -> dto.getIncomingSubscriberList().add(new SubscriberMapper().fromDbo(subscriber)));
        return dto;
    }

    public CallEntity toDbo(Call dto) {
        final CallEntity entity = new CallEntity();
        entity.setDate(dto.getDate());
        entity.setDuration(dto.getDuration());
        entity.setTowerEntity(new TowerMapper().toDbo(dto.getTower()));
        entity.setStatusEntity(new StatusMapper().toDbo(dto.getStatus()));
        dto.getOutgoingSubscriberList().forEach(subscriber -> entity.getOutgoingSubscriberEntities().add(new SubscriberMapper().toDbo(subscriber)));
        dto.getIncomingSubscriberList().forEach(subscriber -> entity.getIncomingSubscriberEntities().add(new SubscriberMapper().toDbo(subscriber)));
        return entity;
    }
}
