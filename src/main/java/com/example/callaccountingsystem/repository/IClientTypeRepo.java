package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.ClientTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientTypeRepo extends CrudRepository<ClientTypeEntity, Long> {
}
