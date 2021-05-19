package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.TowerEntity;
import org.springframework.data.repository.CrudRepository;

public interface ITowerRepo extends CrudRepository<TowerEntity, Long> {
}
