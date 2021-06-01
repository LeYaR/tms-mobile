package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.TowerEntity;
import com.example.callaccountingsystem.domain.dto.Tower;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TowerMapper {

    Tower fromDbo(TowerEntity entity);

    TowerEntity toDbo(Tower dto);

    List<Tower> listFromDbo(List<TowerEntity> towerEntities);
}
