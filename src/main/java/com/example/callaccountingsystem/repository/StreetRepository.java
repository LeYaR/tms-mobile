package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.StreetEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreetRepository extends JpaRepository<StreetEntity, Long> {

    Page<StreetEntity> findAll(Pageable pageable);
}
