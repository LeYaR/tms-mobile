package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CityEntity;
import com.example.callaccountingsystem.domain.dto.City;
import com.example.callaccountingsystem.domain.mapping.CityMapper;
import com.example.callaccountingsystem.repository.CityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService implements CityServiceInterface {

    private final CityRepository repository;
    private final CityMapper mapper;

    public CityService(CityRepository repository, CityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<City> getAllCity() {
        final List<CityEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
