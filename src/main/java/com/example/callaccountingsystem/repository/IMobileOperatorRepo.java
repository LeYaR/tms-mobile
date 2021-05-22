package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.MobileOperatorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMobileOperatorRepo extends CrudRepository<MobileOperatorEntity, Long> {
}
