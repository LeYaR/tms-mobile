package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Country;
import org.springframework.data.domain.Page;

public interface CountryServiceInterface {

    Page<Country> getAllCountries(int currentPage, int pageSize);

}
