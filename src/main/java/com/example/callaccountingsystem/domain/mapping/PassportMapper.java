package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.PassportEntity;
import com.example.callaccountingsystem.domain.dto.Passport;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PassportMapper {

    Passport fromDbo(PassportEntity entity);

    PassportEntity toDbo(Passport dto);

    List<Passport> listFromDbo(List<PassportEntity> passportEntities);
}
