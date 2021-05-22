package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CurrencyEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICurrencyRepo extends CrudRepository<CurrencyEntity, Long> {
}
