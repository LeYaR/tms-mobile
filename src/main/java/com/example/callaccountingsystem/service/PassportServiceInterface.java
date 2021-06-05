package com.example.callaccountingsystem.service;


import com.example.callaccountingsystem.domain.dto.Passport;
import org.springframework.data.domain.Page;

public interface PassportServiceInterface {

    Page<Passport> getAllPassports(int currentPage, int pageSize);

}

