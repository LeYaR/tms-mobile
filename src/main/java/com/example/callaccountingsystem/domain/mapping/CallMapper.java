package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CallEntity;
import com.example.callaccountingsystem.domain.dto.Call;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = SubscriberMapper.class)
public interface CallMapper {

    CallMapper CALL_MAPPER = Mappers.getMapper(CallMapper.class);

    Call fromDbo(CallEntity entity);

    CallEntity toDbo(Call dto);
}
