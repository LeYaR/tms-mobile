package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.PricingUnitEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingUnitRepository extends JpaRepository<PricingUnitEntity, Long> {
}