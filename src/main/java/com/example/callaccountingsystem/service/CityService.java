package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CityEntity;
import com.example.callaccountingsystem.domain.dto.City;
import com.example.callaccountingsystem.domain.mapping.CityMapper;
import com.example.callaccountingsystem.repository.CityRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityService implements CityServiceInterface {

    private final CityRepository repository;
    private final CityMapper mapper;

    public CityService(CityRepository repository, CityMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<City> getAllCity(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<CityEntity> page = repository.findAll(pageable);
        return page.map(cityEntity -> (mapper.fromDbo(cityEntity)));
    }

}
