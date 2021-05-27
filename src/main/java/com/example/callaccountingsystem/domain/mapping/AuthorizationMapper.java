package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.AuthorizationEntity;
import com.example.callaccountingsystem.domain.dto.Authorization;
import org.mapstruct.factory.Mappers;

public interface AuthorizationMapper {

    AuthorizationMapper AUTHORIZATION_MAPPER = Mappers.getMapper(AuthorizationMapper.class);

    Authorization fromDbo(AuthorizationEntity entity);

    AuthorizationEntity toDbo(Authorization dto);
}
