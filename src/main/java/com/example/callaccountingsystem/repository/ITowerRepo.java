package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.TowerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITowerRepo extends CrudRepository<TowerEntity, Long> {
}
