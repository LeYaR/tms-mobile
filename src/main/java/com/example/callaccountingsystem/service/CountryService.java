package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CountryEntity;
import com.example.callaccountingsystem.domain.dto.Country;
import com.example.callaccountingsystem.domain.mapping.CountryMapper;
import com.example.callaccountingsystem.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CountryService implements CountryServiceInterface {

    private final CountryRepository repository;
    private final CountryMapper mapper;

    public CountryService(CountryRepository repository, CountryMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<Country> getAllCountries(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<CountryEntity> page = repository.findAll(pageable);
        return page.map(countryEntity -> (mapper.fromDbo(countryEntity)));
    }

    @Override
    public Country get(Long id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(Country country) {
        repository.save(mapper.toDbo(country));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }
}
