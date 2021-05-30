package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.StatusEntity;
import com.example.callaccountingsystem.domain.dto.Status;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface StatusMapper {

    StatusMapper STATUS_MAPPER = Mappers.getMapper(StatusMapper.class);

    Status fromDbo(StatusEntity entity);

    StatusEntity toDbo(Status dto);

    List<Status> listFromDbo(List<StatusEntity> streets);
}
