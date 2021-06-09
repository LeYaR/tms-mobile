package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.TowerEntity;
import com.example.callaccountingsystem.domain.dto.Tower;
import com.example.callaccountingsystem.domain.mapping.TowerMapper;
import com.example.callaccountingsystem.repository.TowerRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TowerService implements TowerServiceInterface {

    private final TowerRepository repository;
    private final TowerMapper mapper;

    public TowerService(TowerRepository repository, TowerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public Page<Tower> getAllTowers(int currentPage, int pageSize) {
        final Pageable pageable = PageRequest.of(currentPage - 1, pageSize);
        final Page<TowerEntity> page = repository.findAll(pageable);
        return page.map(towerEntity -> (mapper.fromDbo(towerEntity)));
    }

    @Override
    public List<Integer> getAllListTowerId() {
        return repository.findAllById();
    }

    @Override
    public Tower get(Integer id) {
        return mapper.fromDbo(repository.findById(id).get());
    }

    @Override
    public void save(Tower tower) {
        repository.save(mapper.toDbo(tower));
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
