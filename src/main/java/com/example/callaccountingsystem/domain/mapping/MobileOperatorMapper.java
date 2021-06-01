package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.MobileOperatorEntity;
import com.example.callaccountingsystem.domain.dto.MobileOperator;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MobileOperatorMapper {

    MobileOperator fromDbo(MobileOperatorEntity entity);

    MobileOperatorEntity toDbo(MobileOperator dto);

    List<MobileOperator> listFromDbo(List<MobileOperatorEntity> mobileOperatorEntities);
}
