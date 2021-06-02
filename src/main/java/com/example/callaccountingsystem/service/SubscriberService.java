package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import com.example.callaccountingsystem.domain.dto.Subscriber;
import com.example.callaccountingsystem.domain.mapping.SubscriberMapper;
import com.example.callaccountingsystem.repository.SubscriberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService implements SubscriberServiceInterface {

    private final SubscriberRepository repository;
    private final SubscriberMapper mapper;

    public SubscriberService(SubscriberRepository repository, SubscriberMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Subscriber> getAllSubscribers() {
        final List<SubscriberEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
