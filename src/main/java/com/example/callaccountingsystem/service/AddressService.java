package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.AddressEntity;
import com.example.callaccountingsystem.domain.dto.Address;
import com.example.callaccountingsystem.domain.mapping.AddressMapper;
import com.example.callaccountingsystem.repository.AddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements AddressServiceInterface {

    private final AddressRepository repository;
    private final AddressMapper mapper;

    public AddressService(AddressRepository repository, AddressMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }


    @Override
    public List<Address> getAllAddress() {
        final List<AddressEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
