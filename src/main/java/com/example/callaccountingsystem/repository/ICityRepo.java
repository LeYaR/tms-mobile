package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.CityEntity;
import org.springframework.data.repository.CrudRepository;

public interface ICityRepo extends CrudRepository<CityEntity, Long> {
}
