package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepo extends JpaRepository<CityEntity, Long> {
}
