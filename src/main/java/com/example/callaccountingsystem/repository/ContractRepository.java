package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.ContractEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContractRepository extends JpaRepository<ContractEntity, Long> {

    Page<ContractEntity> findAll(Pageable pageable);
}
