package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.ClientTypeEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientTypeRepository extends JpaRepository<ClientTypeEntity, Long> {

    Page<ClientTypeEntity> findAll(Pageable pageable);
}
