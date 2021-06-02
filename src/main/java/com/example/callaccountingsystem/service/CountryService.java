package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CountryEntity;
import com.example.callaccountingsystem.domain.dto.Country;
import com.example.callaccountingsystem.domain.mapping.CountryMapper;
import com.example.callaccountingsystem.repository.CountryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryService implements CountryServiceInterface {

    private final CountryRepository repository;
    private final CountryMapper mapper;

    public CountryService(CountryRepository repository, CountryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Country> getAllCountries() {
        final List<CountryEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
