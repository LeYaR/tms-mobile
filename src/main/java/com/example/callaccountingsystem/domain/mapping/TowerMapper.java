package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.TowerEntity;
import com.example.callaccountingsystem.domain.dto.Tower;
import org.springframework.stereotype.Component;

@Component
public class TowerMapper {

    public Tower fromDbo(TowerEntity entity) {
        final Tower dto = new Tower();
        dto.setLocationCity(new CityMapper().fromDbo(entity.getLocationCity()));
        entity.getCallEntities().forEach(call -> dto.getCallList().add(new CallMapper().fromDbo(call)));
        return dto;
    }

    public TowerEntity toDbo(Tower dto) {
        final TowerEntity entity = new TowerEntity();
        entity.setLocationCity(new CityMapper().toDbo(dto.getLocationCity()));
        dto.getCallList().forEach(call -> entity.getCallEntities().add(new CallMapper().toDbo(call)));
        return entity;
    }
}
