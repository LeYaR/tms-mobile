package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dto.Street;
import org.springframework.data.domain.Page;

public interface StreetServiceInterface {

    Page<Street> getAllStreets(int currentPage, int pageSize);

    Street get(Long id);

    void save(Street street);

    void delete(Long id);

}
