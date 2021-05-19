package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.ContractEntity;
import org.springframework.data.repository.CrudRepository;

public interface IContractRepo extends CrudRepository<ContractEntity, Long> {
}
