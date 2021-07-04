package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.StreetEntity;
import com.example.callaccountingsystem.domain.dto.Street;
import com.example.callaccountingsystem.domain.mapping.StreetMapper;
import com.example.callaccountingsystem.repository.StreetRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StreetService implements StreetServiceInterface {

    private final StreetRepository repository;
    private final StreetMapper mapper;

    public StreetService(StreetRepository repository, StreetMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<Street> getAllStreets(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<StreetEntity> page = repository.findAll(pageable);
        return page.map(mapper::fromDbo);
    }

    @Override
    public int getQuantityPages(int pageSize){
        return repository.findAll().size() / pageSize + 1;
    }

    @Override
    public Street get(Long id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(Street street) {
        repository.save(mapper.toDbo(street));
    }

}
