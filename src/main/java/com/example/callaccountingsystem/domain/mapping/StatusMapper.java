package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.StatusEntity;
import com.example.callaccountingsystem.domain.dto.Status;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface StatusMapper {

    Status fromDbo(StatusEntity entity);

    StatusEntity toDbo(Status dto);

    List<Status> listFromDbo(List<StatusEntity> statusEntities);
}
