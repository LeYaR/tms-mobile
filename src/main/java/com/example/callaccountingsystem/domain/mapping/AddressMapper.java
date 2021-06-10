package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.AddressEntity;
import com.example.callaccountingsystem.domain.dto.Address;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    Address fromDbo(AddressEntity entity);

    AddressEntity toDbo(Address dto);

    List<Address> listFromDbo(List<AddressEntity> addressEntities);
}
