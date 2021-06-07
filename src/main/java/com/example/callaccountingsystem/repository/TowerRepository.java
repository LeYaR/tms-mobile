package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.TowerEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TowerRepository extends JpaRepository<TowerEntity, Long> {

    Page<TowerEntity> findAll(Pageable pageable);

    @Query("SELECT t.id FROM TowerEntity t")
    List<Integer> findAllById();
}
