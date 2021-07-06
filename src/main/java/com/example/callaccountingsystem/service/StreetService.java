package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.StreetEntity;
import com.example.callaccountingsystem.domain.dto.City;
import com.example.callaccountingsystem.domain.dto.Country;
import com.example.callaccountingsystem.domain.dto.Street;
import com.example.callaccountingsystem.domain.mapping.StreetMapper;
import com.example.callaccountingsystem.exception.FieldAlreadyExistException;
import com.example.callaccountingsystem.repository.CityRepository;
import com.example.callaccountingsystem.repository.StreetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StreetService implements StreetServiceInterface {

    private final StreetRepository repository;
    private final CityRepository cityRepository;
    private final StreetMapper mapper;

    public StreetService(StreetRepository repository, CityRepository cityRepository, StreetMapper mapper) {
        this.repository = repository;
        this.cityRepository = cityRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<Street> getAllStreets(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<StreetEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public int getQuantityPages(int pageSize) {
        return repository.findAll().size() / pageSize + 1;
    }

    @Override
    public Street get(Long id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(Street street) {
        final City city = street.getCity();
        final Country country = street.getCity().getCountry();
        if (repository.findFirstByStreetAndCity_CityAndCity_Country_Country(street.getStreet().trim(),
                city.getCity().trim(), country.getCountry().trim()).isPresent()) {
            throw new FieldAlreadyExistException(street.getStreet() + " (" + country.getCountry()
                    + ", " + city.getCity() + ") already exists!");
        }
        final StreetEntity streetEntity = mapper.toDbo(street);
        cityRepository.findFirstByCountry_CountryAndCity(country.getCountry().trim(),
                city.getCity().trim()).ifPresent(streetEntity::setCity);
        repository.save(streetEntity);
    }

}
