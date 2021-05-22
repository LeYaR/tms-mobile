package com.example.callaccountingsystem.repository;

import com.example.callaccountingsystem.domain.dbo.TariffPlanEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITariffPlanRepo extends CrudRepository<TariffPlanEntity, Long> {
}
