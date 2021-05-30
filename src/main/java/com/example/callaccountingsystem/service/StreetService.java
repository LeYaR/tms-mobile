package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.StreetEntity;
import com.example.callaccountingsystem.domain.dto.Street;
import com.example.callaccountingsystem.domain.mapping.StreetMapper;
import com.example.callaccountingsystem.repository.IStreetRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StreetService implements IStreetService {
    private final IStreetRepo repository;

    public StreetService(IStreetRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<Street> getAllStreets() {
        final List<StreetEntity> list = repository.findAll();
        return StreetMapper.STREET_MAPPER.listFromDbo(list);
    }

}
