package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.PricingUnitEntity;
import org.springframework.data.repository.CrudRepository;

public interface IPricingUnitRepo extends CrudRepository<PricingUnitEntity, Long> {
}
