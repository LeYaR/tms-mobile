package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import com.example.callaccountingsystem.domain.dto.Subscriber;
import com.example.callaccountingsystem.domain.mapping.SubscriberMapper;
import com.example.callaccountingsystem.repository.SubscriberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public Page<Subscriber> getAllSubscribers(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<SubscriberEntity> page = repository.findAll(pageable);
        return page.map(subscriberEntity -> (mapper.fromDbo(subscriberEntity)));
    }

    @Override
    public List<Long> getAllPhoneNumbers() {
        return repository.findAllByPhoneNumber();
    }

    @Override
    public Subscriber get(Long phoneNumber) {
        return mapper.fromDbo(repository.findById(phoneNumber).get());
    }

    @Override
    public void save(Subscriber subscriber) {
        repository.save(mapper.toDbo(subscriber));
    }

}
