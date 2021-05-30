package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.AddressEntity;
import com.example.callaccountingsystem.domain.dto.Address;
import com.example.callaccountingsystem.domain.mapping.AddressMapper;
import com.example.callaccountingsystem.repository.IAddressRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService implements IAddressService {

    private final IAddressRepo repository;

    public AddressService(IAddressRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<Address> getAllAddress() {
        final List<AddressEntity> list = repository.findAll();
        return AddressMapper.ADDRESS_MAPPER.listFromDbo(list);
    }

}
