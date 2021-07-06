package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CurrencyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends JpaRepository<CurrencyEntity, Long> {

    Page<CurrencyEntity> findAll(Pageable pageable);

    Optional<CurrencyEntity> findFirstByCodeAndAndNumericalCodeAndName(String code, Integer NumericalCode, String name);

}
