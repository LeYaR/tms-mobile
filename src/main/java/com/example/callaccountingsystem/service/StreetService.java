package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.StreetEntity;
import com.example.callaccountingsystem.domain.dto.Street;
import com.example.callaccountingsystem.domain.mapping.StreetMapper;
import com.example.callaccountingsystem.repository.StreetRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService implements StreetServiceInterface {

    private final StreetRepository repository;
    private final StreetMapper mapper;
    public StreetService(StreetRepository repository, StreetMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Street> getAllStreets() {
        final List<StreetEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
