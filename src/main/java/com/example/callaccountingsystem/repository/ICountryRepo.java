package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CountryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICountryRepo extends JpaRepository<CountryEntity, Long> {
}
