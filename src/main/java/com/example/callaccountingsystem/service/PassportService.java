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
    private final PassportMapper mapper;

    public PassportService(PassportRepository repository, PassportMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Passport> getAllPassports() {
        final List<PassportEntity> list = repository.findAll();
        return mapper.listFromDbo(list);
    }

}
