package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.ClientTypeEntity;
import com.example.callaccountingsystem.domain.dto.ClientType;
import com.example.callaccountingsystem.domain.mapping.ClientTypeMapper;
import com.example.callaccountingsystem.repository.ClientTypeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ClientTypeService implements ClientTypeServiceInterface {

    private final ClientTypeRepository repository;
    private final ClientTypeMapper mapper;

    public ClientTypeService(ClientTypeRepository repository, ClientTypeMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<ClientType> getAllClients(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<ClientTypeEntity> page = repository.findAll(pageable);
        return page.map(clientTypeEntity -> (mapper.fromDbo(clientTypeEntity)));
    }

    @Override
    public ClientType get(Integer id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(ClientType clientType) {
        repository.save(mapper.toDbo(clientType));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
