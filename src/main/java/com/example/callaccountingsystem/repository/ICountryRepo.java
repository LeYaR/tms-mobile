package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CountryEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepo extends CrudRepository<CountryEntity, Long> {
}
