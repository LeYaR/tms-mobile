package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CurrencyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurrencyRepo extends JpaRepository<CurrencyEntity, Long> {
}
