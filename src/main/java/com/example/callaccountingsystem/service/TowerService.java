package com.example.callaccountingsystem.service;

import com.example.callaccountingsystem.domain.dbo.TowerEntity;
import com.example.callaccountingsystem.domain.dto.Tower;
import com.example.callaccountingsystem.domain.mapping.TowerMapper;
import com.example.callaccountingsystem.repository.ITowerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TowerService implements ITowerService {

    private final ITowerRepo repository;

    public TowerService(ITowerRepo repository) {
        this.repository = repository;
    }

    @Override
    public List<Tower> getAllTowers() {
        final List<TowerEntity> list = repository.findAll();
        return TowerMapper.TOWER_MAPPER.listFromDbo(list);
    }

}
