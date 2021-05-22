package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.StreetEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStreetRepo extends CrudRepository<StreetEntity, Long> {
}
