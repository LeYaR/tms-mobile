package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CityEntity;
import com.example.callaccountingsystem.domain.dto.City;
import com.example.callaccountingsystem.domain.mapping.CityMapper;
import com.example.callaccountingsystem.exception.FieldAlreadyExistException;
import com.example.callaccountingsystem.repository.CityRepository;
import com.example.callaccountingsystem.repository.CountryRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityService implements CityServiceInterface {

    private final CityRepository repository;
    private final CountryRepository countryRepository;
    private final CityMapper mapper;

    public CityService(CityRepository repository, CountryRepository countryRepository, CityMapper mapper) {
        this.repository = repository;
        this.countryRepository = countryRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<City> getAllCity(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<CityEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public int getQuantityPages(int pageSize) {
        return repository.findAll().size() / pageSize + 1;
    }

    @Override
    public City get(Long id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(City city) {
        city.getCountry().setCountry(city.getCountry().getCountry().toUpperCase().trim());
        if (repository.findFirstByCountry_CountryAndCity(city.getCountry().getCountry().trim(),
                city.getCity().trim()).isPresent()) {
            throw new FieldAlreadyExistException(city.getCity() + " (" + city.getCountry().getCountry()
                    + ") already exists!");
        }
        final CityEntity cityEntity = mapper.toDbo(city);
        countryRepository.findFirstByCountry(city.getCountry().getCountry().trim()).ifPresent(cityEntity::setCountry);
        repository.save(cityEntity);
    }

}
