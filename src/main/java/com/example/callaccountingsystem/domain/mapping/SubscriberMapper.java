package com.example.callaccountingsystem.domain.mapping;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import com.example.callaccountingsystem.domain.dto.Subscriber;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface SubscriberMapper {

    SubscriberMapper SUBSCRIBER_MAPPER = Mappers.getMapper(SubscriberMapper.class);

    Subscriber fromDbo(SubscriberEntity entity);

    SubscriberEntity toDbo(Subscriber dto);

    List<Subscriber> listFromDbo(List<SubscriberEntity> streets);
}
