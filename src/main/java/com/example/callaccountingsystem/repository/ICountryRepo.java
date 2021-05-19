package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CountryEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICountryRepo extends CrudRepository<CountryEntity, Long> {
}
