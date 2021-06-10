package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.AuthorizationEntity;
import com.example.callaccountingsystem.domain.dto.Authorization;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AuthorizationMapper {

    Authorization fromDbo(AuthorizationEntity entity);

    AuthorizationEntity toDbo(Authorization dto);

    List<Authorization> listFromDbo(List<AuthorizationEntity> authorizationEntities);
}
