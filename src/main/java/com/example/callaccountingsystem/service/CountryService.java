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

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Country> getAllCountries() {
        final List<CountryEntity> list = repository.findAll();
        return CountryMapper.COUNTRY_MAPPER.listFromDbo(list);
    }
}