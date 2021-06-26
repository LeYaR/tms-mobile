package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.PassportEntity;
import com.example.callaccountingsystem.domain.dto.Passport;
import com.example.callaccountingsystem.domain.mapping.PassportMapper;
import com.example.callaccountingsystem.repository.PassportRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class PassportService implements PassportServiceInterface {


    private final PassportRepository repository;
    private final PassportMapper mapper;

    public PassportService(PassportRepository repository, PassportMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<Passport> getAllPassports(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<PassportEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public Passport get(String id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(Passport passport) {
        repository.save(mapper.toDbo(passport));
    }

}
