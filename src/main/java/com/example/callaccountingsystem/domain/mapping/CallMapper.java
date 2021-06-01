package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.CallEntity;
import com.example.callaccountingsystem.domain.dto.Call;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CallMapper {

    Call fromDbo(CallEntity entity);

    CallEntity toDbo(Call dto);

    List<Call> listFromDbo(List<CallEntity> callEntities);
}
