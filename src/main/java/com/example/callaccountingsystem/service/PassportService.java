package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.PassportEntity;
import com.example.callaccountingsystem.domain.dto.Passport;
import com.example.callaccountingsystem.domain.mapping.PassportMapper;
import com.example.callaccountingsystem.repository.PassportRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassportService implements PassportServiceInterface {


    private final PassportRepository repository;

    public PassportService(PassportRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Passport> getAllPassports() {
        final List<PassportEntity> list = repository.findAll();
        return PassportMapper.PASSPORT_MAPPER.listFromDbo(list);
    }

}
