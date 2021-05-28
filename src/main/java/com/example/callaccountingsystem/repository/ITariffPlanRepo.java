package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITariffPlanRepo extends JpaRepository<TariffPlanEntity, Long> {
}
