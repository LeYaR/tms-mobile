package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.MobileOperatorEntity;
import org.springframework.data.repository.CrudRepository;

public interface IMobileOperatorRepo extends CrudRepository<MobileOperatorEntity, Long> {
}
