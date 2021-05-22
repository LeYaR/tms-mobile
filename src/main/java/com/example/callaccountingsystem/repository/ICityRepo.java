package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CityEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICityRepo extends CrudRepository<CityEntity, Long> {
}
