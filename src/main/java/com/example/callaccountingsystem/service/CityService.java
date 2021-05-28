package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.CityEntity;
import com.example.callaccountingsystem.domain.dto.City;
import com.example.callaccountingsystem.domain.mapping.CityMapper;
import com.example.callaccountingsystem.repository.ICityRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CityService implements ICityService{

    private final ICityRepo repository;

    public CityService(ICityRepo repository) {this.repository = repository;}

    @Override
    public List<City> getAllCity(){
        final List<CityEntity> list = repository.findAll();
        List<City> cities = new ArrayList<>();
        list.forEach((cityEntity -> cities.add(CityMapper.CITY_MAPPER.fromDbo(cityEntity))));
        return cities;
    }
}
