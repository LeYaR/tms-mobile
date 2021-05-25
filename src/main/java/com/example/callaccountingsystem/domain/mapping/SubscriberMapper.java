package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import com.example.callaccountingsystem.domain.dto.Subscriber;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {CallMapper.class})
public interface SubscriberMapper {

    SubscriberMapper SUBSCRIBER_MAPPER = Mappers.getMapper(SubscriberMapper.class);

    Subscriber fromDbo(SubscriberEntity entity);

    SubscriberEntity toDbo(Subscriber dto);
}
