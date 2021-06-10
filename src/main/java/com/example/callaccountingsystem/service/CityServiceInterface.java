package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.City;
import org.springframework.data.domain.Page;

public interface CityServiceInterface {

    Page<City> getAllCity(int currentPage, int pageSize);

    City get(Long id);

    void save(City city);

}
