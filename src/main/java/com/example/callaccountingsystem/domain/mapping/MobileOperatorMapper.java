package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.MobileOperatorEntity;
import com.example.callaccountingsystem.domain.dto.MobileOperator;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CountryMapper.class, SubscriberMapper.class})
public interface MobileOperatorMapper {

    MobileOperatorMapper MOBILE_OPERATOR_MAPPER = Mappers.getMapper(MobileOperatorMapper.class);

    MobileOperator fromDbo(MobileOperatorEntity entity);

    MobileOperatorEntity toDbo(MobileOperator dto);
}
