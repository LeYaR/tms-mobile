package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.SubscriberEntity;
import com.example.callaccountingsystem.domain.dto.Address;
import com.example.callaccountingsystem.domain.dto.Subscriber;
import com.example.callaccountingsystem.domain.mapping.SubscriberMapper;
import com.example.callaccountingsystem.repository.AddressRepository;
import com.example.callaccountingsystem.repository.MobileOperatorRepository;
import com.example.callaccountingsystem.repository.SubscriberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubscriberService implements SubscriberServiceInterface {

    private final SubscriberRepository repository;
    private final MobileOperatorRepository mobileOperatorRepository;
    private final AddressRepository addressRepository;
    private final SubscriberMapper mapper;

    public SubscriberService(SubscriberRepository repository,
                             MobileOperatorRepository mobileOperatorRepository,
                             AddressRepository addressRepository,
                             SubscriberMapper mapper) {
        this.repository = repository;
        this.mobileOperatorRepository = mobileOperatorRepository;
        this.addressRepository = addressRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<Subscriber> getAllSubscribers(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<SubscriberEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public List<Long> getAllPhoneNumbers() {
        return repository.findAllByPhoneNumber();
    }

    @Override
    public int getQuantityPages(int pageSize) {
        return repository.findAll().size() / pageSize + 1;
    }

    @Override
    public Subscriber get(Long phoneNumber) {
        return mapper.fromDbo(repository.findById(phoneNumber).get());
    }

    @Override
    public void save(Subscriber subscriber) {
        final Address address = subscriber.getAddress();
        final SubscriberEntity subscriberEntity = mapper.toDbo(subscriber);
        mobileOperatorRepository.findFirstByCodeAndOperator(subscriber.getMobileOperator().getCode(),
                subscriber.getMobileOperator().getOperator()).ifPresent(subscriberEntity::setMobileOperator);
        addressRepository.findFirstByFlatAndHouseAndStreet_StreetAndStreet_City_CityAndStreet_City_Country_Country(
                address.getFlat().trim(),
                address.getHouse().trim(),
                address.getStreet().getStreet().trim(),
                address.getStreet().getCity().getCity().trim(),
                address.getStreet().getCity().getCountry().getCountry().trim())
                .ifPresent(subscriberEntity::setAddress);
        repository.save(subscriberEntity);
    }

}
