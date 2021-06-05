package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CurrencyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {

    Page<CurrencyEntity> findAll(Pageable pageable);
}
