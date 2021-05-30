package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import com.example.callaccountingsystem.domain.dto.Subscriber;
import com.example.callaccountingsystem.domain.mapping.SubscriberMapper;
import com.example.callaccountingsystem.repository.ISubscriberRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService implements ISubscriberService {

    private final ISubscriberRepo repository;

    public SubscriberService(ISubscriberRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<Subscriber> getAllSubscribers() {
        final List<SubscriberEntity> list = repository.findAll();
        return SubscriberMapper.SUBSCRIBER_MAPPER.listFromDbo(list);
    }

}
