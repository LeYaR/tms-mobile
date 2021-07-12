package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.TowerEntity;
import com.example.callaccountingsystem.domain.dto.City;
import com.example.callaccountingsystem.domain.dto.Country;
import com.example.callaccountingsystem.domain.dto.Tower;
import com.example.callaccountingsystem.domain.mapping.TowerMapper;
import com.example.callaccountingsystem.exception.FieldAlreadyExistException;
import com.example.callaccountingsystem.repository.CityRepository;
import com.example.callaccountingsystem.repository.TowerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TowerService implements TowerServiceInterface {

    private final TowerRepository repository;
    private final CityRepository cityRepository;
    private final TowerMapper mapper;

    public TowerService(TowerRepository repository, CityRepository cityRepository, TowerMapper mapper) {
        this.repository = repository;
        this.cityRepository = cityRepository;
        this.mapper = mapper;
    }

    @Override
    public Page<Tower> getAllTowers(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<TowerEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public List<Integer> getAllListTowerId() {
        return repository.findAllById();
    }

    @Override
    public int getQuantityPages(int pageSize) {
        return repository.findAll().size() / pageSize + 1;
    }

    @Override
    public Tower get(Integer id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(Tower tower) {
        final City city = tower.getLocationCity();
        final Country country = tower.getLocationCity().getCountry();
        if (repository.findFirstByNameAndLocationCity_CityAndLocationCity_Country_Country(tower.getName().trim(),
                city.getCity().trim(), country.getCountry().trim()).isPresent()) {
            throw new FieldAlreadyExistException("Tower \"" + tower.getName() + "\" (" + country.getCountry()
                    + ", " + city.getCity() + ") already exists!");
        }
        final TowerEntity towerEntity = mapper.toDbo(tower);
        cityRepository.findFirstByCountry_CountryAndCity(country.getCountry().trim(),
                city.getCity().trim()).ifPresent(towerEntity::setLocationCity);
        repository.save(towerEntity);
    }

}
