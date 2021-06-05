package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CityEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<CityEntity, Long> {

    Page<CityEntity> findAll(Pageable pageable);
}
