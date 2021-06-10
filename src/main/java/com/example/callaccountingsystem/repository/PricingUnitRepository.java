package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.AddressEntity;
import com.example.callaccountingsystem.domain.dbo.PricingUnitEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PricingUnitRepository extends JpaRepository<PricingUnitEntity, Integer> {

    Page<PricingUnitEntity> findAll(Pageable pageable);
}
