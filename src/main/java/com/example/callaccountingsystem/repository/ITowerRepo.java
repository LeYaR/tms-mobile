package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.TowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITowerRepo extends JpaRepository<TowerEntity, Long> {
}
