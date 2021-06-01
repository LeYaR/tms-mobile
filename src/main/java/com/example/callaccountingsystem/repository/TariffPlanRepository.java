package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TariffPlanRepository extends JpaRepository<TariffPlanEntity, Long> {
}
