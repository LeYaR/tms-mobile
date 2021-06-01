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

    public AddressService(AddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> getAllAddress() {
        final List<AddressEntity> list = repository.findAll();
        return AddressMapper.ADDRESS_MAPPER.listFromDbo(list);
    }

}
