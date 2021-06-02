package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.ClientTypeEntity;
import com.example.callaccountingsystem.domain.dto.ClientType;
import com.example.callaccountingsystem.domain.mapping.ClientTypeMapper;
import com.example.callaccountingsystem.repository.ClientTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientTypeService implements ClientTypeServiceInterface {

    private final ClientTypeRepository repository;
    private final ClientTypeMapper mapper;

    public ClientTypeService(ClientTypeRepository repository, ClientTypeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<ClientType> getAllClients() {
        final List<ClientTypeEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
